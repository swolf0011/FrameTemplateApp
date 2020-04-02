package com.swolf.ly.kotlin.nycommonlib.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import butterknife.ButterKnife

abstract class KAbsBaseFragmentActivity : FragmentActivity(), KIBaseViewFun, KIView {
    var mActivity: KAbsBaseFragmentActivity? = null
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