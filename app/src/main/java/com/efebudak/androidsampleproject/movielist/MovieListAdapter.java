package com.efebudak.androidsampleproject.movielist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.efebudak.androidsampleproject.BuildConfig;
import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.util.ui.ImageUtils;

import java.util.List;

import static com.efebudak.androidsampleproject.util.Constants.THUMBNAIL_SIZE;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    @NonNull
    private List<Movie> mMovieList;

    MovieListAdapter(@NonNull List<Movie> movieList) {
        mMovieList = movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mMovieList.get(position);
        ImageUtils.loadUrlToImageView(
                holder.imageView.getContext(),
                BuildConfig.BASE_IMAGE_URL
                        + THUMBNAIL_SIZE
                        + movie.getPosterPath(),
                holder.imageView);
        holder.textViewTitle.setText(movie.getTitle());
        holder.textViewPopularity.setText(String.valueOf(movie.getPopularity()));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    void updateList(@NonNull final List<Movie> movieList) {
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewPopularity;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_image_view);
            textViewTitle = (TextView) itemView.findViewById(R.id.item_text_view_title);
            textViewPopularity = (TextView) itemView.findViewById(R.id.item_text_view_popularity);
        }
    }
}