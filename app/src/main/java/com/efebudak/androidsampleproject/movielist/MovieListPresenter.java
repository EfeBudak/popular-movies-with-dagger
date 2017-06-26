package com.efebudak.androidsampleproject.movielist;

import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.data.MovieListPage;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;
import com.efebudak.androidsampleproject.data.source.MovieRepository;

import javax.inject.Inject;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View mView;
    private MovieRepository mMovieRepository;

    @Inject
    public MovieListPresenter(
            MovieListContract.View view,
            MovieRepository movieRepository) {
        mView = view;
        mMovieRepository = movieRepository;
    }

    @Override
    public void subscribe() {
        getMoviePage();
    }

    @Override
    public void onRefresh() {
        mMovieRepository.refresh();
        getMoviePage();
    }

    private void getMoviePage() {
        mView.setRefreshing(true);
        mMovieRepository.getMovies(new MovieDataSource.Callback<MovieListPage>() {
            @Override
            public void onSuccess(@NonNull MovieListPage response) {

                mView.updateMovieList(response.getResults());
                mView.setRefreshing(false);
            }

            @Override
            public void onError(@NonNull String errorMessage) {
                mView.setRefreshing(false);
                mView.showErrorMessage(errorMessage);
            }
        });
    }
}
