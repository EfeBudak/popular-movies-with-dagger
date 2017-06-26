package com.efebudak.androidsampleproject.util.ui;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by efebudak on 26/06/2017.
 */

public final class DateUtils {

    private static final String REMOTE_SOURCE_DATE_PATTERN = "yyyy-mm-dd";
    private static final String VIEW_DATE_PATTERN = "yyyy";

    private DateUtils() {
    }

    public static String getYear(@NonNull String formattedDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(REMOTE_SOURCE_DATE_PATTERN);
        Date date = null;
        try {
            date = simpleDateFormat.parse(formattedDate);
        } catch (ParseException e) {
            //log to crashlytics
            e.printStackTrace();
        }
        simpleDateFormat = new SimpleDateFormat(VIEW_DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

}
