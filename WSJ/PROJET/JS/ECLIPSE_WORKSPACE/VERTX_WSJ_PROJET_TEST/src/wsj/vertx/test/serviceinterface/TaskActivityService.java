package wsj.vertx.test.serviceinterface;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

public interface TaskActivityService {

	@GET("/users")
	List<User> listUser();
	
	@GET("/users.xml")
	Users listUserAsXml();
	
	
}
