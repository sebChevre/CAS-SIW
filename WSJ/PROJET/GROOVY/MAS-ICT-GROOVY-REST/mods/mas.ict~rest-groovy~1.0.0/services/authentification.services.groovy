import classe.User;


def eb = vertx.eventBus;
def logger = container.logger;

eb.registerHandler("authentification.basic") { message -> 
	logger.info "authentification.basic message received $message.body"
	
	//check du header authorization
	def authorizationHeader = message.body
	def authorizationOk = isAuthorizationHeaderIntegrityOk(authorizationHeader)
	logger.info "authorizationHeader check: $authorizationOk"
	
	if(authorizationOk){
		User user = returnUserFromAuthorizationHeader(message.body)
		
		eb.sendWithTimeout("activity.tracks.persistence",[
			action: "count", 
			collection: "users",
			matcher: ["username":user.username,"password":user.password]],2000){result ->
				logger.info(result)
			
				if(result.succeeded){
					def userCount = result.result.body.count
					
					if(userCount != 0){
						message.reply([status:"ok"])
					}else{
						message.reply([status:"error",cause:"User/pass authentification failed"])
					}
					
				}else{
					logger.error("message received $result.cause")
					message.reply([status:"fail",cause:"$result.cause"])
				}
			}
	}
	else{
		//problème intégrité Authorization header
		message.reply([status:"error",cause:"AuthorizationHeader basic not defined"])
	}
	
	
	
	
	
	
	
}

def isAuthorizationHeaderIntegrityOk(authorizationHeader){
	
	if(!authorizationHeader){
		return false
	}else{
		def (basic,encrypt) = authorizationHeader.tokenize(' ')
		
		if(!basic || !encrypt){
			println "basic et encrypt"
			return false
		}
		
		User user = returnUserFromAuthorizationHeader(authorizationHeader)
		
		if(!user || !user.checkIntegrity()){
			println "user ou integrity: $user"
			return false
		}else{
			return true
		}
	}
	
}

def returnUserFromAuthorizationHeader(authorizationHeader){

	def encodedString = authorizationHeader.tokenize(' ')[1]
	def decode = new String(encodedString.decodeBase64())
		
	def (name,pass) = decode.tokenize(':')
		
	println "name:$name, pass:$pass"
		
	User user = new User(username : name,password : pass)
		
	println "user decoded: $user"
	
	user
		
}




