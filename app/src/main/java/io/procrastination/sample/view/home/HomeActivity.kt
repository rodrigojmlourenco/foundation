package io.procrastination.sample.view.home

import com.android.databinding.library.baseAdapters.BR
import io.procrastination.foundation.view.FoundationActivity
import io.procrastination.sample.R
import io.procrastination.sample.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : FoundationActivity<ActivityHomeBinding, HomeViewModel>(){

    @Inject lateinit var mViewModel : HomeViewModel

    override fun getViewModel(): HomeViewModel? = mViewModel

    override fun getLayoutResId(): Int = R.layout.activity_home

    override fun getBindingVariableId(): Int? = BR.viewModel

}