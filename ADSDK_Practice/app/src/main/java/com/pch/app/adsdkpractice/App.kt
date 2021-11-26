package com.pch.app.adsdkpractice

import android.app.Application
import android.content.Context
import com.buzzvil.buzzad.benefit.BuzzAdBenefit
import com.buzzvil.buzzad.benefit.BuzzAdBenefitConfig
import com.buzzvil.buzzad.benefit.core.models.UserProfile
import com.buzzvil.buzzad.benefit.presentation.feed.FeedConfig
import com.buzzvil.buzzad.benefit.presentation.feed.header.DefaultFeedHeaderViewAdapter
import com.buzzvil.buzzscreen.sdk.BuzzScreen
import com.pch.app.adsdkpractice.buzzsdkdagger.BuzzAdsComponent
import com.pch.app.adsdkpractice.buzzsdkdagger.DaggerBuzzAdsComponent
import com.pch.app.adsdkpractice.screen.LockScreenActivity
import java.util.*
import javax.inject.Inject

class App : Application() {


    companion object {

        val UNIT_ID_NATIVE_AD = "166467299612761"
        val UNIT_ID_FEED = "213865591634697"

        fun getDaggerComponent(context: Context) : BuzzAdsComponent {
            return DaggerBuzzAdsComponent.builder()
                .setContext(context)
                .Build()
        }
    }

    @Inject
    lateinit var buzzScreen : BuzzScreen


//    @Inject
//    lateinit var userProfile: UserProfile

    override fun onCreate() {
        super.onCreate()

        //  Buzz Screen 초기화
        BuzzScreen.init(
            Constants.UNIT_ID,
            this@App,
            LockScreenActivity::class.java,
            R.drawable.image_on_fail
        )

        getDaggerComponent(applicationContext).inject(this)


        initLockScreen()
        initAdBenefit()
    }

    private fun initLockScreen() {



        // User Profile
        buzzScreen.userProfile.apply {
            userId = "testuserid" + Random().nextInt(100000)
            birthYear = 1979
            gender = UserProfile.Gender.MALE.toString()
            region = "경기도 화성시"
        }

        // 노티피케이션 설정
        val config = buzzScreen.lockerServiceNotificationConfig

        config.title = "AD Screen Practice"
        config.text = "울랄랄라 쑝쑝.. 삐리뽕"

        config.setSmallIconResourceId(R.drawable.han)
        config.setLargeIconResourceId(R.drawable.song)
        config.setShowAlways(true)
    }

    private fun initAdBenefit() {

        val feedConfig = FeedConfig.Builder(this@App, UNIT_ID_FEED)
            .feedHeaderViewAdapterClass(DefaultFeedHeaderViewAdapter::class.java)
            .autoLoadingEnabled(false) // Feed 무한 스크롤 기능
            .build()

        BuzzAdBenefit.init(this, BuzzAdBenefitConfig.Builder(this)
            .setFeedConfig(feedConfig)
            .build())

        val userProfile : UserProfile = UserProfile.Builder(BuzzAdBenefit.getUserProfile())
            .userId("testuserid" + Random().nextInt(100000))
            .birthYear(1979)
            .gender(UserProfile.Gender.MALE)
            .region("경기도 화성시")
            .build()

        BuzzAdBenefit.setUserProfile(userProfile)
    }
}