package com.swolf.ly.common.factory.retrofit

import com.swolf.ly.common.factory.okhttp.KOkHttpUtil
import com.swolf.ly.common.factory.retrofit.biz.KRequestURL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class KRetrofitUtil {
    companion object {
        private object NYSubHolder {
            val util = KRetrofitUtil()
        }
        val instance: KRetrofitUtil
            get() = NYSubHolder.util
    }
    public val mRetrofit: Retrofit
    init {
        //使用该OkHttpClient创建一个Retrofit对象
        mRetrofit = Retrofit.Builder()
            //添加Gson数据格式转换器支持
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            //添加RxJava语言支持
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //指定网络请求client
            .client(KOkHttpUtil.okHttpClient)
            .baseUrl(KRequestURL.BASE_URL)
            .build()
    }
}