package com.swolf.ly.common.entity
data class KArea(var code: Long, var name: String, var subs: List<KArea> = ArrayList<KArea>())