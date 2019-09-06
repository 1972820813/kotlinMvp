package com.jack.user.injection.component

import com.jack.baselibrary.injection.PerComponentScope
import com.jack.baselibrary.injection.component.ActivityComponent
import com.jack.user.injection.module.UserModule
import com.jack.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by lcw
 * on 2019-09-03
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
}