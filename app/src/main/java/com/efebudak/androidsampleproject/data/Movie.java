package com.efebudak.androidsampleproject.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genres")
    private List<Genre> genres;
    @SerializedName("overview")
    private String overview;

    public Movie(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPopularity() {
        return (int) popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getOverview() {
        return overview;
    }
}
