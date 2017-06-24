package com.efebudak.androidsampleproject.di;

import com.efebudak.androidsampleproject.BuildConfig;
import com.efebudak.androidsampleproject.data.source.MovieDataSource;
import com.efebudak.androidsampleproject.data.source.MovieRepository;
import com.efebudak.androidsampleproject.data.source.TMDBService;
import com.efebudak.androidsampleproject.data.source.remote.RemoteMovieDataSource;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by efebudak on 24/06/2017.
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    Converter.Factory provideConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    @Named("baseUrl")
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Singleton
    @Provides
    @Named("baseImageUrl")
    String provideBaseImageUrl() {
        return BuildConfig.BASE_IMAGE_URL;
    }

    @Singleton
    @Provides
    @Named("apiVersion")
    String provideApiVersion() {
        return "3/";
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(
            @Named("baseUrl") String baseUrl,
            @Named("apiVersion") String apiVersion,
            Converter.Factory factory) {
        final String urlWithVersion = baseUrl + apiVersion;
        return new Retrofit.Builder()
                .baseUrl(urlWithVersion)
                .addConverterFactory(factory)
                .build();
    }

    @Singleton
    @Provides
    TMDBService provideService(Retrofit retrofit) {
        return retrofit.create(TMDBService.class);
    }

    @Singleton
    @Provides
    @Named("remoteDataSource")
    MovieDataSource provideRemoteMovieDataSource(RemoteMovieDataSource remoteMovieDataSource) {
        return remoteMovieDataSource;
    }

    @Singleton
    @Provides
    MovieDataSource provideMovieDataSource(MovieRepository movieRepository) {
        return movieRepository;
    }

}
