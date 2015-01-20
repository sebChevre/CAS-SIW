tracks_handler = {
	
	handleTrackReadByUser : function (request) {
		var ressourceRepresentation = this.getRessourceRepresentationByPath(request.path());
		var that = this;
		
		var userId = request.params().get('id');
		
		that.log('handle tracks list for userid: '+userId+' , representation: ' + ressourceRepresentation);
		
		eventBus.send('users.tracks', {user_id:userId}, function(result){
	       		
	       			that.log('Tracks list response received')
		       		request.response.statusCode(200);
		       		request.response.putHeader('Connection','keep-alive');
		       		request.response.putHeader('Content-Language','fr');
		       		request.response.putHeader('Date',new Date());
		       		request.response.putHeader('Server','vertx 2.0');
		       		
		       		if(ressourceRepresentation === 'xml'){
			       		request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			       		request.response.end(that.convertTrackListToXml(result));
		       		}else{
			       		request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
			       		request.response.end(JSON.stringify(that.buildJsonForList(result), null, 4));
		       		}
		      });

	},
	handleTrackAddForUser : function (request) {
		
		var that = this;
		
		request.bodyHandler(function (data) {
			
			var userId = request.params().get('id');
			//console.log('getting tracks for user id: ' + userId);
			
			
			var objToSave = that.parseJsonUserObject(data,userId);
			
			eventBus.send('track.save', objToSave, function(result){
	       			
				request.response.putHeader('Connection','close');
			    request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
			    console.log(JSON.stringify(objToSave));
			    if(result.status === 'ok'){
			       				
			    	request.response.putHeader('Location',appConstant.MAIN_URL + '/users/' + result.data.userid + '/tracks/' + result.data._id);
			       	var userObj = JSON.parse(objToSave);
			       	userObj._id = result.data._id;
			       	console.log(userObj._id);
					request.response.statusCode(201).statusMessage('Created').end(JSON.stringify(userObj));
			       				
			    }else if(result.status === 'ko'){
				    request.response.statusCode(404).statusMessage(result.errorMsg).end();
			    }
			       			
			});
		});
	},
	parseJsonUserObject : function (jsonStrData,userId) {
		//conversion objet
		var objData = JSON.parse(jsonStrData);
		//Cretion objet a persister
		var objDataToSend = {};
		//on set la propriété
		objDataToSend.name = objData.name;
		objDataToSend.date = objData.date;
		objDataToSend.description = objData.description;
		objDataToSend.userid = userId;
		//on revoi json string
		return JSON.stringify(objDataToSend);
	},
	getRessourceRepresentationByPath : function (path) {
		var splitPath = path.split('.');
	
		//console.log("SP"+splitPath);
		if(splitPath.length == 1){
			return 'json';
		}else if(splitPath.length == 2){
			var res = splitPath[1];
			if(res == 'xml'){
			return 'xml';
			}else if(res == 'json'){
				return 'json';
			}else{
				return null;
			}
		}
	},
	buildJsonForList :function (objTrackList) {
		var objReturn = objTrackList;
		
		for(var track in objTrackList.tracks){
			objTrackList.tracks[track].detail = appConstant.MAIN_URL + '/users/' + objTrackList.tracks[track]._id;
			//console.log("track");
			//console.log(JSON.stringify(track));
		}
		
		logger.info(JSON.stringify(objReturn));
		
		return objReturn;
		
	},
	log : function (message) {
		logger.info('[trackService.js]-' + message);
	}


}