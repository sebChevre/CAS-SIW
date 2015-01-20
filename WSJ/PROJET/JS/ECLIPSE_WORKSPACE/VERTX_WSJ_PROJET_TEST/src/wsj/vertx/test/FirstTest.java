package wsj.vertx.test;

import java.util.List;

import retrofit.RestAdapter;
import wsj.vertx.test.serviceinterface.SimpleXMLConverter;
import wsj.vertx.test.serviceinterface.TaskActivityService;
import wsj.vertx.test.serviceinterface.User;
import wsj.vertx.test.serviceinterface.Users;

public class FirstTest {

	public static void main (String args[]){
		RestAdapter restAdapter = new RestAdapter.Builder()
	    .setEndpoint("http://localhost:9999")
	    .build();

	TaskActivityService service = restAdapter.create(TaskActivityService.class);
	
	List<User> users = service.listUser();
	
	System.out.println(users);
	
	for(User u : users){
		System.out.println(u);
	}
	
	
	RestAdapter restXmlAdapter = new RestAdapter.Builder()
    .setEndpoint("http://localhost:9999")
    .setConverter(new SimpleXMLConverter())
    .build();
	
TaskActivityService xmlservice = restXmlAdapter.create(TaskActivityService.class);
	
	Users usersXml = xmlservice.listUserAsXml();
	
	System.out.println(usersXml);
	
	for(User u : usersXml.users){
		System.out.println(u);
	}
	
	
	
	}
}
