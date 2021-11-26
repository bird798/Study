package com.pch.app.adsdkpractice.buzzsdkdagger

import com.buzzvil.buzzscreen.sdk.BuzzScreen
import dagger.Module
import dagger.Provides

@Module
class BuzzScreenModule {

    @Provides
    fun getBuzzScreenInstance() : BuzzScreen {
        return BuzzScreen.getInstance()
    }
}