package com.jack.baselibrary.injection.component

import android.content.Context
import com.jack.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/*
    Application级别Component
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun context(): Context
}