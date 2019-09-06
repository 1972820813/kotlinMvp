package com.jack.baselibrary.data.net

import com.jack.baselibrary.common.BASE_URL
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by lcw
 * on 2019-08-29
 *
 * 单例模式以及延时加载
 *
 */
class RetrofitFactory private constructor() {

    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    //初始化retrofit
    private val retrofit: Retrofit
    //请求拦截器,添加请求头数据
    private val interceptor: Interceptor

    init {
        //okHttp请求拦截器
        interceptor = Interceptor { chain ->
            //通过chain获取request
            val request: Request = chain.request()
                //获取builder
                .newBuilder()
                //添加请求头数据
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "utf-8")
                //通过request创建
                .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    /**
     * 创建并初始化okHttpClient 并设置请求时间和连接时间
     */
    private fun initClient(): OkHttpClient? {
        return OkHttpClient.Builder()
            //http日志拦截器
            .addInterceptor(initLoggerInterceptor())
            .addInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    /**
     *  设置日志拦截器,并设置打印等级
     */
    private fun initLoggerInterceptor(): Interceptor? {
        val interceptor = HttpLoggingInterceptor()
        //设置日志等级
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    //创建并返回service
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}