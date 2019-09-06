package com.jack.baselibrary.common

import android.app.Application
import com.jack.baselibrary.injection.component.AppComponent
import com.jack.baselibrary.injection.component.DaggerAppComponent
import com.jack.baselibrary.injection.module.AppModule

/**
 * Created by lcw
 * on 2019-09-03
 */

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initInjection()
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}
