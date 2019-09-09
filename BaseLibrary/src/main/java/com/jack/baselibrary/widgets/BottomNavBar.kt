package com.jack.baselibrary.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.jack.baselibrary.R

/**
 * Created by lcw
 * on 2019-09-08
 */

class BottomNavBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    BottomNavigationBar(context, attrs, defStyleAttr) {

    init {
        //初始化homeItem 选中图片,以及标题
        val homeItem = BottomNavigationItem(R.drawable.btn_nav_home_press, R.string.nav_bar_home)
            //设置未选中图标
            .setInactiveIconResource(R.drawable.btn_nav_home_normal)
            //设置选中字体颜色
            .setActiveColorResource(R.color.common_blue)
            //设置未选中字体颜色
            .setInActiveColorResource(R.color.text_normal)

        //分类
        val categoryItem = BottomNavigationItem(R.drawable.btn_nav_category_press, R.string.nav_bar_category)
            .setInactiveIconResource(R.drawable.btn_nav_category_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //购物车
        val cartItem = BottomNavigationItem(R.drawable.btn_nav_cart_press, R.string.nav_bar_cart)
            .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //消息
        val msgItem = BottomNavigationItem(R.drawable.btn_nav_msg_press, R.string.nav_bar_msg)
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //个人中心
        val userItem = BottomNavigationItem(R.drawable.btn_nav_user_press, R.string.nav_bar_user)
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        //设置navigationBar的模式,固定在下面
        setMode(MODE_FIXED)
        //设置navigationBar的background样式
        setBackgroundStyle(BACKGROUND_STYLE_STATIC)
        //设置navigationBar的background颜色
        setBarBackgroundColor(R.color.common_white)

        //添加item
        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(msgItem)
            .addItem(userItem)
            //默认选择第一个
            .setFirstSelectedPosition(0)
            //navigation的初始化方法
            .initialise()
    }
}