package com.example.aroutertest.test.interceptor

import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor

@Interceptor(priority = 8)
class MyInterceptor : IInterceptor {
    override fun init(context: Context?) {
        Log.d("MyInterceptor", "MyInterceptor已初始化")
    }

    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        val path = postcard.path
        val isLogin = postcard.extras.getBoolean("flag")
        Log.d("myInterceptor", "path---->$path, $isLogin")
        if (path.equals("/test/activity")) {
            if (isLogin) {
                callback.onContinue(postcard)
            } else {
                callback.onInterrupt(null)
            }
        } else {
            callback.onContinue(postcard)
        }
    }
}