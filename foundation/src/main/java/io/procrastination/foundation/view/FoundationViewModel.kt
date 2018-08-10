package io.procrastination.foundation.view

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

open class FoundationViewModel<N : FoundationNavigator> : ViewModel(), DefaultLifecycleObserver {

    lateinit var mNavigator: N

    val isLoading = MutableLiveData<Boolean>()

    override fun onCreate(owner: LifecycleOwner) {
        isLoading.postValue(false)
    }

    fun setLifeCycleOwner(owner : LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

}