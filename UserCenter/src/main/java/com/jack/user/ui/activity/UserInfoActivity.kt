package com.kotlin.user.ui.activity

import android.os.Bundle
import android.view.View
import com.bigkoo.alertview.AlertView
import com.jack.baselibrary.ui.activity.BaseMvpActivity
import com.jack.user.R
import com.jack.user.injection.component.DaggerUserComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.presenter.UserInfoPresenter
import com.jack.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.toast
import com.bigkoo.alertview.OnItemClickListener


/*
    用户信息界面
 */
class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        initView()

    }

    /*
        初始化视图
     */
    private fun initView() {
        mUserIconIv.setOnClickListener(this)

    }

    /*
        Dagger注册
     */
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

    override fun onUserInfoResult(result: String) {
        toast(result)
    }

    /*
        点击事件
     */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.mUserIconIv -> {
                //头像选择
                AlertView("上传头像", "", "取消", null,
                    arrayOf("拍照", "从相册中选择"),
                    this, AlertView.Style.ActionSheet, OnItemClickListener { _, position ->
                        when (position) {
                            0 -> {
                                toast("拍照")
                            }
                            1 -> {
                                toast("从相册中选择")

                            }
                        }
                    }).show()
            }

        }
    }

}
