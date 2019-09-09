package com.jack.user.injection.component

import com.jack.baselibrary.injection.PerComponentScope
import com.jack.baselibrary.injection.component.ActivityComponent
import com.jack.user.injection.module.UserModule
import com.kotlin.user.ui.activity.*
import dagger.Component

/**
 * Created by lcw
 * on 2019-09-03
 */
@PerComponentScope
@Component(dependencies = [ActivityComponent::class], modules = [UserModule::class])
interface UserComponent {

    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserInfoActivity)
}