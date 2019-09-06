package com.jack.baselibrary.ui.activity

import android.os.Bundle
import com.jack.baselibrary.common.BaseApplication
import com.jack.baselibrary.injection.component.ActivityComponent
import com.jack.baselibrary.injection.component.DaggerActivityComponent
import com.jack.baselibrary.injection.module.ActivityModule
import com.jack.baselibrary.injection.module.LifecycleProvideModule
import com.jack.baselibrary.presenter.BasePresenter
import com.jack.baselibrary.presenter.view.BaseView
import com.jack.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-28
 */
open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    override fun showLoading() {
        mDialog.showDialog()
    }

    override fun hideLoading() {
        mDialog.hideDialog()
    }

    override fun onError(text: String) {
        toast(text)
    }

    @Inject
    lateinit var mPresenter: T

    lateinit var mDialog: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mDialog = ProgressLoading.create(this)

        initActivityInjection()

        injectComponent()
    }

    abstract fun injectComponent()

    lateinit var mActivityComponent: ActivityComponent

    private fun initActivityInjection() {

        mActivityComponent =
            DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProvideModule(LifecycleProvideModule(this))
                .build()
    }
}