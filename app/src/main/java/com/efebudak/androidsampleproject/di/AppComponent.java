package com.efebudak.androidsampleproject.di;

import android.app.Application;

import com.efebudak.androidsampleproject.MovieDeciderApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by efebudak on 23/06/2017.
 */

@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityModule.class,
        FragmentModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MovieDeciderApplication app);
}
