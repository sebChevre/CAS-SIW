import groovy.json.*;
import classe.User;

def eb = vertx.eventBus;
def logger = container.logger;
def collection = "users";

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

eb.registerHandler("users.list") { message -> 
	logger.info "users.list message received $message.body"
	sentToPersistenceBus("find",[:],message)
}

eb.registerHandler("users.count") { message ->
	logger.info "users.count messsage received $message.body"
	sentToPersistenceBus("count",message.body,message)
}

eb.registerHandler("users.read") { message ->
	logger.info "users.read messsage received $message.body"
	sentToPersistenceBus("find",message.body,message)
}

eb.registerHandler("users.check") { message ->
	logger.info "users.check messsage received $message.body"
	
	
	User user = User.fromJson(message.body)
	println "user: $user"
	if(user.checkIntegrity()){
		println "integrity ok"
		user.encryptMd5PassWord()
		
		eb.sendWithTimeout("activity.tracks.persistence",[
			action: 'count', 
			collection: 'users',
			matcher:['username':user.username]],2000){response->
			
				if(response.succeeded){
					//utilisateur n'existe pas
					if(response.result.body.count == 0){
						eb.send('users.add',[username:user.username, password:user.password]){addResponse->
							message.reply(addResponse.body)
						}
					}
					else{
						message.reply([status:"error",cause:"User exist"])
					}
				}else{
					logger.error("message received $result.cause")
					message.reply([status:"fail",cause:"$result.cause"])
			}
		}
	}else{
		println "integrity fail"
		message.reply([status:"error",cause:"Data Integrity fail"])
		
	}
	
}

eb.registerHandler("users.add"){message ->
	logger.info "users.add messsage received $message.body"
	
	
	eb.sendWithTimeout("activity.tracks.persistence",[
			action: 'save', 
			collection: 'users',
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


