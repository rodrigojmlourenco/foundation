package io.procrastination.foundation.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import javax.inject.Inject

abstract class FoundationActivity<VB : ViewDataBinding, VM : FoundationViewModel<*>> : AppCompatActivity(), FoundationNavigator {

    lateinit var mViewBinding : VB
    @Inject lateinit var mViewModel : VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewBinding = DataBindingUtil.setContentView(this, getLayoutResId())

        getViewModel()?.let { vm ->
            mViewBinding.setVariable(getBindingVariableId(), vm)
            vm.setLifeCycleOwner(this)

            vm.isLoading.observe(this, Observer { /*TODO: Do something*/ })
        }
    }

    abstract fun getViewModel() : VM?

    fun getViewBinding() : VB =mViewBinding

    @LayoutRes abstract fun getLayoutResId() : Int

    abstract fun getBindingVariableId() : Int

    override fun onBack() {
        onBackPressed()
    }

    override fun hideKeyboard() {

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        currentFocus?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            return
        }

        if (imm.isActive) {
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0) // hide
        }
    }

}