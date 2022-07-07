package com.example.aroutertest.test.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.example.aroutertest.R


class MainActivity : AppCompatActivity() {

    companion object {
        const val TO_TEST = "to_test"
        private const val TAG = "MainActivity"
    }

    private lateinit var mainText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainText = findViewById<TextView>(R.id.mainText)
        val main = findViewById<Button>(R.id.main)
        main.setOnClickListener {
            ARouter.getInstance().build("/test/activity")
                .withString(TO_TEST, "这是一条来自于MainActivity的消息")
                .navigation(this, 200, object : NavCallback() {

                    override fun onFound(postcard: Postcard?) {
                        super.onFound(postcard)
                        Log.d(TAG, "onFound:找到了路由")
                    }

                    override fun onLost(postcard: Postcard?) {
                        super.onLost(postcard)
                        Log.d(TAG, "onLost:找不到路由")
                    }

                    override fun onArrival(postcard: Postcard?) {
                        Log.d(TAG, "onArrival:路由跳转完成")
                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        super.onInterrupt(postcard)
                        Log.d(TAG, "onInterrupt:路由被拦截")
                    }

                })
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                data?.let {
                    mainText.text = it.getStringExtra(TestActivity.BACK_MAIN)
                }
            }
        }
    }


}