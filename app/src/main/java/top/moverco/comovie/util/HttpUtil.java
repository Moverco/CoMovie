package top.moverco.comovie.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import top.moverco.comovie.Bean.Movie;
import top.moverco.comovie.config.Config;
import top.moverco.comovie.log.Logger;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class HttpUtil {

    List<Movie> mMovies = new ArrayList<Movie>();

    private static final String GET_UPCOMING = String.format("https://api.themoviedb.org/3/movie/upcoming?api_key=%s", Config.API_KEY_V3);
    private static final String GET_LATEST = String.format("https://api.themoviedb.org/3/movie/latest?api_key=%s", Config.API_KEY_V3);
    private static final String GET_POPULAR = String.format("https://api.themoviedb.org/3/movie/popular?api_key=%s", Config.API_KEY_V3);
    private static final String GET_TOP_RATED_ROOT = String.format("https://api.themoviedb.org/3/movie/top_rated?api_key=%s", Config.API_KEY_V3);

    public static void getMoviesFromWeb(int command) {
        String url;
        switch (command) {
            case COMMAND.GET_LATEST:
                url = GET_LATEST;
                break;
            case COMMAND.GET_POPULAR:
                url = GET_POPULAR;
                break;
            case COMMAND.GET_TOP_RATED:
                url = GET_TOP_RATED_ROOT;
                break;
            case COMMAND.GET_UPCOMING:
                url = GET_UPCOMING;
                break;
            default:
                url = null;
                break;
        }
        if (url != null) {
            OkHttpUtils.get()
                    .url(url)
                    .build()
                    .execute(new ListMovieCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            Logger.d("onError: " + e.getMessage());
                        }

                        @Override
                        public void onResponse(List<Movie> response, int id) {
                            Logger.d("onResponse: " + response);

                        }
                    });
        }
    }

    public static void getPosterFromDB(Movie movie, final ImageView view) {
        String poster_url = String.format("https://image.tmdb.org/t/p/w1280/%s", movie.getPoster_path());
        OkHttpUtils.get()
                .url(poster_url)
                .build()
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.d("onError: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap response, int id) {
                        Logger.d("onResponse: " + response.toString());
                        view.setImageDrawable(new BitmapDrawable(response));
                    }
                });


    }

    public static class COMMAND {
        public static final int GET_POPULAR = 1;
        public static final int GET_UPCOMING = 2;
        public static final int GET_LATEST = 3;
        public static final int GET_TOP_RATED = 4;
    }
}
