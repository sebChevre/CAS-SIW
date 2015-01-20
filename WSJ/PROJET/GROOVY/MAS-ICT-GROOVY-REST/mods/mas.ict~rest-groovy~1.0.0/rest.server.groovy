
import classe.*;
import classe.httphandler.*;
import groovy.json.*;
import org.vertx.groovy.platform.Verticle;
import org.vertx.groovy.core.http.RouteMatcher;

//import vertx
def eb = vertx.eventBus;
//def logger = container.logger;
def config = container.config;
def routeMatcher = new RouteMatcher();

def port
def host = config.host
def server;

def controller = new Controller();

controller.with{
	eventBus 	= eb
	logger 		= container.logger
}

println "controller: $controller.eventBus"
//lecture de la config - démarrage du serveur
if(config.isssl){
	port = config.ssl.port
	
	server = vertx.createHttpServer()
		.setSSL(true)
		.setKeyStorePath('keystore/server-keystore.jks')
		.setKeyStorePassword('esteban11');
}else{
	port = config.http.port
	server = vertx.createHttpServer()
}

//handler démarrage du server
server.requestHandler(routeMatcher.asClosure()).listen(port, host){ result -> 
	if(result.succeeded){
		container.logger.info("Server starting successfully. Listening [$host:$port]")
	}else{
		logger.error("Error during server start [$host:$port]")
		container.exit();
	}
}


/*
Liste des utilisateurs
Ressource reprsentation: xml (défaut), json
Code erreur: 401: Unauthorized, 200 OK, 503: Service unavailable
*/
routeMatcher.get('/users(.json|.xml|)$') {request->
	container.logger.info ("Incoming request[GET:/users]: $request.path");
	
	controller.dispatchGet(request,{
		eb.send("users.list",[]){response ->
			ResponseBuilder.buildForUsersList(request, response.body)
	 	}
	}); 
};

/*
Détail d'un utilisateur
Ressource reprsentation: xml (défaut), json
Code erreur: 401: Unauthorized, 200 OK, 503: Service unavailable
*/
routeMatcher.get('/users/:id(.json|.xml|)$') {request->
	container.logger.info ("Incoming request[GET:/users/:id]: $request.path");
	
	controller.dispatchGet(request,{
		
		def userId = request.getParams().get('id').tokenize('.')[0]
		
		eb.send("users.read",["_id":userId]){response ->
			ResponseBuilder.buildForUserRead(request, response.body)
	 	}
	}); 
	
};



/*
Ajout d'un utilisateur
Code erreur: 401: Unauthorized, 200 OK, 503: Service unavailable, 404: Ressourcenot found (invalid data, user exist)
*/
routeMatcher.post('/users(.json|.xml|)$') {request->
	
	container.logger.info ("Incoming request[POST:/users]: $request.path");
	
	request.bodyHandler{body->
		def slurper = new JsonSlurper()
		def result = slurper.parseText(body.toString())
		
		User user = new User(username : result.username,password : result.password)
		
		controller.dispatchPost(request,{
			eb.send("users.check",user.toJson()){response ->
						 
				println "rest server add callback: $response.body"
				ResponseBuilder.buildForUserAdd(request, response.body)
			}
		}); 
	}	
};

/*
Liste des trajets indépendemment des utilisateurs
Ressource reprsentation: xml (défaut), json
Code erreur: 401: Unauthorized, 200 OK, 503: Service unavailable
*/
routeMatcher.post('/users/:id/tracks(.json|.xml|)$') {request->
	container.logger.info ("Incoming request[POST:/users/:id/tracks]: $request.path");
	
	request.bodyHandler{body->
		def slurper = new JsonSlurper()
		def result = slurper.parseText(body.toString())
		
		Track track = new Track(name : result.name,description : result.description, date: result.date, userid:result.userid)
		println(track)
		controller.dispatchPost(request,{
			eb.send("tracks.check",track.toJson()){response ->
						 
				println "rest server add callback: $response.body"
				ResponseBuilder.buildForTrackAdd(request, response.body)
			}
		}); 
	}	
	
};

/*
Ajout d'un utilisateur
Code erreur: 401: Unauthorized, 200 OK, 503: Service unavailable, 404: Ressourcenot found (invalid data, user exist)
*/
routeMatcher.get('/users/:id/tracks(.json|.xml|)$') {request->
	
	container.logger.info ("Incoming request[GET://users/:id/tracks]: $request.path");
	
	def userId = request.getParams().get('id').tokenize('.')[0]
	
	eb.send("tracks.list",["userid":userId]){response ->
		ResponseBuilder.buildForTrackList(request, response.body)
 	}
};





