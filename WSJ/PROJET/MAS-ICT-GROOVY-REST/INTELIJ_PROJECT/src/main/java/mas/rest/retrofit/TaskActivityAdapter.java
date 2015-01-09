package mas.rest.retrofit;

import retrofit.RestAdapter;

/**
 * Created by sce on 25.11.2014.
 */
public class TaskActivityAdapter {

    public static TaskActivityService getTAskActivityService(){
        RestAdapter adapter = new RestAdapter.Builder().
                setEndpoint("http://localhost:9999")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        TaskActivityService service = adapter.create(TaskActivityService.class);

        return service;
    }
}
