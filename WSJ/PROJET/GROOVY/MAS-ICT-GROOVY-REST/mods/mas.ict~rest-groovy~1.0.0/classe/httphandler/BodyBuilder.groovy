package classe.httphandler;

import groovy.json.*;
import groovy.xml.*;

class BodyBuilder{

	
	def request
	def ressourceType
	def datas
	def httpStatus
	
	
	def errorBody(){
		
		def writer = new StringWriter()
		def builder = new MarkupBuilder(writer)
		
		builder.data(){
			cause datas.cause
		}
		
		writer.toString()
	}
	
	def successReadBody () {
		def builder
		switch(ressourceType){
			case "xml":
				def writer = new StringWriter()
				builder = new MarkupBuilder(writer)
				buildReadBody(builder)
				writer.toString()
			break;
			
			case "json":
				builder = new JsonBuilder()
				buildReadBody(builder)
				builder.toPrettyString()
			break;
		}
	}
	
	def successAddBody () {
		
		def builder
		switch(ressourceType){
			case "xml":
				def writer = new StringWriter()
				builder = new MarkupBuilder(writer)
				buildAddBody(builder)
				writer.toString()
			break;
			
			case "json":
				builder = new JsonBuilder()
				buildAddBody(builder)
				builder.toPrettyString()
			break;
		}
	
		
	}
	
	def buildAddBody(builder){
		
		println datas
		
		
			builder.data(){
				user{
					"_id" "$datas._id"
					link(rel:"self",href:"users/$datas._id")
				}
			}
		builder
	}
	
	def buildReadBody(builder){
		
		println datas
		
		if(datas.size() > 0){
			datas = datas.first()
		}
		
		builder.data(){
				
			user{
				datas.each(){entry,value->
						"$entry" "$value"
					}
					link(rel:"self",href:"users/$datas._id")
				}
			}
		builder
	}
	
	
	
	def successListBody(){
		def builder
		
		switch(ressourceType){
			case "xml":
				def writer = new StringWriter()
				builder = new MarkupBuilder(writer)
				buildSuccessListBody(builder,true)
				writer.toString()
			break;
			
			case "json":
				builder = new JsonBuilder()
				buildSuccessListBody(builder,false)
				builder.toPrettyString()
			break;
		}
	}
	
	def successListTrackBody(){
		def builder
		
		switch(ressourceType){
			case "xml":
				def writer = new StringWriter()
				builder = new MarkupBuilder(writer)
				buildSuccessListTrackBody(builder,true)
				writer.toString()
			break;
			
			case "json":
				builder = new JsonBuilder()
				buildSuccessListTrackBody(builder,false)
				builder.toPrettyString()
			break;
		}
	}
	
	def buildSuccessListTrackBody(builder,isXml){
		
		
			builder.data() {
				if(isXml){
					tracks {
						datas.each(){entry->
							track{	
								"_id""$entry._id"
								"name""$entry.name"
								"description""$entry.description"
								"date""$entry.date"
								"userid""$entry.userid"
								links(){
									link(rel:"self",href:"tracks/$entry._id")
								}
								
							}
						}
						
					}
				}else{
					tracks datas.collect{track->[
						"_id":"$track._id",
						"name":"$track.name",
						"description":"$track.description",
						"date":"$track.date",
						"userid":"$track.userid",
						"links":[
								["rel":"self",
								"href":"/tracks/$track._id"]
							]
					]}
				}
			}
	}
	
	def buildSuccessListBody(builder,isXml){
		
		
			builder.data() {
				if(isXml){
					users {
						datas.each(){entry->
							user{	
								"_id""$entry._id"
								"username""$entry.username"
								"password""$entry.password"
								links(){
									link(rel:"self",href:"users/$entry._id")
								}
								
							}
						}
						
					}
				}else{
					users datas.collect{user->[
						"_id":"$user._id",
						"username":"$user.username",
						"password":"$user.password",
						"links":[
								["rel":"self",
								"href":"/users/$user._id"]
							]
					]}
				}
			}
	}
	

	def datas(data){
		this.datas = data;
		return this;
	}
}