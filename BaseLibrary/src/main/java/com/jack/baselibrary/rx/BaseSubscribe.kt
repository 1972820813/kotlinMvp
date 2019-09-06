package com.jack.baselibrary.rx

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by lcw
 * on 2019-08-29
 */
open class BaseSubscribe<T> : Subscriber<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(s: Subscription) {

    }

    override fun onNext(t: T) {

    }

    override fun onError(t: Throwable) {

    }
}