package mas.rest.retrofit;

import org.springframework.web.bind.annotation.PathVariable;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.*;

import java.util.List;

/**
 * Created by sce on 25.11.2014.
 */
public interface TaskActivityService {

    @Headers({
            "Accept: application/json",
            "Authorization: Basic cm9vdDo2M2E5ZjBlYTdiYjk4MDUwNzk2YjY0OWU4NTQ4MTg0NQ==" //root:root
    })
    @GET("/users.json")
    void listUsers(Callback<Users> callback);

    @Headers({
            "Accept: application/json",
            "Charset: UTF-8",
            "Authorization: Basic cm9vdDo2M2E5ZjBlYTdiYjk4MDUwNzk2YjY0OWU4NTQ4MTg0NQ=="
    })
    @POST("/users.json")
    void addUser(@Body User userToAdd, Callback<User> callback);

    @Headers({
            "Accept: application/json",
            "Charset: UTF-8",
            "Authorization: Basic cm9vdDo2M2E5ZjBlYTdiYjk4MDUwNzk2YjY0OWU4NTQ4MTg0NQ=="
    })
    @POST("/users/{userid}/tracks")
    void addTrackForUser(@Body Track trackToAdd, @Path(value="userid") String userid,Callback<Track> callback);

    @Headers({
            "Accept: application/json",
            "Charset: UTF-8",
            "Authorization: Basic cm9vdDo2M2E5ZjBlYTdiYjk4MDUwNzk2YjY0OWU4NTQ4MTg0NQ=="
    })
    @GET("/users/{userid}/tracks.json")
    void listTracksForUser(@Path(value="userid") String userid,Callback<Tracks> callback);

    @Headers({
            "Accept: application/json",
            "Charset: UTF-8",
            "Authorization: Basic cm9vdDo2M2E5ZjBlYTdiYjk4MDUwNzk2YjY0OWU4NTQ4MTg0NQ=="
    })
    @GET("/tracks/{trackid}")
    void readTrackById(@Path(value="trackid") String trackid,Callback<Track> callback);




}
