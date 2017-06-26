package com.efebudak.androidsampleproject.moviedetail;

import com.efebudak.androidsampleproject.data.source.MovieRepository;

import javax.inject.Inject;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mView;
    private MovieRepository mMovieRepository;

    @Inject
    MovieDetailPresenter(MovieDetailContract.View view, MovieRepository movieRepository) {
        mView = view;
        mMovieRepository = movieRepository;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
