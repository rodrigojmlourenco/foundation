package io.procrastination.sample.view

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.procrastination.sample.di.DaggerAppComponent
import javax.inject.Inject

class SampleApplication : Application(), HasActivityInjector {

    @Inject lateinit var mActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)


    }

    override fun activityInjector(): AndroidInjector<Activity> = mActivityInjector
}