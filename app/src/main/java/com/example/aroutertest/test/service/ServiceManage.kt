package com.example.aroutertest.test.service

import android.util.Log
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter

class ServiceManage {

    @Autowired
    @JvmField
    var helloService: HelloService? = null

    init {
        ARouter.getInstance().inject(this)
    }

    fun getMsg() {
        //helloService?.showMsg()
        Log.d("ServiceManage", "长按获取服务")
    }

}