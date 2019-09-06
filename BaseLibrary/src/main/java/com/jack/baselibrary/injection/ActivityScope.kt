package com.jack.baselibrary.injection

/**
 * Identifies a type that the injector only instantiates once. Not inherited.
 *
 * @see javax.inject.Scope @Scope
 */
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/*
    Activity级别 作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope