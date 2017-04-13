package top.moverco.comovie.util;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;
import top.moverco.comovie.Bean.Movie;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public abstract class MovieCallback extends Callback<Movie> {
    @Override
    public Movie parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        Movie movie = new Gson().fromJson(string,Movie.class);
        return movie;

    }
}
