package com.pch.app.adsdkpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.buzzvil.buzzad.benefit.core.ad.AdError
import com.buzzvil.buzzad.benefit.presentation.feed.FeedHandler
import com.buzzvil.buzzad.benefit.presentation.media.CtaPresenter
import com.buzzvil.buzzad.benefit.presentation.nativead.NativeAd
import com.buzzvil.buzzad.benefit.presentation.nativead.NativeAdLoader
import com.buzzvil.buzzad.benefit.presentation.nativead.NativeAdLoader.OnAdLoadedListener
import com.buzzvil.buzzad.benefit.presentation.nativead.NativeAdView
import com.buzzvil.buzzad.benefit.presentation.reward.RewardResult
import com.buzzvil.buzzad.benefit.presentation.video.VideoErrorStatus
import com.buzzvil.buzzad.benefit.presentation.video.VideoEventListener
import com.buzzvil.buzzscreen.sdk.BuzzScreen
import com.buzzvil.buzzscreen.sdk.BuzzScreen.OnActivateListener
import com.buzzvil.buzzscreen.sdk.SecurityConfiguration
import com.pch.app.adsdkpractice.databinding.ActivityMainBinding
import java.util.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), NativeAdView.OnNativeAdEventListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var buzzScreen : BuzzScreen

    @Inject
    lateinit var nativeAdLoader : NativeAdLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.getDaggerComponent(this).inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buzzScreenLayout.buzzScreenStatus.setText(if (buzzScreen.isActivated) "Activated" else "Deactivated")

        buzzScreen.launch()
        buzzScreen.showOverlayPermissionGuideDialogIfNeeded(this@MainActivity)

//        buzzScreen.showBatteryGuide(this@MainActivity, findViewById(android.R.id.content))

//        buzzScreen.showRevokeConsentDialog(this@MainActivity, object :
//            BuzzScreen.OnConsentRevokeListener {
//            override fun onConsentRevoked() {
//            }
//
//            override fun onCancelledByUser() {
//            }
//
//        })

//        buzzScreen.showSecuritySettingsActivity(this)

//        val serviceConfiguration = SecurityConfiguration.Builder()
//            .withSecurity(true)
//            .build()
//
//        buzzScreen.securityConfiguration = serviceConfiguration



    }

    fun activateLockScreen(view: View) {

        buzzScreen.activateIfConsent(this@MainActivity, object : OnActivateListener {
            override fun onActivated() {
                Toast.makeText(this@MainActivity, "Activated", Toast.LENGTH_SHORT).show()
                binding.buzzScreenLayout.buzzScreenStatus.setText(if (buzzScreen.isActivated) "Activated" else "Deactivated")
            }

            override fun onCancelledByUser() {
                binding.buzzScreenLayout.buzzScreenStatus.setText(if (buzzScreen.isActivated) "Activated" else "Deactivated")
                Toast.makeText(this@MainActivity, "Cancelled", Toast.LENGTH_SHORT).show()
            }

            override fun onNetworkError() {
                Toast.makeText(this@MainActivity, "Network Error", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun deactivateLockScreen(view: View) {
//        buzzScreen.deactivate()

        buzzScreen.showLockScreen();
    }

    fun showNativeAdView(view: View) {

        nativeAdLoader.loadAd(object : OnAdLoadedListener {
            override fun onAdLoaded(nativeAd: NativeAd) {
                Toast.makeText(this@MainActivity, "Success to load native ad", Toast.LENGTH_SHORT)
                    .show()

                val ad = nativeAd.ad

                binding.buzzAdsLayout.buzzNativeAdLayout.adMediaView.setCreative(ad.creative)
                binding.buzzAdsLayout.buzzNativeAdLayout.adMediaView.setVideoEventListener(object :
                    VideoEventListener {
                    override fun onVideoStarted() {
                        TODO("Not yet implemented")
                    }

                    override fun onResume() {
                        TODO("Not yet implemented")
                    }

                    override fun onPause() {
                        TODO("Not yet implemented")
                    }

                    override fun onReplay() {
                        TODO("Not yet implemented")
                    }

                    override fun onLanding() {
                        TODO("Not yet implemented")
                    }

                    override fun onError(p0: VideoErrorStatus, p1: String?) {
                        TODO("Not yet implemented")
                    }

                    override fun onVideoEnded() {
                        TODO("Not yet implemented")
                    }
                })

                binding.buzzAdsLayout.buzzNativeAdLayout.adTitleText.text = ad.title
                binding.buzzAdsLayout.buzzNativeAdLayout.adDescriptionText.text = ad.description

                Glide.with(this@MainActivity).load(ad.iconUrl)
                    .into(binding.buzzAdsLayout.buzzNativeAdLayout.adIconImage);

                val ctaPresenter = CtaPresenter(binding.buzzAdsLayout.buzzNativeAdLayout.adCtaView)
                ctaPresenter.bind(nativeAd)

                val createType = if (ad.creative == null) null else ad.creative!!.type


                val clickableViews: MutableList<View> = ArrayList()
                clickableViews.add(binding.buzzAdsLayout.buzzNativeAdLayout.adCtaView)
                clickableViews.add(binding.buzzAdsLayout.buzzNativeAdLayout.adMediaView)
                clickableViews.add(binding.buzzAdsLayout.buzzNativeAdLayout.adDescriptionText)

                binding.buzzAdsLayout.buzzNativeAdLayout.nativeAdView.setMediaView(binding.buzzAdsLayout.buzzNativeAdLayout.adMediaView)
                binding.buzzAdsLayout.buzzNativeAdLayout.nativeAdView.setClickableViews(
                    clickableViews
                )
                binding.buzzAdsLayout.buzzNativeAdLayout.nativeAdView.setNativeAd(nativeAd)

                binding.buzzAdsLayout.buzzNativeAdLayout.nativeAdView.removeOnNativeAdEventListener(
                    this@MainActivity
                )
                binding.buzzAdsLayout.buzzNativeAdLayout.nativeAdView.addOnNativeAdEventListener(
                    this@MainActivity
                )
            }

            override fun onLoadError(adError: AdError) {
                Toast.makeText(
                    this@MainActivity,
                    "Failed to load native ad: ${adError.errorType} ${adError.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    fun showFeedTypeActivity(view: View) {

        val feedHandler = FeedHandler(this, App.UNIT_ID_FEED)
        feedHandler.startFeedActivity(this);
    }

    fun showFeedTypeFragment(view: View) {

        startActivity(Intent(this@MainActivity, FeedActivity::class.java))

    }

    override fun onResume() {
        super.onResume()
        binding.buzzScreenLayout.buzzScreenStatus.setText(if (buzzScreen.isActivated) "Activated" else "Deactivated")
    }

    override fun onImpressed(p0: NativeAdView, p1: NativeAd) {
        Toast.makeText(this@MainActivity, "[onImpressed]", Toast.LENGTH_SHORT).show()

        Log.d("Native Ad", "onImpressed")
    }

    override fun onClicked(p0: NativeAdView, p1: NativeAd) {
        Toast.makeText(this@MainActivity, "[onClicked]", Toast.LENGTH_SHORT).show()
        Log.d("Native Ad", "onClicked")
    }

    override fun onRewardRequested(p0: NativeAdView, p1: NativeAd) {
        Toast.makeText(this@MainActivity, "[onRewardRequested]", Toast.LENGTH_SHORT).show()
        Log.d("Native Ad", "onRewardRequested")
    }

    override fun onRewarded(p0: NativeAdView, p1: NativeAd, p2: RewardResult?) {
        Toast.makeText(this@MainActivity, "[onRewarded]", Toast.LENGTH_SHORT).show()
        Log.d("Native Ad", "onRewarded")
    }

    override fun onParticipated(p0: NativeAdView, p1: NativeAd) {
        Toast.makeText(this@MainActivity, "[onParticipated]", Toast.LENGTH_SHORT).show()
        Log.d("Native Ad", "onParticipated")
    }
}
