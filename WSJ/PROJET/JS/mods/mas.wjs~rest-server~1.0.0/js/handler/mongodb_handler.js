mongodb_handler = {
	
	handleErrorResponseByRepresentation : function (request,result,representation) {
		
		switch(representation){
		
			
		
			//reponse non wrapper, body vide
			case 'xml':
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			case 'json':
				this.defineHeader(request);
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
				request.response.end();
			break;
			
			//reponse wrappper
			case 'wxml':
				this.defineHeader(request);
				request.response.putHeader('Content-Type', 'application/xml; charset=utf-8');
			    
			    var xmlProlog = '<?xml version="1.0" encoding="UTF-8"?>';
			    var xml = new XMLWriter();
			    xml.BeginNode('response');
				xml.BeginNode('code');
				xml.WriteString('503');
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
			    request.response.end(xmlProlog + xml.ToString());
			break;
			
			
			
			case 'wjson':
				this.defineHeader(request);
				request.response.putHeader('Content-Type', 'application/json; charset=utf-8');
				var response = {};
			   	response.code = 503;
			   	response.status = 'fail';
			   	response.message = result.error;
			   	response.data = result.data;
			   	request.response.end(JSON.stringify(response,null,4));
			    
			break;
		
		}

	},
	defineHeader : function (request) {
		request.response.statusCode(503);
		request.response.putHeader('Connection','keep-alive');
		
		request.response.putHeader('Content-Language','fr');
		request.response.putHeader('Date',new Date());
		request.response.putHeader('Server','vertx 2.0');
	}
}