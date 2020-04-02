package com.swolf.ly.login

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.swolf.ly.common.ARouterAddress
import com.swolf.ly.common.ARouterInjectable
import com.swolf.ly.kotlin.nycommonlib.base.impl.KBaseActivity

@Route(path= ARouterAddress.Login_LoginActivity)
class LoginActivity : KBaseActivity(), ARouterInjectable {
    override fun setLayout(): Int {
        return R.layout.activity_login
    }
    override fun viewHandler(command: Int, map: Map<String, Any>) {

    }

    fun onClickLogin(v:View){
        ARouter.getInstance().build(ARouterAddress.Login_LoginActivity).navigation()
    }
    fun onClickMain(v:View){
        ARouter.getInstance().build(ARouterAddress.Main_MainActivity).navigation()
    }
    fun onClickRegister(v:View){
        ARouter.getInstance().build(ARouterAddress.Login_RegisterActivity).navigation()
    }
    fun onClickHome(v:View){
        ARouter.getInstance().build(ARouterAddress.Main_HomeActivity).navigation()
    }
    fun onClickMessage(v:View){
        ARouter.getInstance().build(ARouterAddress.Message_MessageActivity).navigation()
    }
}
