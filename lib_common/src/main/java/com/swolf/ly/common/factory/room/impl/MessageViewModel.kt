package com.swolf.ly.kotlin.nycommonlib.factory.room.impl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.swolf.ly.common.entity.Message

class MessageViewModel(app: Application) : AndroidViewModel(app) {
    var mMessageRepository: MessageRepository
    var mLiveData: LiveData<List<Message>>

    init {
        mMessageRepository = MessageRepository(app)
        mLiveData = mMessageRepository.mLiveData!!
    }
}