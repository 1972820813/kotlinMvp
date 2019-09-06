package com.jack.user.service

import com.jack.user.data.protocol.UserReq
import io.reactivex.Observable

/**
 * Created by lcw
 * on 2019-08-29
 */
interface UserService {

    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>

    fun login(mobile: String, verifyCode: String, pwd: String): Observable<UserReq>

}