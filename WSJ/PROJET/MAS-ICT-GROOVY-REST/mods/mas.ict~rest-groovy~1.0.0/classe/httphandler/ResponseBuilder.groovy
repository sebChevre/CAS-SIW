package classe.httphandler;
import classe.HttpRequestStatus;


class ResponseBuilder{
	
	
	
	def static buildGet (request, responseBody) {
		def ressource = getPrefix(request)
		defineHttpHeader(request,ressource)
		
		request.response.with{
			statusCode = HttpRequestStatus.SUCESS.code
			statusMessage = HttpRequestStatus.SUCESS.message
		}
		
		BodyBuilder builder = new BodyBuilder(request:request,ressourceType:ressource,httpStatus:HttpRequestStatus.SUCESS)
		
		builder
	}
	
	def static buildForUsersList (request, responseBody) {
		request.response.end(buildGet(request,responseBody).datas(responseBody.results).successListBody())
	}
	
	def static buildForUserRead (request, responseBody) {
		request.response.end(buildGet(request,responseBody).datas(responseBody.results).successReadBody())
	}
	
	def static buildForTrackList (request, responseBody) {
		request.response.end(buildGet(request,responseBody).datas(responseBody.results).successListTrackBody())
	}
	
	
	
	def static buildForUserAdd (request, responseBody) {
		
		def ressource = getPrefix(request)
		defineHttpHeader(request,ressource)
		def httpStatus = (responseBody.status == "ok")? HttpRequestStatus.CREATED : HttpRequestStatus.INVALID_DATA
		
		request.response.with{
			statusCode = httpStatus.code
			statusMessage = httpStatus.message
		}
		
		BodyBuilder builder = new BodyBuilder(request:request,ressourceType:ressource,httpStatus:httpStatus)
		
		
		if(responseBody.status == "ok"){
			request.response.end(builder.datas(responseBody).successAddBody())
		}else{
			request.response.end(builder.datas(["cause":responseBody.cause]).errorBody())
		}
	}
	
	
	
	def static buildForAuthorizationFail (request,responseBody) {
		def ressourceType = getPrefix(request)
		defineHttpHeader(request,ressourceType)
		def cause = responseBody.cause
		
		println "$responseBody.status"
		
		HttpRequestStatus httpStatus = (responseBody.status == "error")? HttpRequestStatus.UNAUTORIZED : HttpRequestStatus.MONGO_EXCEPTION 
		
		println "$httpStatus.code"
		
		request.response.with{
			statusCode = httpStatus.code
			statusMessage = httpStatus.message
		}
		BodyBuilder builder = new BodyBuilder(request:request,ressourceType:ressourceType,httpStatus:httpStatus)
		
		request.response.putHeader('WWW-Authenticate','Basic realm="Authentification"');
		request.response.end(builder.datas(["cause":cause]).errorBody())
	}
	
	
	
	
	def static getPrefix(request){
		def prefix = request.path.tokenize('.')[1]
		prefix = prefix ? prefix : "xml"
		prefix
	}
	
	def static defineHttpHeader(request,ressourceType){
		request.response.putHeader("Charset","UTF-8")
		request.response.putHeader("contentType","application/$ressourceType")
	}

}