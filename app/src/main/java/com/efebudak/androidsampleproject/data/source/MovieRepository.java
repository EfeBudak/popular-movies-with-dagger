package com.efebudak.androidsampleproject.data.source;

import com.efebudak.androidsampleproject.data.MovieListPage;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieRepository implements MovieDataSource {

    private MovieDataSource mRemoteDataSource;

    @Inject
    MovieRepository(@Named("remoteDataSource") MovieDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getMovies(Callback<MovieListPage> callback) {
        mRemoteDataSource.getMovies(callback);
    }

    @Override
    public void getMovieDetail(Callback callback) {

    }
}
