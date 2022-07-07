package com.example.aroutertest

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApplication : Application() {

    private val isDebugARouter = true

    override fun onCreate() {
        super.onCreate()
        if (isDebugARouter) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

}