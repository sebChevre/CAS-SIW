package mas.rest.retrofit;

import java.util.ArrayList;

/**
 * Created by sce on 25.11.2014.
 */
public class User {

    UserWrapper data;

    class UserWrapper{
        User user;
    }


    public String username;
    public String detail;
    public String _id;
    public String password;
    public ArrayList<Link> links;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", detail='" + detail + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
