package io.procrastination.foundation.view

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.procrastination.foundation.domain.usecases.UseCaseExecutor

abstract class FoundationViewModel<N : FoundationNavigator> : ViewModel(), DefaultLifecycleObserver, UseCaseExecutor {

    lateinit var mNavigator: N

    override val isLoading: MutableLiveData<Boolean>
        get() = MutableLiveData()


    override fun onCreate(owner: LifecycleOwner) {
        isLoading.postValue(false)
    }

    fun setLifeCycleOwner(owner : LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }



}