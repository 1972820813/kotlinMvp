package com.jack.user.ui.activity

import android.os.Bundle
import android.view.KeyEvent
import com.jack.baselibrary.common.AppManager
import com.jack.baselibrary.ext.onClick
import com.jack.baselibrary.ui.activity.BaseMvpActivity
import com.jack.user.R
import com.jack.user.injection.component.DaggerUserComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.presenter.RegisterPresenter
import com.jack.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * Created by lcw
 * on 2019-08-28
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)

        mPresenter.mView = this
    }

    //监听回调
    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //初始化presenter
//        mPresenter = RegisterPresenter()
        //初始化view

        text.onClick {
            mPresenter.register("", "", "")
        }

//        text.setOnClickListener {
//            //通过presenter进行业务逻辑处理
//            mPresenter.register("", "", "")
////            startActivity<LoginActivity>("id" to 10)
//        }
    }

    //按两次退出程序
    private var exitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_DOWN) {

            val time = System.currentTimeMillis()
            if (time - exitTime > 2000) {
                toast("再按一次退出程序")
                exitTime = time
            } else {
                AppManager.instance.exitApp(this)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}