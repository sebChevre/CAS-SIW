var vertx = require('vertx');
var http = require('vertx/http');
var container = require('vertx/container');
var console = require('vertx/console');

var port = 8888;
var host = 'localhost';
load('js/base64.js');



//creation du serveur
var server = vertx.createHttpServer();

var routeMatcher = new http.RouteMatcher();
var httpClient = new http.HttpClient();


routeMatcher.get('/main', function(request) {
    
    request.response.sendFile('web/index.html');
    
     
});

routeMatcher.get('/userDetail/:id', function(request) {
    
    request.response.sendFile('web/index.html');
    
     
});

routeMatcher.get('.*\\.(css|js)$', function (request) {
	console.log(request.path());
	request.response.sendFile('web' + request.path());
});

routeMatcher.post('/userAdd', function(request) {
	request.expectMultiPart(true);
	
	
	request.endHandler(function() {
    
		var attrs = request.formAttributes();
		
		var postData = createJsonData(request.formAttributes());
		console.log(postData);
		vertx.createHttpClient().port(9999).host('localhost').post('/users', function(resp) {
			//console.log("Got response " + resp.statusCode());
			//console.log(resp.headers().get('Location'));
			request.response.statusCode(resp.statusCode());
			request.response.statusMessage(resp.statusMessage());
			request.response.putHeader('Location',resp.headers().get('Location'));
			request.response.end();
			
			//request.response.end(resp.body());
			//resp.bodyHandler(function(body) {
			//	console.log("Got data " + body);
			//})
		}).chunked(true).write(postData).end();
		
		//request.response.statusCode(200).statusMessage('ok').end();
	});
});

routeMatcher.get('/usersList', function (request) {
	
	var httpClient = vertx.createHttpClient().port(9999).host('localhost');
	
	var req = httpClient.get("/users", function(response) {
	    console.log("Got response: " + response.statusCode());
	    response.bodyHandler(function(body) {
			var htmlBody  = '<body>'
			request.response.statusCode(200).statusMessage('ok').end(body);
		});
	  
	});

	var authorizationHeaderStr = 'Basic ' + Base64.encode('root:root');
	req.headers().add("Authorization", authorizationHeaderStr);

	req.end();
	
	/*vertx.createHttpClient().port(9999).host('localhost').getNow('/users', function(resp) {
			console.log("Got response " + resp.statusCode());
			resp.bodyHandler(function(body) {
				request.response.statusCode(200).statusMessage('ok').end('<pre>' + body + '</pre>');
			})
		});
	*/
	
});
function createJsonData (postAttributes) {
	
	var dataObj = {};
	
	postAttributes.forEach(function (entry,index) {
		dataObj[entry] = index;
		console.log(index);
	});
	
	return JSON.stringify(dataObj);
}

routeMatcher.get('.*', function(request) {
    request.response.statusCode(404);
	request.response.statusCode(404).statusMessage('fail').end();
});

//Demarrage du serveur en écoute
server.requestHandler(routeMatcher).listen(port,host, function (error) {
	if(!error){
		console.log('Server stating listenning...on port:' + port);
	}else{
		console.log('error:' + error);
	}
});

 