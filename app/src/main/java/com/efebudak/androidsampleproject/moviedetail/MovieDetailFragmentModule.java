package com.efebudak.androidsampleproject.moviedetail;

import com.efebudak.androidsampleproject.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by efebudak on 25/06/2017.
 */

@FragmentScope
@Module
public class MovieDetailFragmentModule {

    @FragmentScope
    @Provides
    MovieDetailContract.View provideDetailView(MovieDetailFragment movieDetailFragment) {
        return movieDetailFragment;
    }

    @FragmentScope
    @Provides
    MovieDetailContract.Presenter provideDetailPresenter(MovieDetailPresenter movieDetailPresenter) {
        return movieDetailPresenter;
    }

    @FragmentScope
    @Provides
    Long provideMovieId(MovieDetailActivity movieDetailActivity) {
        return movieDetailActivity.movieId;
    }
}
