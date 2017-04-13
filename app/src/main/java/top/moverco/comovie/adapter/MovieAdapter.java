package top.moverco.comovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import top.moverco.comovie.Bean.Movie;
import top.moverco.comovie.R;

/**
 * Created by liuzongxiang on 13/04/2017.
 */

public class MovieAdapter extends BaseAdapter {
    Context mContext;
    List<Movie> mMovies;
    int resourceId;

    MovieAdapter(Context context, int layoutRes, List<Movie> movies) {
        mMovies = movies;
        resourceId = layoutRes;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(resourceId, null);
            viewHolder.movie_title_text_view = (TextView) view.findViewById(R.id.movie_title_text_view);
            viewHolder.movie_poster_img_view = (ImageView) view.findViewById(R.id.movie_image_view);
            viewHolder.movie_rate_text_view = (TextView) view.findViewById(R.id.movie_rate_text_view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.movie_title_text_view.setText(mMovies.get(position).getTitle());
        viewHolder.movie_rate_text_view.setText(String.valueOf(mMovies.get(position).getVote_average()));
        //viewHolder.movie_poster_img_view.setImageResource();
        return view;
    }

    class ViewHolder {
        TextView movie_title_text_view;
        TextView movie_rate_text_view;
        ImageView movie_poster_img_view;
    }
}
