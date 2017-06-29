package com.efebudak.androidsampleproject.data.source;

import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;

import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.MovieListPage;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieRepository implements MovieDataSource {

    private MovieDataSource mRemoteDataSource;
    private MovieListPage mCachedMovieListPage;
    private Map<Long, Movie> mCachedMovieDetails;
    private boolean mCacheIsDirty = false;
    private boolean mFirstTime = true;

    @Inject
    MovieRepository(@Named("remoteDataSource") MovieDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    @Override
    public void getMovies(@NonNull Callback<MovieListPage> callback) {

        if (mCachedMovieListPage != null && !mCacheIsDirty) {
            callback.onSuccess(mCachedMovieListPage);
            return;
        }

        if (mCacheIsDirty || mFirstTime) {
            mFirstTime = false;
            mRemoteDataSource.getMovies(new Callback<MovieListPage>() {
                @Override
                public void onSuccess(@NonNull MovieListPage response) {
                    mCachedMovieListPage = response;
                    mCacheIsDirty = false;
                    callback.onSuccess(response);
                }

                @Override
                public void onError(@NonNull String errorMessage) {
                    callback.onError(errorMessage);
                }
            });
        } else {
            // Local data source can be used here to fetch data
        }
    }

    @Override
    public void getMovieDetail(@NonNull Callback<Movie> callback, long movieId) {

        if (mCachedMovieDetails == null) {
            mCachedMovieDetails = new ArrayMap<>();
        }
        final Movie cachedMovie = mCachedMovieDetails.get(movieId);

        if (cachedMovie != null) {
            callback.onSuccess(cachedMovie);
            return;
        }

        mRemoteDataSource.getMovieDetail(new Callback<Movie>() {
            @Override
            public void onSuccess(@NonNull Movie response) {
                mCachedMovieDetails.put(movieId, response);
                callback.onSuccess(response);
            }

            @Override
            public void onError(@NonNull String errorMessage) {
                callback.onError(errorMessage);
            }
        }, movieId);

    }

    public void refresh() {
        mCacheIsDirty = true;
    }
}
