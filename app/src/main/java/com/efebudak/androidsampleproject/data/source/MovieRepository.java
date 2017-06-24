package com.efebudak.androidsampleproject.data.source;

import com.efebudak.androidsampleproject.data.Movie;

import java.util.List;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieRepository implements MovieDataSource {

    @Override
    public void getMovies(Callback<List<Movie>> callback) {

    }

    @Override
    public void getMovieDetail(Callback callback) {

    }
}
