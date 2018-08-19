package io.procrastination.sample.view.home

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideViewModel(view : HomeActivity) : HomeViewModel{
        val vm = ViewModelProviders.of(view).get(HomeViewModel::class.java)

        vm.setNavigator(view)
        vm.setLifeCycleOwner(view)

        return vm
    }
}