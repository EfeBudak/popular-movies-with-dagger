package com.efebudak.androidsampleproject.movielist;

import android.util.Log;

import com.efebudak.androidsampleproject.data.MovieListPage;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;

import javax.inject.Inject;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View mView;
    private MovieDataSource mMovieDataSource;

    @Inject
    public MovieListPresenter(
            MovieListContract.View view,
            MovieDataSource movieDataSource) {
        mView = view;
        mMovieDataSource = movieDataSource;
    }

    @Override
    public void subscribe() {

        mMovieDataSource.getMovies(new MovieDataSource.Callback<MovieListPage>() {
            @Override
            public void onSuccess(MovieListPage response) {
                Log.d("onSuccess", "Subscribe");
            }

            @Override
            public void onError(String errorMessage) {
                Log.d("onError", "Subscribe");
            }
        });
        Log.d("Presenter", "Subscribe");
    }

    @Override
    public void unsubscribe() {

        Log.d("Presenter", "unSubscribe");
    }
}
