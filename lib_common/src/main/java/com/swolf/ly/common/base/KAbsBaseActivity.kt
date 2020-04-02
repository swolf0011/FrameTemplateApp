package com.swolf.ly.kotlin.nycommonlib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import butterknife.ButterKnife
import com.swolf.ly.common.R

abstract class KAbsBaseActivity : AppCompatActivity(), KIBaseViewFun, KIView {
    var mActivity: KAbsBaseActivity? = null
    var binding: ViewDataBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,setLayout())
        mActivity = this
        ButterKnife.bind(this)
        getIntentInData()
        initView()
        initValue()
        getDate()
    }
}