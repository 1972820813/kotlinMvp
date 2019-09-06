package com.jack.baselibrary.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jack.baselibrary.common.BaseApplication
import com.jack.baselibrary.injection.component.ActivityComponent
import com.jack.baselibrary.injection.component.DaggerActivityComponent
import com.jack.baselibrary.injection.module.ActivityModule
import com.jack.baselibrary.injection.module.LifecycleProvideModule
import com.jack.baselibrary.presenter.BasePresenter
import com.jack.baselibrary.presenter.view.BaseView
import com.jack.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-28
 */
open abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    override fun showLoading() {
        mDialog.showLoading()
    }

    override fun hideLoading() {
        mDialog.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mDialog = ProgressLoading.create(context!!)

        initActivityInjection()

        injectComponent()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    abstract fun injectComponent()

    lateinit var mActivityComponent: ActivityComponent

    private lateinit var mDialog: ProgressLoading

    private fun initActivityInjection() {

        mActivityComponent =
            DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
                .lifecycleProvideModule(LifecycleProvideModule(this))
                .build()
    }
}