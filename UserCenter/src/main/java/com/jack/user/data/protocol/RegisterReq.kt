package com.jack.user.data.protocol

/**
 * Created by lcw
 * on 2019-08-29
 */
data class RegisterReq(val mobile: String, val verifyCode: String, val pwd: String) {
}