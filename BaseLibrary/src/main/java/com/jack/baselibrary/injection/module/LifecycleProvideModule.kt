package com.jack.baselibrary.injection.module

import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by lcw
 * on 2019-09-03
 */

@Module
class LifecycleProvideModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}