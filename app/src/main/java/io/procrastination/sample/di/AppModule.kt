package io.procrastination.sample.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.procrastination.sample.view.SampleApplication

@Module
class AppModule {

    @Provides
    fun provideContext(application : SampleApplication) : Context {
        return application
    }
}