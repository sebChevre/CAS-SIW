package mas.rest.client;

import com.google.gson.Gson;
import mas.rest.retrofit.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seb on 27.11.14.
 */
@Controller
class UserController {

    //public static Map<String,DeferredResult> results = new HashMap<String,DeferredResult>();


    @RequestMapping(method= RequestMethod.GET,value = "/userTracks/{userid}")
    public @ResponseBody
    DeferredResult<String> listTracks(@PathVariable String userid){

        final DeferredResult<String> result = new DeferredResult<String>();

        Callback<Tracks> callback = new Callback<Tracks>() {
            @Override
            public void success(Tracks tracks, Response response) {
                System.out.println(tracks.toString());
                System.out.println(response.getBody().toString());
                System.out.println(response.getHeaders());
                //results.get(result.toString()).setResult(new Gson().toJson(users));
                result.setResult(new Gson().toJson(tracks));
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                result.setResult(new Gson().toJson(retrofitError));
            }
        };

        TaskActivityAdapter.getTAskActivityService().listTracksForUser(userid,callback);

        return result;

    }


    @RequestMapping(method= RequestMethod.GET,value = "/usersList")
    public @ResponseBody
    DeferredResult<String> list(){

        final DeferredResult<String> result = new DeferredResult<String>();

        Callback<Users> callback = new Callback<Users>() {
            @Override
            public void success(Users users, Response response) {
                System.out.println(users.toString());
                System.out.println(response.getBody().toString());
                System.out.println(response.getHeaders());
                //results.get(result.toString()).setResult(new Gson().toJson(users));
                result.setResult(new Gson().toJson(users));
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                result.setResult(new Gson().toJson(retrofitError));
            }
        };

        TaskActivityAdapter.getTAskActivityService().listUsers(callback);

        return result;

    }



    @RequestMapping(method = RequestMethod.POST,value="/userAdd")
    public @ResponseBody DeferredResult<User> addUser(@RequestBody User user, final HttpServletResponse response){

        final DeferredResult<User> result = new DeferredResult<User>();

        Callback<User> callback = new Callback<User>() {
            @Override
            public void success(User user,Response response) {
                System.out.println(user.toString());
                System.out.println(response.getBody().toString());
                System.out.println(response.getHeaders());


                result.setResult(user);

            }

            @Override
            public void failure(RetrofitError retrofitError) {

                System.out.println(retrofitError);
                response.setStatus(404);
                result.setErrorResult(retrofitError.getResponse());


            }
        };

        //System.out.println(user);

        TaskActivityAdapter.getTAskActivityService().addUser(user,callback);



        return result;
    }

    @RequestMapping(method = RequestMethod.POST,value="/trackAdd")
    public @ResponseBody DeferredResult<Track> addTrack(@RequestBody Track track,final HttpServletResponse response){

        final DeferredResult<Track> result = new DeferredResult<Track>();

        Callback<Track> callback = new Callback<Track>() {
            @Override
            public void success(Track track,Response response) {
                System.out.println(track.toString());
                System.out.println(response.getBody().toString());
                System.out.println(response.getHeaders());


                result.setResult(track);

            }

            @Override
            public void failure(RetrofitError retrofitError) {


                response.setStatus(404);
                result.setErrorResult(retrofitError.getResponse());


            }
        };

        //System.out.println(user);

        TaskActivityAdapter.getTAskActivityService().addTrackForUser(track,track.userid,callback);



        return result;
    }
}
