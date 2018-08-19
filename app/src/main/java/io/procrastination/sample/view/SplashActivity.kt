package io.procrastination.sample.view

import android.databinding.ViewDataBinding
import io.procrastination.foundation.view.FoundationActivity
import io.procrastination.foundation.view.FoundationNavigator
import io.procrastination.foundation.view.FoundationViewModel
import io.procrastination.sample.R


class SplashActivity : FoundationActivity<ViewDataBinding, FoundationViewModel<FoundationNavigator>>(){

    override fun getViewModel(): FoundationViewModel<FoundationNavigator>? = null

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun getBindingVariableId(): Int = 0

}