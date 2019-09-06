package com.jack.baselibrary.presenter.view

/**
 * Created by lcw
 * on 2019-08-28
 */
interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun onError(text: String)
}
