package top.moverco.comovie.util;

import top.moverco.comovie.Bean.Movie;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class MovieUtil {
    private String movie_title;
    private int movie_poster_id;
    private String movie_rate;
    private Movie mMovie;

    MovieUtil(Movie movie){
        mMovie = movie;
        movie_title = movie.getTitle();
        movie_rate = String.valueOf(movie.getVote_average());
        movie_poster_id = getMovie_poster_id();
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public int getMovie_poster_id() {
        return movie_poster_id;
    }

    public void setMovie_poster_id(int movie_poster_id) {
        this.movie_poster_id = movie_poster_id;
    }

    public String getMovie_rate() {
        return movie_rate;
    }

    public void setMovie_rate(String movie_rate) {
        this.movie_rate = movie_rate;
    }
}
