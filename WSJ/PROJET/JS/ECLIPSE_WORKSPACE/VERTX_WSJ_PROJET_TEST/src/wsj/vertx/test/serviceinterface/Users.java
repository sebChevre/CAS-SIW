package wsj.vertx.test.serviceinterface;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
@Root(name = "users")
public class Users {
	@ElementList(inline = true)
	public List<User> users;
	
}
