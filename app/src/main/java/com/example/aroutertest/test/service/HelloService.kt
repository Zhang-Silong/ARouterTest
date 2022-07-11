package com.example.aroutertest.test.service

import android.content.Context
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.template.IProvider
@Route(path = "/hello/service")
class HelloService : IProvider {

    private lateinit var context: Context

    override fun init(context: Context) {
        this.context = context
    }

    fun showMsg() {
        Toast.makeText(context, "HelloService", Toast.LENGTH_SHORT).show()
    }


}