package com.swolf.ly.frametemplateapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.swolf.ly.common.ARouterAddress
import com.swolf.ly.common.ARouterInjectable

@Route(path= ARouterAddress.MainActivity,group="frametemplateapp")
class MainActivity : AppCompatActivity(), ARouterInjectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        ARouter.getInstance().inject(this)
        setContentView(R.layout.activity_main)

//        ARouter.getInstance().inject(this)
        println("0000000111")
        var tvLogin = findViewById(R.id.tvLogin) as TextView
        tvLogin.setOnClickListener(View.OnClickListener { v->
            toLogin()
        } )
    }

    fun toLogin(){
        println("0000000111333")
        ARouter.getInstance().build(ARouterAddress.LoginActivity).navigation()
    }
}
