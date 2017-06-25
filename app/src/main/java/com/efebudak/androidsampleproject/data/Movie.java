package com.efebudak.androidsampleproject.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by efebudak on 24/06/2017.
 */

public class Movie {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("release_date")
    private String releaseDate;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
