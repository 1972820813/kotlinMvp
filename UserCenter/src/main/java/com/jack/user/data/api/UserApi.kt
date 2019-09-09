package com.jack.user.data.api

import com.jack.baselibrary.data.protocol.BaseResp
import com.jack.user.data.protocol.RegisterReq
import com.jack.user.data.protocol.UserReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by lcw
 * on 2019-08-29
 */
interface UserApi {

    @POST("api/user/register")
    //带有请求参数的body
//    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
    fun register(): Observable<BaseResp<String>>

    @POST("api/user/login")
//    fun login(@Body req: RegisterReq): Observable<BaseResp<String>>
    fun login(): Observable<BaseResp<UserReq>>

    @POST("api/user/login")
//    fun login(@Body req: RegisterReq): Observable<BaseResp<String>>
    fun forgetPwd(): Observable<BaseResp<UserReq>>

    @POST("api/user/login")
//    fun resetPwd(@Body req: RegisterReq): Observable<BaseResp<String>>
    fun resetPwd(): Observable<BaseResp<UserReq>>


    @POST("api/user/login")
//    fun userInfo(@Body req: RegisterReq): Observable<BaseResp<String>>
    fun userInfo(): Observable<BaseResp<UserReq>>

}