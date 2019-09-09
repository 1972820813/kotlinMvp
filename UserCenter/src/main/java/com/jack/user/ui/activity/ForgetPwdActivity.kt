package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.jack.baselibrary.ext.enable
import com.jack.baselibrary.ui.activity.BaseMvpActivity
import com.jack.user.R
import com.jack.user.injection.component.DaggerUserComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.presenter.ForgetPwdPresenter
import com.jack.user.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/*
    忘记密码页面
 */
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mNextBtn.enable(mMobileEt) { isBtnEnable() }
        mNextBtn.enable(mVerifyCodeEt) { isBtnEnable() }

        mVerifyCodeBtn.setOnClickListener(this)
        mNextBtn.setOnClickListener(this)
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onForgetPwdResult(result: String) {
        toast(result)
        startActivity<ResetPwdActivity>()

    }

    /*
        点击事件
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyCodeBtn -> {
                //下一步
//                mVerifyCodeBtn.requestSendVerifyNumber()

                //处理与服务器的逻辑
            }

            R.id.mNextBtn -> {
                mPresenter.forgetPwd(mMobileEt.text.toString(), "", mVerifyCodeEt.text.toString())
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() and
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}
