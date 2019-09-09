package com.jack.user.data.repository

import com.jack.baselibrary.data.net.RetrofitFactory
import com.jack.baselibrary.data.protocol.BaseResp
import com.jack.user.data.api.UserApi
import com.jack.user.data.protocol.RegisterReq
import com.jack.user.data.protocol.UserReq
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by lcw
 * on 2019-08-29
 */

class UserRepository @Inject constructor() {

    fun register(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register()
//        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile, verifyCode, pwd))
    }

    fun login(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<UserReq>> {
        return RetrofitFactory.instance.create(UserApi::class.java).login()
//        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, verifyCode, pwd))
    }

    fun forgetPwd(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<UserReq>> {
        return RetrofitFactory.instance.create(UserApi::class.java).forgetPwd()
//        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, verifyCode, pwd))
    }

    fun resetPwd(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<UserReq>> {
        return RetrofitFactory.instance.create(UserApi::class.java).resetPwd()
//        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, verifyCode, pwd))
    }

    fun userInfo(mobile: String, verifyCode: String, pwd: String): Observable<BaseResp<UserReq>> {
        return RetrofitFactory.instance.create(UserApi::class.java).userInfo()
//        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, verifyCode, pwd))
    }

}