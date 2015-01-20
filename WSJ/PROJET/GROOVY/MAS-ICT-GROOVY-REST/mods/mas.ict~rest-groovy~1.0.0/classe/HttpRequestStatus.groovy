package classe;

enum HttpRequestStatus{
	SUCESS(200,"OK"),
	MONGO_EXCEPTION(503,"Service Unavailable"),
	UNAUTORIZED(401,"Unauthorized"),
	NOT_FOUND(404,"Not found"),
	INVALID_DATA(404,"Not found"),
	CREATED(201,"ok");
	
	public def message;
	public def code;
	
	HttpRequestStatus(code,message){
		this.code 				= code;
		this.message 			= message;
		
	}
}