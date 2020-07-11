package com.swolf.ly.biz_xml.thread

import android.os.AsyncTask
import com.swolf.ly.biz_xml.handler.KSAXHandler
import com.swolf.ly.biz_xml.out.KWriteXmlFile
import com.swolf.ly.common.util.KXmlUtil
import com.swolf.ly.kotlin.nycommonlib.util.KFileUtil
import java.io.File

class KXmlAsyncTask() : AsyncTask<String, Void, Void>() {
    override fun doInBackground(vararg params: String?): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var file = File(params[0])
        var saxHandle = KSAXHandler()
        KXmlUtil.paseFile(saxHandle,file)

        var set = saxHandle.getSet()

        KWriteXmlFile.write(set,KFileUtil.rootDirectory.absolutePath+"/new.html")

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        System.out.println("!==完成")
    }

}