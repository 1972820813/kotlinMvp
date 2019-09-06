package com.jack.user.presenter.view

import com.jack.baselibrary.presenter.view.BaseView

/**
 * Created by lcw
 * on 2019-08-28
 */
interface LoginView : BaseView {
    //请求结果回调
    fun onLoginResult(result: String)

}