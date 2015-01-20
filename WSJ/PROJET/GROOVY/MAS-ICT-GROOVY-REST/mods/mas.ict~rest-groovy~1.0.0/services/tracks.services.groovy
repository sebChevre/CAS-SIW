import groovy.json.*;
import classe.Track;

def eb = vertx.eventBus;
def logger = container.logger;
def collection = "tracks";

def sentToPersistenceBus = {action,matcher,message->
	eb.sendWithTimeout("activity.tracks.persistence",[
		action: action, 
		collection: collection,
		matcher: matcher],2000){result ->
			logger.info(result)
			
			if(result.succeeded){
				//logger.info("retour mongodb: " + result.result.body)
				message.reply(result.result.body)
			}else{
				logger.error("message received $result.cause")
				message.reply([status:"fail",cause:"$result.cause"])
			}
	}
}


eb.registerHandler("tracks.list") { message ->
	logger.info "tracks.read messsage received $message.body"
	sentToPersistenceBus("find",message.body,message)
}

eb.registerHandler("tracks.check") { message ->
	logger.info "tracks.check messsage received $message.body"
	
	
	Track track = Track.fromJson(message.body)
	println "track: $track"
	
	if(track.checkIntegrity()){
		println "integrity ok"
		
		eb.send('tracks.add',[name:track.name, description:track.description, date:track.date, userid:track.userid]){addResponse->
			message.reply(addResponse.body)
		}
	}else{
		println "integrity fail"
		message.reply([status:"error",cause:"Data Integrity fail"])
		
	}
	
}

eb.registerHandler("tracks.add"){message ->
	logger.info "tracks.add messsage received $message.body"
	
	
	eb.sendWithTimeout("activity.tracks.persistence",[
			action: 'save', 
			collection: 'tracks',
			document:message.body],2000){result->
				logger.info(result)
				if(result.succeeded){
					message.reply(result.result.body)
				}else{
					logger.error("message received $result.cause")
					message.reply([status:"fail",cause:"$result.cause"])
			}
		}
}


