package io.procrastination.sample.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.procrastination.sample.view.home.HomeActivity
import io.procrastination.sample.view.home.HomeModule
import io.procrastination.sample.view.splash.SplashActivity
import io.procrastination.sample.view.splash.SplashModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun provideSplashActivity() : SplashActivity

    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun provideHomeActivity() : HomeActivity

}