package com.efebudak.androidsampleproject.moviedetail;

import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;
import com.efebudak.androidsampleproject.data.source.MovieRepository;

import javax.inject.Inject;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MovieDetailContract.View mView;
    private MovieRepository mMovieRepository;
    private long mMovieId;

    @Inject
    MovieDetailPresenter(MovieDetailContract.View view, MovieRepository movieRepository) {
        mView = view;
        mMovieRepository = movieRepository;
    }

    @Override
    public void subscribe() {
        mMovieRepository.getMovieDetail(new MovieDataSource.Callback<Movie>() {
            @Override
            public void onSuccess(@NonNull Movie response) {
                mView.setMovieDetails(response);
            }

            @Override
            public void onError(@NonNull String errorMessage) {

            }
        }, mMovieId);
    }

    @Override
    public void setMovieId(long movieId) {
        mMovieId = movieId;
    }
}
