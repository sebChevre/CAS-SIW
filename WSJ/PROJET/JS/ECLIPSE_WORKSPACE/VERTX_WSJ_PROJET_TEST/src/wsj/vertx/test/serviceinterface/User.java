package wsj.vertx.test.serviceinterface;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "user")
public class User {
	
	@Element(name = "username")
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}

}
