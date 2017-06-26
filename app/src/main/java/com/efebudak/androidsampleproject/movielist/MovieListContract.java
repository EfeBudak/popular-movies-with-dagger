package com.efebudak.androidsampleproject.movielist;

import com.efebudak.androidsampleproject.BasePresenter;
import com.efebudak.androidsampleproject.BaseView;
import com.efebudak.androidsampleproject.data.Movie;

import java.util.List;

/**
 * Created by efebudak on 24/06/2017.
 */

public interface MovieListContract {

    interface View extends BaseView {
        void updateMovieList(List<Movie> movieList);

        void setRefreshing(boolean active);

        void showErrorMessage(String errorMessage);

        void openDetail(long movieId);
    }

    interface Presenter extends BasePresenter {
        void onRefresh();
        void onItemClicked(long movieId);
    }
}
