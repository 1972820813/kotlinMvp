package com.jack.user.presenter

import android.annotation.SuppressLint
import android.widget.Toast
import com.jack.baselibrary.ext.execute
import com.jack.baselibrary.presenter.BasePresenter
import com.jack.user.presenter.view.ForgetPwdView
import com.jack.user.presenter.view.RegisterView
import com.jack.user.service.UserService
import com.jack.user.service.impl.UserServiceImpl
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-28
 */
class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService

    //注册方法
    @SuppressLint("CheckResult")
    fun forgetPwd(mobile: String, verifyCode: String, pwd: String) {
        /**
         * 处理业务逻辑
         */
        if (!checkedNetwork()) {
            return
        }

        mView.showLoading()

//        val userService = UserServiceImpl()
        userService.forgetPwd(mobile, verifyCode, pwd)
            //传入lifecycleProvider
            .execute(lifecycleProvider)
            .subscribeBy(
                onNext = {
                    mView.onForgetPwdResult("忘记密码")
                    mView.hideLoading()
                },
                onError = { it.printStackTrace() },
                onComplete = { println("Done!") }
            )
    }
}
