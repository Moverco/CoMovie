package top.moverco.comovie.util;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.util.List;

import okhttp3.Response;
import top.moverco.comovie.Bean.Movie;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public abstract class ListMovieCallback extends Callback<List<Movie>> {
    @Override
    public List<Movie> parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        List<Movie> movies = new Gson().fromJson(string,List.class);
        return movies;
    }
}
