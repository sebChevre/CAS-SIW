var vertx = require('vertx');
var console = require('vertx/console');
var container = require('vertx/container');
var eventBus = require('vertx/event_bus');

//container.deployModule('io.vertx~mod-mongo-persistor~2.1.0-SNAPSHOT');

// Inspired from Sinatra / Express
var rm = new vertx.RouteMatcher();

//creation du serveur
var server = vertx.createHttpServer();



// Extract the params from the uri
rm.get('/details/:user/:id', function(req) {
	req.response.end("User: " + req.params().get('user') + " ID: " + req.params().get('id'))
});

rm.get('/user/add', function (req){
	eventBus.send('users.save', {name: "test", surnam: "test"}, function(result){
    	console.log(result);
    	
    	if(result.status == 'ok'){
	    	console.log(result.data._id);
			req.response.end("User saving: " + JSON.stringify(result.data));
    	}else if(result.status == 'ko'){
	    	req.response.end("ERROR: " + result.cause);
    	}
    	
    });
});

rm.post('/user/add', function (req){

	//console.log("sas " + req.bodyHandler());
	
	req.bodyHandler(function (b) {
		console.log(b);
	})
	//console.log(JSON.stringify(req.params()))
	//console.log(JSON.stringify(req));
	/*eventBus.send('users.save', {name: "test", surnam: "test"}, function(result){
    	console.log(result);
    	
    	if(result.status == 'ok'){
	    	console.log(result.data._id);
			req.response.end("User saving: " + JSON.stringify(result.data));
    	}else if(result.status == 'ko'){
	    	req.response.end("ERROR: " + result.cause);
    	}
    	
    });*/
    req.response.end("ERROR: ");
});

rm.get('/index',function(req){
	req.response.sendFile("web/index.html");
});

rm.post('/postTest',function (req) {
	req.response.end('post...')
});

// Catch all - serve the index page
rm.get('.*', function(req) {
	console.log('404a');
	req.response.sendFile("web/error404.html");
});


//Demarrage du serveur en écoute
server.requestHandler(rm).listen(9090,'localhost', function (error) {
	if(!error){
		console.log('Server stating listenning...on port:9090');
	}else{
		console.log('error:' + error);
	}
});

container.deployModule("io.vertx~mod-mongo-persistor~2.0.0-final",{
	address: "activity.track.persistence",
	db_name: "test"
});

container.deployVerticle('services/users.save.js');