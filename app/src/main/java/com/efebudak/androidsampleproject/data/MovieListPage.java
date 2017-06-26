package com.efebudak.androidsampleproject.data;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieListPage {

    @SerializedName("results")
    private List<Movie> results;

    public MovieListPage(@NonNull List<Movie> movieList){
        results = movieList;
    }

    public List<Movie> getResults() {
        return results;
    }
}
