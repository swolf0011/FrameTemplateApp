package com.swolf.ly.login

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.swolf.ly.common.ARouterAddress
import com.swolf.ly.common.ARouterInjectable


@Route(path= ARouterAddress.LoginActivity)
class LoginActivity : AppCompatActivity(), ARouterInjectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ARouter.getInstance().inject(this)
        println("0000000111")
        var tvLogin = findViewById(R.id.tvLogin) as TextView
        tvLogin.setOnClickListener(View.OnClickListener { v->
            toApp()
        } )
    }

    fun toApp(){
        println("000000011144444")
        ARouter.getInstance().build(ARouterAddress.MainActivity).navigation()
    }

}
