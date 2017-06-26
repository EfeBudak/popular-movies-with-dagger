package com.efebudak.androidsampleproject.moviedetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.efebudak.androidsampleproject.R;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieDetailFragment extends Fragment implements MovieDetailContract.View {

    private static final String BUNDLE_MOVIE_ID = "bundleMovieId";
    @Inject
    MovieDetailContract.Presenter presenter;

    private long mMovieId;

    private TextView mTextViewTitle;

    public static MovieDetailFragment newInstance(final long movieId) {
        final MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        final Bundle bundle = new Bundle();
        bundle.putLong(BUNDLE_MOVIE_ID, movieId);
        movieDetailFragment.setArguments(bundle);
        return movieDetailFragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        mMovieId = getArguments().getLong(BUNDLE_MOVIE_ID);
        mTextViewTitle = (TextView) root.findViewById(R.id.fragment_movie_detail_text_view_title);
        mTextViewTitle.setText("Movieid" + mMovieId);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        presenter.unsubscribe();
        super.onPause();
    }
}
