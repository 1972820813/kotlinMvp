package com.jack.user.service.impl

import com.jack.baselibrary.ext.flatMapExt
import com.jack.baselibrary.ext.flatMapExtT
import com.jack.user.data.protocol.UserReq
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
        //通过dagger2注解   实现实体类
//        val repository = UserRepository()
        return repository.register(mobile, verifyCode, pwd)
            .flatMapExt()
    }

    //登录
    override fun login(mobile: String, verifyCode: String, pwd: String): Observable<UserReq> {
        return repository.login(mobile, verifyCode, pwd)
            .flatMapExtT()
    }

    //忘记密码
    override fun forgetPwd(mobile: String, verifyCode: String, pwd: String): Observable<UserReq> {
        return repository.forgetPwd(mobile, verifyCode, pwd)
            .flatMapExtT()
    }

    override fun resetPwd(mobile: String, verifyCode: String, pwd: String): Observable<UserReq> {
        return repository.resetPwd(mobile, verifyCode, pwd)
            .flatMapExtT()
    }

    override fun userInfo(mobile: String, verifyCode: String, pwd: String): Observable<UserReq> {
        return repository.userInfo(mobile, verifyCode, pwd)
            .flatMapExtT()
    }
}
