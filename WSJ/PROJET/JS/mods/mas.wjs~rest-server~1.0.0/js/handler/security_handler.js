security_handler = {

	handleDigestErrorResponseByRepresentation : function (request,representation,result) {
		
		
		
		if(result === undefined){
			result = {};
			result.error = 'Authentification failed';
			result.data = 'Authentification failed';	
				
			
		}
		
		request.response.putHeader('WWW-Authenticate','Basic realm="Authentification"');
		request.response.statusCode(401);//.end('Authentification failed');
		request.response.statusMessage('Authentification failed');
		
		switch(representation){
		
			case 'xml':
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			   	request.response.end();		    
			break;
			
			case 'wxml':
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
				request.response.end(this.toXml(result));
			   			
			break;
			
			case 'json':
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
				request.response.end();	
			break;
			
			case 'wjson':
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
			    request.response.end(this.toJson(result));
			break;
			
		}

	},
	toXml : function (result) {
		 var xmlProlog = '<?xml version="1.0" encoding="UTF-8"?>';
		 var xml = new XMLWriter();
		 xml.BeginNode('response');
		 xml.BeginNode('code');
		 xml.WriteString('401');
		 xml.EndNode('code');
		 xml.BeginNode('status');
		 xml.WriteString('fail');
		 xml.EndNode('status');
		 xml.BeginNode('message');
		 xml.WriteString(result.error);
		 xml.EndNode('message');
		 xml.BeginNode('data');
		 xml.WriteString(result.data);
		 xml.EndNode('data');
		 xml.EndNode('response');
		 return xmlProlog + xml.ToString();
	},
	toJson : function (result) {
		var response = {};
		response.code = 401;
		response.status = 'fail';
		response.message = result.error;
		response.data = result.data;
		return JSON.stringify(response,null,4);
	},
	sendWithAuthorization : function (request, sucessHandler,representation) {
		var that = this;
				
		var base64Authorization = ""+request.headers().get('Authorization');
		that.log('Authentification http: ' + base64Authorization);
	
		//header authorization présent
		if(base64Authorization !== 'undefined'){
			that.log('Header Authorization defined');
			//decodage
			var base64UserPass =  base64Authorization.split(' ')[1];
			var base64Decode = Base64.decode(base64UserPass);
			var username = base64Decode.split(':')[0];
			var password = base64Decode.split(':')[1];
			

			
			if(username === config.admin_user.user 
				&& password === config.admin_user.pass){
				sucessHandler(request);
			}else{
				eventBus.send('user.read', {'username':username}, function(result){
       		
	       			
	       			that.log('Check user read for password');
		       		var user = result;
		       		
		       		var found = false;
		       		that.log(JSON.stringify(result));
		       		
		       		
		       		if(result.length > 0){
			       		if(""+result[0].password === ""+CryptoJS.MD5(password)){
			       			that.log('Check Authorization ok');
				       		sucessHandler(request);
				       	}else{
			       			that.log('Check Authorization fail');
				       		that.handleDigestErrorResponseByRepresentation(request,representation,result);
			       		}
		       		}else{
		       			that.handleDigestErrorResponseByRepresentation(request,representation,result);

		       		}       			       			   
		   		});
			}

		}else{
			that.log('Check Authorization fail - Authorization undefined')
			that.handleDigestErrorResponseByRepresentation(request,representation);
		}

	},
	log : function (message) {
		logger.info('[security_handler.js - ]' + new Date() + '] ' + message);
	}
}