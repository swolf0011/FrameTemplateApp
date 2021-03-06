package com.swolf.ly.kotlin.nycommonlib.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import java.io.File

object KInstallUtil {
    /**
     * 安装应用的流程  大于8.0需要用户手动打开未知来源安装权限
     * 需要在清单文件中加入权限android.permission.REQUEST_INSTALL_PACKAGES
     */
    fun installPermission(activity: Activity): Boolean {
        var haveInstallPermission = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            haveInstallPermission = activity.packageManager.canRequestPackageInstalls()
        }
        return haveInstallPermission
    }

    /**
     * 请求权限android.permission.REQUEST_INSTALL_PACKAGES
     */
    fun installProcess(activity: Activity, requestPackageInstallsCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //没有未知来源安装权限权限
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("提示")
            builder.setMessage("安装应用需要打开未知来源权限，请去设置中开启应用权限，以允许安装来自此来源的应用")
            builder.setPositiveButton("去设置", { _, _ ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val packageURI = Uri.parse("package:" + activity.packageName)
                    //注意这个是8.0新API
                    val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI)
                    activity.startActivityForResult(intent, requestPackageInstallsCode)
                }
            })

//            builder.setPositiveButton("去设置") { dialog, which ->
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                    val packageURI = Uri.parse("package:" + activity.packageName)
//                    //注意这个是8.0新API
//                    val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES, packageURI)
//                    activity.startActivityForResult(intent, requestPackageInstallsCode)
//                }
//            }
            builder.show()
        }
    }


    /**
     * 安装应用
     */
    fun installApk(context: Context, apkFile: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive")
        } else {//Android7.0之后获取uri要用contentProvider
            val uri = Uri.fromFile(apkFile)
            intent.setDataAndType(uri, "application/vnd.android.package-archive")
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(intent)
    }


    /**
     * 申请未知应用安装权限的回调结果
     */
    fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        requestPackageInstallsCode: Int,
        callback: IResultCallback
    ) {
        if (resultCode != Activity.RESULT_OK) {
            return
        }
        if (requestCode == requestPackageInstallsCode) {
            callback.handler()
        }
    }


    interface IResultCallback {
        fun handler()
    }
}