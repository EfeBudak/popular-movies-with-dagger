package com.efebudak.androidsampleproject.data.source;

import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.data.MovieListPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by efebudak on 24/06/2017.
 */

public interface TMDBService {

    @GET("discover/movie?sort_by=popularity.desc")
    Call<MovieListPage> getPopularMovieListCall(@Query("api_key") String apiKey);

    @GET("movie/{movieId}")
    Call<Movie> getMovieDetailCall(@Path("movieId") long movieId, @Query("api_key") String apiKey);
}
