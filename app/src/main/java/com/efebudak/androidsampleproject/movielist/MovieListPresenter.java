package com.efebudak.androidsampleproject.movielist;

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

        getMoviePage();
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onRefresh() {
        getMoviePage();
    }

    private void getMoviePage() {
        mView.setRefreshing(true);
        mMovieDataSource.getMovies(new MovieDataSource.Callback<MovieListPage>() {
            @Override
            public void onSuccess(MovieListPage response) {

                mView.updateMovieList(response.getResults());
                mView.setRefreshing(false);
            }

            @Override
            public void onError(String errorMessage) {
                mView.setRefreshing(false);
                mView.showErrorMessage(errorMessage);
            }
        });
    }
}
