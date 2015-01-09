package classe;
import java.security.MessageDigest
import groovy.json.*;
import groovy.transform.ToString

@ToString
class Track{

	def date
	def description
	def userid
	def name
	
	def toJson(){
		def builder = new JsonBuilder()
		builder{
			date date
			description description
			userid userid
			name name		}
		
		return builder.toPrettyString()
	}
	
	def checkIntegrity(){
		return this.date && this.description && this.name && this.userid && this.description.trim() && this.name.trim() && this.userid.trim() && this.date.trim()
	}
	
	static def fromJson(trackJson){
		def slurper = new JsonSlurper()
		Track track = slurper.parseText(trackJson)
		track
	}
}