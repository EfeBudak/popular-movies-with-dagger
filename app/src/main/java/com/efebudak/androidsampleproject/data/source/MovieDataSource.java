package com.efebudak.androidsampleproject.data.source;

import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.MovieListPage;

/**
 * Created by efebudak on 24/06/2017.
 */

public interface MovieDataSource {

    interface Callback<T> {
        void onSuccess(@NonNull T response);

        void onError(@NonNull String errorMessage);
    }

    void getMovies(@NonNull Callback<MovieListPage> callback);

    void getMovieDetail(@NonNull Callback<Movie> callback, long movieId);
}
