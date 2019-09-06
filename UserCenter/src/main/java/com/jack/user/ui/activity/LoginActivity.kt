package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.jack.baselibrary.ext.enable
import com.jack.baselibrary.ui.activity.BaseMvpActivity
import com.jack.user.R
import com.jack.user.injection.component.DaggerUserComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.presenter.LoginPresenter
import com.jack.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/*
    注册界面
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView, View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()

    }

    /*
        初始化视图
     */
    private fun initView() {

        mLoginBtn.enable(mMobileEt) { isBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isBtnEnable() }

        mForgetPwdTv.setOnClickListener(this)
        mLoginBtn.setOnClickListener(this)
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onLoginResult(result: String) {
        toast(result)
        finish()
    }

    /*
        点击事件
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mForgetPwdTv -> {
//                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("忘记密码")
            }

            R.id.mLoginBtn -> {
                //登录
                mPresenter.login("", "", "")
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() and
                mPwdEt.text.isNullOrEmpty().not()
    }
}
