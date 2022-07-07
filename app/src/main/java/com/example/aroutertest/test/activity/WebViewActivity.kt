package com.example.aroutertest.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.aroutertest.R

@Route(path = "webView/activity")
class WebViewActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    val name: String? = null

    @Autowired
    @JvmField
    val age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_web_view)
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl("file:///android_asset/test.html")
        Toast.makeText(this, "$name, $age", Toast.LENGTH_SHORT).show()
    }
}