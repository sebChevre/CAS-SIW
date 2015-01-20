var vertx = require('vertx');
var http = require('vertx/http');
var container = require('vertx/container');
var eventBus = require('vertx/event_bus');
var config = container.config;
var logger = container.logger;

logger.info('[rest_server.js - ' + new Date() + '] Starting Rest WebServer, conf: ' + JSON.stringify(config));

//handlers
load('js/handler/security_handler.js');
load('js/handler/mongodb_handler.js');
load('js/handler/users_handler.js');
load('js/handler/tracks_handler.js');

//js utilitaires
load('js/XMLWriter.js');
load('js/constants.js');
load('js/base64.js');
load('js/md5.js');


var port = config.port;
var host = config.host;

var server;

if(config.ssl){
	logger.info("okok_ssl");
	server = vertx.createHttpServer()
		.ssl(true)
		.keyStorePath('keystore/server-keystore.jks')
		.keyStorePassword('esteban11');
	port = config.ssl_port;
	//appConstant.MAIN_URL = 'https://' + host + '/' + port;
	
}else{
	logger.info("okok");
	//appConstant.MAIN_URL = 'http://' + host + '/' + port;
	server = vertx.createHttpServer();
}



//var server = vertx.createHttpServer().ssl(true).keyStorePath('keystore/server-keystore.jks').keyStorePassword('esteban11');

var routeMatcher = new http.RouteMatcher();

//liste des utilisateurs (format json par défaut, xml, wjson, wxml), --> authentification avec utilisateur
routeMatcher.get('/users(.json|.xml|.wjson|.wxml|)$',function (request) {
	 log('Incoming request[GET:/users]: ' + request.path());
	 users_handler.getUsers(request);
});

//ajout d'un utilisateur
routeMatcher.post('/users',function (request) {
	log('Incoming request[POST:/users]: ' + request.path());
	users_handler.postUser(request);
	
});

routeMatcher.get('/users/:id',function (request) {
	log('Incoming request[GET:/users/:id]: ' + request.path());
	users_handler.getUserByUserId(request);
	
});

routeMatcher.get('/users/:id/tracks', function (request) {
	log('Incoming request[GET:/users/:id/tracks]: ' + request.path());
	tracks_handler.handleTrackReadByUser(request);
});

routeMatcher.post('/users/:id/tracks', function (request) {
	log('Incoming request[POST:/users/:id/tracks]: ' + request.path());
	tracks_handler.handleTrackAddForUser(request);
});

//************* API, point d'entrée, js et css
routeMatcher.get('/api', function (request) {
	log('Incoming request[POST:/users/:id/tracks]: ' + request.path());
	request.response.sendFile("web/api.html");
});
routeMatcher.get('/api.*', function (request) {
	log('Incoming request[POST:/users/:id/tracks]: ' + request.path());
	request.response.sendFile("web/" + request.path());
});

routeMatcher.get('.*',function (request) {
	request.response.statusCode(404).end();
});

//Demarrage du serveur http
server.requestHandler(routeMatcher).listen(port,host, function (error) {
	if(!error){
		log('Server stating listenning...[' + host + ':' + port + ']');
	}else{
		log('error starting server:' + error);
	}
});

var log = function (message,isError) {
	logger.info('[rest_server.js - ' + new Date() + ']' + message);
}
