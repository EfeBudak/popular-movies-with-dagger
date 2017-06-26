package com.efebudak.androidsampleproject.movielist;

import android.content.Context;
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
import com.efebudak.androidsampleproject.util.ui.DateUtils;
import com.efebudak.androidsampleproject.util.ui.ImageUtils;

import java.util.List;

import static com.efebudak.androidsampleproject.util.Constants.THUMBNAIL_SIZE;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    @NonNull
    private List<Movie> mMovieList;

    @NonNull
    private MovieListListener mMovieListListener;

    MovieListAdapter(@NonNull List<Movie> movieList, @NonNull MovieListListener movieListListener) {
        mMovieList = movieList;
        mMovieListListener = movieListListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        final ViewHolder viewHolder = new ViewHolder(root);
        root.setOnClickListener(v -> mMovieListListener.onItemClicked(mMovieList.get(viewHolder.getAdapterPosition()).getId()));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Movie movie = mMovieList.get(position);
        final Context context = holder.itemView.getContext();
        ImageUtils.loadUrlToImageView(
                context,
                BuildConfig.BASE_IMAGE_URL
                        + THUMBNAIL_SIZE
                        + movie.getPosterPath(),
                holder.imageView);
        holder.textViewTitle.setText(
                context.getString(R.string.title_info, movie.getTitle(), DateUtils.getYear(movie.getReleaseDate())));
        holder.textViewPopularity.setText(
                context.getString(R.string.popularity_info, String.valueOf(movie.getPopularity())));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    void updateList(@NonNull final List<Movie> movieList) {
        mMovieList = movieList;
        notifyDataSetChanged();
    }

    interface MovieListListener {
        void onItemClicked(long movieId);
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