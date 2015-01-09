package mas.rest.client;

import mas.rest.retrofit.TaskActivityAdapter;
import mas.rest.retrofit.Track;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by seb on 27.11.14.
 */
@Controller
class PageController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("tutu","toto");
        return "index";
    }

    @RequestMapping("/track/{trackId}")
    public String track(final Model model,@PathVariable String trackId) {

        System.out.println("track read");

        final DeferredResult<Track> result = new DeferredResult<Track>();

        Callback<Track> callback = new Callback<Track>() {
            @Override
            public void success(Track track,Response response) {
                System.out.println(track.toString());
                System.out.println(response.getBody().toString());
                System.out.println(response.getHeaders());
                model.addAttribute("name","success");

                result.setResult(track);

            }

            @Override
            public void failure(RetrofitError retrofitError) {


                //response.setStatus(404);
                //result.setErrorResult(retrofitError.getResponse());
                model.addAttribute("name","erreur");


            }
        };



        TaskActivityAdapter.getTAskActivityService().readTrackById(trackId, callback);
        //model.addAttribute("name","toto");

        return "track";
    }
}
