package com.jack.baselibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.jack.baselibrary.R
import org.jetbrains.anko.find

/**
 * Created by lcw
 * on 2019-09-05
 */
class ProgressLoading private constructor(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {
        lateinit var mDialog: ProgressLoading
        private var animDrawable: AnimationDrawable? = null

        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)

            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            //dialog外边不能点击
            mDialog.setCanceledOnTouchOutside(false)

            //设置dialog的位置
            mDialog.window.attributes.gravity = Gravity.CENTER

            //设置属性
            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp

            val ivLoad = mDialog.find<ImageView>(R.id.iv_loading)
            //获取图片背景并强转动画
            animDrawable = ivLoad.background as AnimationDrawable

            return mDialog
        }
    }

    /**
     * 展示dialog
     */
    fun showDialog() {
        super.show()
        //动画开始
        animDrawable?.start()
    }

    /**
     * 取消dialog
     */
    fun hideDialog() {
        super.dismiss()
        //动画停止
        animDrawable?.stop()
    }
}