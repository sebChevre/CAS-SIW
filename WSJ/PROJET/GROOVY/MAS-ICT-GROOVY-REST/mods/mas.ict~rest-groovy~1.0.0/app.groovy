import groovy.json.*;
def logger = container.logger;
def config = container.config;
def eb = vertx.eventBus;

//Déploiememnt du serveur web rest
container.deployVerticle("rest.server.groovy",config) { result ->
    deployAsyncHandler("rest.server.groovy",result,logger);
}      

//Déploiement mongo db module
def mongoConfig = [address : "activity.tracks.persistence",db_name : "mas-wsj"];
		
container.deployModule("io.vertx~mod-mongo-persistor~2.0.0-final",mongoConfig){deployResult ->
	 deployMongoAsyncHandler("io.vertx~mod-mongo-persistor~2.0.0-final",deployResult,logger,config,eb);
};

//Déploiements des services de persistences
container.deployVerticle("services/users.services.groovy"){ deployResult->
   	deployAsyncHandler("users.services.groovy",deployResult,logger);
}
container.deployVerticle("services/tracks.services.groovy"){ deployResult->
   	deployAsyncHandler("tracks.services.groovy",deployResult,logger);
}

//Déploiements des services d'authentification
container.deployVerticle("services/authentification.services.groovy"){ deployResult->
   	deployAsyncHandler("authentification.services.groovy",deployResult,logger);
}


//handler asynchrone gérant le resultat du déploiment des modules
def deployAsyncHandler(moduleName,deployResult,logger){
    //def logger = container.logger;
	if (deployResult.succeeded) {
    	logger.info("$moduleName successfully deployed")
    } else {
    	logger.error("Error during deploying $moduleName")
	 	logger.info (deployResult.cause().printStackTrace())
		container.exit();
    }
}

//handler asynchrone gérant le resultat du déploiment des modules
def deployMongoAsyncHandler(moduleName,deployResult,logger,config,eb){
    //def logger = container.logger;
	if (deployResult.succeeded) {
    	logger.info("$moduleName successfully deployed")
		
		if(config.init_data){
			logger.info "droping database, and insert data..."
			
			eb.send('activity.tracks.persistence',[
				action: 'command',  
				command: "{dropDatabase: 1}"
			]){result->
				logger.info("Databse successfully dropped...")
				insertRootUser(eb,logger)
			}
		}
    } else {
    	logger.error("Error during deploying $moduleName")
	 	logger.info (deployResult.cause().printStackTrace())
		container.exit();
    }
}

def insertRootUser (eb,logger) {

	eb.sendWithTimeout("activity.tracks.persistence",[
			action: 'save', 
			collection: 'users',
			document:[username:"root",password:"63a9f0ea7bb98050796b649e85481845"]],2000){result->
				logger.info(result)
				if(result.succeeded){
					logger.info "User root successfully added"
				}else{
					logger.error("message received $result.cause")
					
			}
		}

}