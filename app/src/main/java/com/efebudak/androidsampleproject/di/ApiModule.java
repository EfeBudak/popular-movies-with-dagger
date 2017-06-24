package com.efebudak.androidsampleproject.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by efebudak on 24/06/2017.
 */

@Module
public class ApiModule {

    @Provides
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }
}
