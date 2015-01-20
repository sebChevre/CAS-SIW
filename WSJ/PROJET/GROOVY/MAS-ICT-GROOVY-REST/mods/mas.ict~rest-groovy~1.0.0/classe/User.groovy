package classe;
import java.security.MessageDigest
import groovy.json.*;
import groovy.transform.ToString

@ToString
class User{

	def username
	def password
	
	
	def encryptMd5PassWord(){
		
		def digest = MessageDigest.getInstance("MD5")
		def md5hash1 = new BigInteger(1,digest.digest(this.password.getBytes())).toString(16).padLeft(32,"0") 
		this.password = md5hash1
	}
	
	def checkIntegrity(){
		return this.username && this.password && this.username.trim() && this.password.trim()
	}
	
	
	def toJson(){
		def builder = new JsonBuilder()
		builder{
			username username
			password password
		}
		
		return builder.toPrettyString()
	}
	
	static def fromJson(userJson){
		def slurper = new JsonSlurper()
		User user = slurper.parseText(userJson)
		user
	}
	
}