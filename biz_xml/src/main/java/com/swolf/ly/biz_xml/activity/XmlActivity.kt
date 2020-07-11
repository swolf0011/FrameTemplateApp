package com.swolf.ly.biz_xml.activity

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.swolf.ly.biz_xml.R
import com.swolf.ly.biz_xml.thread.KXmlAsyncTask
import com.swolf.ly.biz_xml.util.KConstant
import com.swolf.ly.common.ARouterAddress
import com.swolf.ly.common.ARouterInjectable
import com.swolf.ly.kotlin.nycommonlib.base.impl.KBaseActivity
import com.swolf.ly.kotlin.nycommonlib.util.KFileUtil
import com.swolf.ly.kotlin.nycommonlib.util.KPermissionUtil

@Route(path = ARouterAddress.Xml_XmlActivity)
class XmlActivity : KBaseActivity(), ARouterInjectable {

    override fun setLayout(): Int {
        return R.layout.activity_xml
    }
    override fun initView() {
        KPermissionUtil.checkSelfPermission2requestPermissions(this, KConstant.ps,KConstant.req_code_xml);
    }
    override fun viewHandler(command: Int, map: Map<String, Any>) {
    }

    fun onClickPase(v: View){
       KXmlAsyncTask().execute(KFileUtil.rootDirectory.absolutePath+"/pagas.html")
    }
}
