package com.jack.baselibrary.data.protocol

/**
 * Created by lcw
 * on 2019-08-29
 */
class BaseResp<out T>(val msg: String, val code: Int, val data: T)
