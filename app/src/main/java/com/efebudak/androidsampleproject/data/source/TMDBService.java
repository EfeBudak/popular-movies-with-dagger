package com.efebudak.androidsampleproject.data.source;

import com.efebudak.androidsampleproject.data.MovieListPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by efebudak on 24/06/2017.
 */

public interface TMDBService {

    @GET("discover/movie?sort_by=popularity.desc")
    Call<MovieListPage> getPopularMovieListCall(@Query("api_key") String apiKey);
}
