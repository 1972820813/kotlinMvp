package com.jack.baselibrary.ext

import android.annotation.SuppressLint
import android.view.View
import com.jack.baselibrary.data.protocol.BaseResp
import com.jack.baselibrary.rx.BaseException
import com.trello.rxlifecycle3.LifecycleProvider
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by lcw
 * on 2019-08-29
 * lifecycleProvider: LifecycleProvider<*>
 */
@SuppressLint("CheckResult")
fun <T : Any> Observable<T>.execute(lifecycleProvider: LifecycleProvider<*>): Observable<T> {
    //监听
    return this
        .compose(lifecycleProvider.bindToLifecycle())
        .observeOn(AndroidSchedulers.mainThread())
        //订阅
        .subscribeOn(Schedulers.io())
}

@SuppressLint("CheckResult")
fun <T> Observable<BaseResp<T>>.flatMapExt(): Observable<Boolean> {
    return this.flatMap { t ->
        if (t.code != 0) {
            Observable.error<Boolean>(BaseException(t.code, t.msg))
        }
        Observable.just(true)
    }
}

//任意类型
@SuppressLint("CheckResult")
fun <T> Observable<BaseResp<T>>.flatMapExtT(): Observable<T> {
    return this.flatMap { t ->
        if (t.code != 0) {
            Observable.error<T>(BaseException(t.code, t.msg))
        }
        Observable.just(t.data)
    }
}

//重写onclick方法
fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}


