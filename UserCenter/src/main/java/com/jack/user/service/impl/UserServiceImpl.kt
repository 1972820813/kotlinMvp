package com.jack.user.service.impl

import com.jack.baselibrary.ext.flatMapExt
import com.jack.user.data.repository.UserRepository
import com.jack.user.service.UserService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-29
 */
class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    //注册方法
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        //通过observable发送消息
//        return Observable.just(true)

//        val repository = UserRepository()
        return repository.register(mobile, verifyCode, pwd)
            .flatMapExt()
    }
}
