package io.procrastination.sample.view.splash

import android.content.Intent
import android.databinding.ViewDataBinding
import io.procrastination.foundation.view.FoundationActivity
import io.procrastination.sample.R
import io.procrastination.sample.view.home.HomeActivity
import javax.inject.Inject


class SplashActivity : FoundationActivity<ViewDataBinding, SplashViewModel>(), SplashNavigator{

    @Inject lateinit var mViewModel : SplashViewModel

    override fun getViewModel(): SplashViewModel? = mViewModel

    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun getBindingVariableId(): Int? = null

    override fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}