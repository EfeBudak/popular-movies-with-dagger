package com.efebudak.androidsampleproject.moviedetail;

import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.BasePresenter;
import com.efebudak.androidsampleproject.BaseView;
import com.efebudak.androidsampleproject.data.Movie;

/**
 * Created by efebudak on 25/06/2017.
 */

public interface MovieDetailContract {

    interface View extends BaseView {
        void setMovieDetails(@NonNull Movie movie);
    }

    interface Presenter extends BasePresenter {
    }
}
