package com.efebudak.androidsampleproject.util.ui;

import android.content.Context;
import android.widget.ImageView;

import com.efebudak.androidsampleproject.R;
import com.squareup.picasso.Picasso;

/**
 * Created by efebudak on 25/06/2017.
 */

public final class ImageUtils {

    private ImageUtils() {
    }

    public static void loadUrlToImageView(Context context, String imageUrl, ImageView imageView) {
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.icon_tmdb)
                .into(imageView);
    }
}

