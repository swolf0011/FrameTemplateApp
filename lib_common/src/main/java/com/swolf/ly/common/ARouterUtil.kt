package com.swolf.ly.common

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter


object ARouterUtil {
    fun initARouter(app: Application){
        ///初始化路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(app)
    }
}