package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.jack.baselibrary.ext.enable
import com.jack.baselibrary.ui.activity.BaseMvpActivity
import com.jack.user.R
import com.jack.user.injection.component.DaggerUserComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.presenter.ResetPwdPresenter
import com.jack.user.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

/*
    重置密码界面
 */
class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)

        initView()
    }

    /*
        初始化视图
     */
    private fun initView() {
        mConfirmBtn.enable(mPwdEt) { isBtnEnable() }
        mConfirmBtn.enable(mPwdConfirmEt) { isBtnEnable() }

        mConfirmBtn.setOnClickListener(this)
    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onResetPwdResult(result: String) {
        toast(result)

        //intent设置singleTop
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())

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

            R.id.mConfirmBtn -> {
                mPresenter.resetPwd(mPwdEt.text.toString(), "", mPwdConfirmEt.text.toString())
            }
        }
    }

    /*
        判断按钮是否可用
     */
    private fun isBtnEnable(): Boolean {
        return mPwdEt.text.isNotEmpty() and
                mPwdConfirmEt.text.isNotEmpty()
    }
}
