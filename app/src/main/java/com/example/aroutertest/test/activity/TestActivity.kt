package com.example.aroutertest.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.aroutertest.R

@Route(path = "/test/activity")
class TestActivity : AppCompatActivity() {


    companion object {
        const val BACK_MAIN = "back_main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val testText = findViewById<TextView>(R.id.testText)

        intent?.let {
            val data = it.getStringExtra(MainActivity.TO_TEST)
            testText.text = data
            it.putExtra(BACK_MAIN, "这是一条来自TestActivity的消息")
            setResult(RESULT_OK, it)
        }

    }
}