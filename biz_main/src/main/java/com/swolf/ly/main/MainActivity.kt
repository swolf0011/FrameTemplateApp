package com.swolf.ly.main

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.swolf.ly.common.ARouterAddress

import kotlinx.android.synthetic.main.activity_main.*
@Route(path= ARouterAddress.Main_MainActivity)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClickLogin(v: View){
        ARouter.getInstance().build(ARouterAddress.Login_LoginActivity).navigation()
    }
    fun onClickMain(v: View){
        ARouter.getInstance().build(ARouterAddress.Main_MainActivity).navigation()
    }
    fun onClickRegister(v: View){
        ARouter.getInstance().build(ARouterAddress.Login_RegisterActivity).navigation()
    }
    fun onClickHome(v: View){
        ARouter.getInstance().build(ARouterAddress.Main_HomeActivity).navigation()
    }
    fun onClickMessage(v: View){
        ARouter.getInstance().build(ARouterAddress.Message_MessageActivity).navigation()
    }
}
