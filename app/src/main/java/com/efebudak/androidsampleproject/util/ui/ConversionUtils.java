package com.efebudak.androidsampleproject.util.ui;

import android.content.Context;
import android.support.annotation.NonNull;

import com.efebudak.androidsampleproject.R;
import com.efebudak.androidsampleproject.data.Genre;

import java.util.List;

/**
 * Created by efebudak on 26/06/2017.
 */

public final class ConversionUtils {

    private ConversionUtils() {
    }

    public static String generateGenres(@NonNull Context context, @NonNull List<Genre> genreList) {

        if (genreList.isEmpty()) {
            return context.getString(R.string.no_genre);
        }

        StringBuilder result = new StringBuilder();
        for (Genre genre : genreList) {
            result.append(genre.getName());
            result.append(" ");
        }

        return result.toString();
    }
}
