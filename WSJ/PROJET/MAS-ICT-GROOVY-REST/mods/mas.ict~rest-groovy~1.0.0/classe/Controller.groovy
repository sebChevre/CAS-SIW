package classe;
import groovy.json.*;
import classe.httphandler.*;
import classe.User;
import classe.HttpRequestStatus;

class Controller{

	def logger
	def eventBus
	
	
	
	def dispatchPost(request,success){
		logger.info "Controller Dispatch POST"
		
		eventBus.send("authentification.basic",request.getHeaders().get("Authorization")){response ->
			
			def status = response.body.status
			
			if(status == "ok"){
				success()
			}else{
				ResponseBuilder.buildForAuthorizationFail(request,response.body)
			}
		}
		
	}
	
	
	def dispatchGet(request,success){
		
		logger.info "Controller Dispatch GET"
		def authorizationHeader = request.getHeaders().get("Authorization")
		
		eventBus.send("authentification.basic",request.getHeaders().get("Authorization")){response ->
			
			def status = response.body.status
			
			if(status == "ok"){
				success()
			}else{
				ResponseBuilder.buildForAuthorizationFail(request,response.body)
			}
		}
	}
	
	
	
	
}