package mas.rest.retrofit;

/**
 * Created by seb on 28.11.14.
 */
public class Track {
    public String name;
    public String description;
    public String date;
    public String userid;
    public String _id;

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", userid='" + userid + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
