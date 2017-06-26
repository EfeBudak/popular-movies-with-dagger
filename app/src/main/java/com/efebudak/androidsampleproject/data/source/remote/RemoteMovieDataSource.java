package com.efebudak.androidsampleproject.data.source.remote;

import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.BuildConfig;
import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.MovieListPage;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;
import com.efebudak.androidsampleproject.data.source.TMDBService;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by efebudak on 24/06/2017.
 */

@Singleton
public class RemoteMovieDataSource implements MovieDataSource {

    private TMDBService mTmdbService;

    @Inject
    RemoteMovieDataSource(TMDBService tmdbService) {
        mTmdbService = tmdbService;
    }

    @Override
    public void getMovies(@NonNull final Callback<MovieListPage> callback) {
        mTmdbService.getPopularMovieListCall(BuildConfig.API_KEY).enqueue(new retrofit2.Callback<MovieListPage>() {
            @Override
            public void onResponse(Call<MovieListPage> call, Response<MovieListPage> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<MovieListPage> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }

    @Override
    public void getMovieDetail(@NonNull Callback<Movie> callback, long movieId) {
        mTmdbService.getMovieDetailCall(movieId, BuildConfig.API_KEY).enqueue(new retrofit2.Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
