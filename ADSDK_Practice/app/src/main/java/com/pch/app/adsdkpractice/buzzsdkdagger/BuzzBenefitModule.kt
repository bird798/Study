package com.pch.app.adsdkpractice.buzzsdkdagger

import com.buzzvil.buzzad.benefit.presentation.nativead.NativeAdLoader
import com.pch.app.adsdkpractice.App
import dagger.Module
import dagger.Provides

@Module
class BuzzBenefitModule {

    @Provides
    fun provideNativeAdLoader() : NativeAdLoader {
        return NativeAdLoader(App.UNIT_ID_NATIVE_AD);
    }
}