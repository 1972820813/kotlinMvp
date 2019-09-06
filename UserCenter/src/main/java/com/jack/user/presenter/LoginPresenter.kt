package com.jack.user.presenter

import android.annotation.SuppressLint
import android.widget.Toast
import com.jack.baselibrary.ext.execute
import com.jack.baselibrary.presenter.BasePresenter
import com.jack.user.presenter.view.LoginView
import com.jack.user.presenter.view.RegisterView
import com.jack.user.service.UserService
import com.jack.user.service.impl.UserServiceImpl
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-28
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService

    //注册方法
    @SuppressLint("CheckResult")
    fun login(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 处理业务逻辑
         */
        if (!checkedNetwork()) {
            return
        }

        mView.showLoading()

//        val userService = UserServiceImpl()
        userService.login(mobile, verifyCode, pwd)
            //传入lifecycleProvider
            .execute(lifecycleProvider)
            .subscribeBy(
                onNext = {
                    mView.onLoginResult("登录")
                    mView.hideLoading()
                },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
    }
}
