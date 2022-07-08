package com.example.aroutertest.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.aroutertest.R

@Route(path = "/testWeb/activity")
class TestWebActivity : AppCompatActivity() {

    @Autowired
    @JvmField
    var name: String? = null

    @Autowired
    @JvmField
    var age: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_web)
        ARouter.getInstance().inject(this)
        Toast.makeText(this, "$name, $age", Toast.LENGTH_SHORT).show()
    }
}