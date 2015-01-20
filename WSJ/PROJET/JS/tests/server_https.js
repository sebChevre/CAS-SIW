var vertx = require('vertx')
var server = vertx.createHttpServer().ssl(true).
keyStorePath('server-keystore.jks').
keyStorePassword('esteban11');
var console = require('vertx/console')
load('base64.js');

server.requestHandler(function(req) {

	var authorization = 'c2ViOmVzdGViYW4xMQ==';//seb:esteban11
	
	

	var base64Authorization = ""+req.headers().get('Authorization');
	console.log(base64Authorization);
	
	if(base64Authorization !== 'undefined'){
		console.log('rer');
		//console.log(""+base64Authorization);
		var base64UserPass =  base64Authorization.split(' ')[1];
		var base64Decode = Base64.decode(base64UserPass);
		console.log(""+base64Decode);
		
		if(base64UserPass === authorization){
			console.log('ok');
			req.response.end("<html><body><h1>Hello from vert.x!</h1></body></html>");
		}else{
			req.response.putHeader('WWW-Authenticate','Basic realm="Authentification"');
			req.response.statusCode(401).end();
		}
	}else{
			req.response.putHeader('WWW-Authenticate','Basic realm="Authentification"');
			req.response.statusCode(401).end();
	}
	
	
	
	
	
	
	
}).listen(4443, 'localhost');