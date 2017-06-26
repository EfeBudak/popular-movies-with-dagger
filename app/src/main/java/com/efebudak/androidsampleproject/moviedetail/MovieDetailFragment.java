package com.efebudak.androidsampleproject.moviedetail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.efebudak.androidsampleproject.BuildConfig;
import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.data.Movie;
import com.efebudak.androidsampleproject.util.Constants;
import com.efebudak.androidsampleproject.util.ui.ConversionUtils;
import com.efebudak.androidsampleproject.util.ui.DateUtils;
import com.efebudak.androidsampleproject.util.ui.ImageUtils;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by efebudak on 25/06/2017.
 */

public class MovieDetailFragment extends Fragment implements MovieDetailContract.View {

    private static final String BUNDLE_MOVIE_ID = "bundleMovieId";
    @Inject
    MovieDetailContract.Presenter presenter;

    private ImageView mImageViewBackdrop;
    private TextView mTextViewTitle;
    private TextView mTextViewGenres;
    private TextView mTextViewPopularity;
    private TextView mTextViewOverview;

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

        presenter.setMovieId(getArguments().getLong(BUNDLE_MOVIE_ID));
        mImageViewBackdrop = (ImageView) root.findViewById(R.id.fragment_movie_detail_image_view_backdrop);
        mTextViewTitle = (TextView) root.findViewById(R.id.fragment_movie_detail_text_view_title);
        mTextViewGenres = (TextView) root.findViewById(R.id.fragment_movie_detail_text_view_genres);
        mTextViewPopularity = (TextView) root.findViewById(R.id.fragment_movie_detail_text_view_popularity);
        mTextViewOverview = (TextView) root.findViewById(R.id.fragment_movie_detail_text_view_overview);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void setMovieDetails(@NonNull Movie movie) {
        ImageUtils.loadUrlToImageView(
                getActivity(),
                BuildConfig.BASE_IMAGE_URL + Constants.BACKDROP_SIZE + movie.getBackdropPath(),
                mImageViewBackdrop);
        mTextViewTitle.setText(getString(R.string.title_info, movie.getTitle(), DateUtils.getYear(movie.getReleaseDate())));
        mTextViewGenres.setText(ConversionUtils.generateGenres(getActivity(), movie.getGenres()));
        mTextViewPopularity.setText(getString(R.string.popularity_info, String.valueOf(movie.getPopularity())));
        mTextViewOverview.setText(movie.getOverview());
    }
}
