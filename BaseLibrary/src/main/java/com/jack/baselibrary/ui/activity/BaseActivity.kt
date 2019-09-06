package com.jack.baselibrary.ui.activity

import android.os.Bundle
import com.jack.baselibrary.common.AppManager
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity


/**
 * Created by lcw
 * on 2019-08-28
 */
open class BaseActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }
}