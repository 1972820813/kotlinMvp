package com.jack.user.injection.module

import com.jack.user.service.UserService
import com.jack.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-09-03
 */

@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}