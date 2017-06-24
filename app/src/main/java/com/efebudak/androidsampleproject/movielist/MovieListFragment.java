package com.efebudak.androidsampleproject.movielist;

import android.support.v4.app.Fragment;

/**
 * Created by efebudak on 23/06/2017.
 */

public class MovieListFragment extends Fragment implements MovieListContract.View {

    private MovieListContract.Presenter mPresenter;

    @Override
    public void setPresenter(MovieListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
