package com.example.moduleone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/module1/module-one")
class ModuleOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_one)
        val moduleOneJump = findViewById<Button>(R.id.moduleOneJump)
        moduleOneJump.setOnClickListener {
            ARouter.getInstance().build("/module2/module-two").navigation()
        }
    }
}