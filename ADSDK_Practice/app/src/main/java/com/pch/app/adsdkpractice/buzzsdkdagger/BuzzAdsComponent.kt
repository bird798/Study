package com.pch.app.adsdkpractice.buzzsdkdagger

import android.content.Context
import com.buzzvil.buzzscreen.sdk.BuzzScreen
import com.pch.app.adsdkpractice.App
import com.pch.app.adsdkpractice.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [BuzzScreenModule::class, BuzzBenefitModule::class])
interface BuzzAdsComponent {

    fun inject(app : App)

    fun inject(activity : MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext (context : Context) : Builder
        fun Build() : BuzzAdsComponent
    }
}