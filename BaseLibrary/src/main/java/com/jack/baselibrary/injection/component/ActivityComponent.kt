package com.jack.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.jack.baselibrary.injection.ActivityScope
import com.jack.baselibrary.injection.module.ActivityModule
import com.jack.baselibrary.injection.module.LifecycleProvideModule
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Component

/*
    Activity级别Component
 */
@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, LifecycleProvideModule::class])
interface ActivityComponent {

    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>

}