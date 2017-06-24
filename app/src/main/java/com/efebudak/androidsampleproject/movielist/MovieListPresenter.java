package com.efebudak.androidsampleproject.movielist;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by efebudak on 24/06/2017.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MovieListContract.View mView;

    @Inject
    public MovieListPresenter(MovieListContract.View view) {
        mView = view;
    }

    @Override
    public void subscribe() {

        Log.d("Presenter", "Subscribe");
    }

    @Override
    public void unsubscribe() {

        Log.d("Presenter", "unSubscribe");
    }
}
