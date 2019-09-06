package com.jack.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by lcw
 * on 2019-09-03
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun providesActivity(): Activity {
        return activity
    }
}