package com.jack.baselibrary.presenter

import android.content.Context
import com.jack.baselibrary.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle3.LifecycleProvider
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-28
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>


    @Inject
    lateinit var context: Context

    fun checkedNetwork(): Boolean {

        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }

        mView.onError("网络不可用")

        return false
    }
}