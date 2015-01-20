users_handler = {
	
	//***********************************************
	//Traitement du retour de tous les utilisateurs
	// --> point d'entrée du service pour la liste
	// /user
	//***********************************************
	getUsers : function (request) {
		
		var ressourceRepresentation = this.getRessourceRepresentationByPath(request.path());
		var that = this;
		
		that.log('handle users list, representation: ' + ressourceRepresentation);
		
			security_handler.sendWithAuthorization (request,
		
			function (request) {
				that.log('Authentified. callback');
				
				eventBus.send('users.list', {}, function(result){
	       		
	       			that.log('Users list response received');
	       			
	       			if(result.status === 'ok'){
		       			request.response.statusCode(200);
			   			request.response.putHeader('Connection','keep-alive');
			   			request.response.putHeader('Content-Language','fr');
			   			request.response.putHeader('Date',new Date());
			   			request.response.putHeader('Server','vertx 2.0');
		       		
			   			that.handleResponseByRepresentation(request,result.data,ressourceRepresentation,false);
	       			}else if(result.status === 'ko'){
		       			
			   			mongodb_handler.handleErrorResponseByRepresentation(request,result,ressourceRepresentation);
	       			}
	       			
		       		
		      });
			
			
		},ressourceRepresentation);
	},
	//***********************************************
	//Affichge du déatil d'un utilisateur	
	// --> point d'entrée du service pour le détail des utilisateurs
	// /user/:id
	//***********************************************
	getUserByUserId : function (request) {
	
		var ressourceRepresentation = this.getRessourceRepresentationByPath(request.path());
		var that = this;
		var id = that.exractUserId(request.params().get('id'));
		
		that.log('handle users detail, representation: ' + ressourceRepresentation);
		
		eventBus.send('user.read', {'_id':id}, function(result){
       		
       		var ressourceRepresentation = that.getRessourceRepresentationByPath(request.path());
			
       		request.response.statusCode(200);
       		request.response.putHeader('Connection','keep-alive');
       		request.response.putHeader('Content-Language','fr');
       		request.response.putHeader('Date',new Date());
       		request.response.putHeader('Server','vertx 2.0');
       		
       		var user = result[0];//premier résultat de la liste

       		that.handleResponseByRepresentation(request,user,ressourceRepresentation,true);
	     });

	
	},
	//***********************************************
	//Ajout d'un utilisateur	
	// --> point d'entrée du service pour l'ajout d'un utilisateur
	// /user
	//***********************************************
	postUser : function (request) {
		var jsonObj;
		var that = this;
		
		request.bodyHandler(function (data) {
			
			//erreur propriété minimale
			if(!that.isUserJsonOk(data)){
				that.log('Données incomplètes ou invalide');
				request.response.statusCode(404).statusMessage('Invalid data').end('Invalid data');
			}else{
				//pasing et conversion string
				var objToSave = that.parseJsonUserObject(data);
								
				var obj = {};
				obj.username = JSON.parse(objToSave).username;
				
				
				//Check si user pas existant
				eventBus.send('user.count', obj,function(result){
					
					
					
					if(result > 0){
						that.log('User exist');
						request.response.statusCode(404).statusMessage('User exist').end();
					}else{
						
						eventBus.send('user.save', objToSave, function(result){
	       			
			       			request.response.putHeader('Connection','close');
			       			request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
			       			
			       			if(result.status === 'ok'){
			       				
			       				request.response.putHeader('Location',appConstant.MAIN_URL + '/users/'+result.data._id);
			       				var userObj = JSON.parse(objToSave);
			       				userObj._id = result.data._id;

								request.response.statusCode(201).statusMessage('Created').end(JSON.stringify(userObj));
			       				
			       			}else if(result.status === 'ko'){
				       			request.response.statusCode(404).statusMessage(result.errorMsg).end();
			       			}
			       			
				   		});
					}
				});
				
				
			}
			
			
		});
	},


	handleResponseByRepresentation : function (request,result,representation,forDetail) {
		
		switch(representation){
		
			case 'xml':
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			    if(forDetail){
				    request.response.end(this.userToXml(result,false));
			    }else{
				    request.response.end(this.usersListToXml(result,false));
			    }
			    
			break;
			
			case 'wxml':
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			    if(forDetail){
				    request.response.end(this.userToXml(result,true));
			    }else{
				    request.response.end(this.usersListToXml(result,true));
			    }			
			break;
			
			case 'json':
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
				if(forDetail){
				    request.response.end(this.userToJson(result,false));
			    }else{
				    request.response.end(this.usersListToJson(result,false));
			    }	
			    
			break;
			
			case 'wjson':
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
			    if(forDetail){
				    request.response.end(this.userToJson(result,true));
			    }else{
				    request.response.end(this.usersListToJson(result,true));
			    }				
			break;
			
		}
	},
	
	//***********************************************
	//Retourne la représentation désirée de la ressource
	//Ne peut pas être null
	//***********************************************
	getRessourceRepresentationByPath : function (path) {
		var splitPath = path.split('.');
	
		if(splitPath.length == 1){
			return 'json';
		}else if(splitPath.length == 2){
			var res = splitPath[1];
			
			return res;
		}
	},
	usersListToXml : function (obj,wrapped) {
	
		var xmlProlog = '<?xml version="1.0" encoding="UTF-8"?>';
		var xml = new XMLWriter();
		if(wrapped){
			xml.BeginNode('response');
			xml.BeginNode('code');
			xml.WriteString('200');
			xml.EndNode('code');
			xml.BeginNode('status');
			xml.WriteString('success');
			xml.EndNode('status');
		}
		
		xml.BeginNode('data');
		for(user in obj){
			xml.BeginNode('user');
			xml.Attrib('detail',appConstant.MAIN_URL + '/users/' + obj[user]._id);
			xml.BeginNode('id');
			xml.WriteString(obj[user]._id);
			xml.EndNode('id');
			xml.BeginNode('username');
			xml.BeginNode('password');
			xml.WriteString(obj[user].password);
			xml.EndNode('password');
			xml.WriteString(obj[user].username);
			xml.EndNode('username');
			xml.EndNode('user');
		}
		xml.EndNode('data');
		
		if(wrapped){
			xml.EndNode('response');
		}
		
		
		return(xmlProlog + xml.ToString());
	},
	userToXml : function (user,wrapped) {

		
		
		var xmlProlog = '<?xml version="1.0" encoding="UTF-8"?>';
		var xml = new XMLWriter();

		if(wrapped){
			xml.BeginNode('response');
			xml.BeginNode('code');
			xml.WriteString('200');
			xml.EndNode('code');
			xml.BeginNode('status');
			xml.WriteString('success');
			xml.EndNode('status');
		}
		xml.BeginNode('data');
		xml.BeginNode('user');
		xml.BeginNode('id');
		xml.WriteString(user._id);
		xml.EndNode('id');
		xml.BeginNode('username');
		xml.WriteString(user.username);
		xml.EndNode('username');
		xml.BeginNode('password');
		xml.WriteString(user.password);
		xml.EndNode('password');
		xml.EndNode('user');
		xml.EndNode('data');
		
		if(wrapped){
			xml.EndNode('response');
		}

		return(xmlProlog + xml.ToString());
	},
	isUserJsonOk : function (data) {
		
		//parsing en objet
		var obj = JSON.parse(data);
		
		
		//propriété minmale username
		return ('username' in obj && 'password' in obj);
	},
	parseJsonUserObject : function (jsonStrData) {
		//conversion objet
		var objData = JSON.parse(jsonStrData);
		//Cretion objet a persister
		var objDataToSend = {};
		//on set la propriété
		objDataToSend.username = objData.username;
		objDataToSend.password = objData.password;
		//on revoi json string
		return JSON.stringify(objDataToSend);
	},
	//Décompose le path pour récupérer l'id uniquement
	exractUserId : function (requestId) {
		
		var id = requestId.split('.')[0];
		
		return id;
	},
	usersListToJson :function (objUserList,wrapped) {
		var objReturn = {};
		
		
		for(var user in objUserList){
			objUserList[user].detail = appConstant.MAIN_URL + '/users/' + objUserList[user]._id;
			
		}
		
		if(wrapped){
			var response = {};
			response.code = 200;
			response.status = 'sucess';
			response.data = objUserList;
			objReturn.response = response;
			log(JSON.stringify(objReturn,null,4));
			return JSON.stringify(objReturn,null,4);
		}else{
			objReturn.data = objUserList;
			log(JSON.stringify(objReturn,null,4));
			return JSON.stringify(objReturn,null,4)
		}
	},
	userToJson : function (user,wrapped) {
		var objReturn = {};
		
		if(wrapped){
			var response = {};
			response.code = 200;
			response.status = 'sucess';
			response.data = user;
			objReturn.response = response;
			log(JSON.stringify(objReturn,null,4));
			return JSON.stringify(objReturn,null,4);
		}else{
			objReturn.data = user;
			log(JSON.stringify(objReturn,null,4));
			return JSON.stringify(objReturn,null,4)
		}
	},
	log : function (message) {
		logger.info('[user_handler.js - ' + new Date() + '] ' + message);
	}

}