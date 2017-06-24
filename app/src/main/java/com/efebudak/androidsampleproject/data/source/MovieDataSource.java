package com.efebudak.androidsampleproject.data.source;

import com.efebudak.androidsampleproject.data.Movie;

import java.util.List;

/**
 * Created by efebudak on 24/06/2017.
 */

public interface MovieDataSource {

    interface Callback<T> {
        void onSuccess(T response);

        void onError(String errorMessage);
    }

    void getMovies(Callback<List<Movie>> callback);

    void getMovieDetail(Callback callback);
}
