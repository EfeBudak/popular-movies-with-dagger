package com.efebudak.androidsampleproject.moviedetail;

import dagger.Binds;
import dagger.Module;

/**
 * Created by efebudak on 25/06/2017.
 */

@Module
public abstract class MovieDetailFragmentModule {

    @Binds
    abstract MovieDetailContract.View provideDetailView(MovieDetailFragment movieDetailFragment);

    @Binds
    abstract MovieDetailContract.Presenter provideDetailPresenter(MovieDetailPresenter movieDetailPresenter);
}
