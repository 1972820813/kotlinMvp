package com.jack.user.presenter

import com.jack.baselibrary.presenter.BasePresenter
import com.jack.user.presenter.view.LoginView

/**
 * Created by lcw
 * on 2019-08-29
 */
class LoginPresenter : BasePresenter<LoginView>() {

    fun login() {
        mView.showToast("登录")
    }

}