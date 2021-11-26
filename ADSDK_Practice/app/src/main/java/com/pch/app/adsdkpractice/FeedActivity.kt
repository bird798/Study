package com.pch.app.adsdkpractice

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.buzzvil.buzzad.benefit.presentation.feed.FeedFragment
import com.buzzvil.buzzad.benefit.presentation.feed.FeedHandler
import com.pch.app.adsdkpractice.databinding.FeedAdLayoutBinding

class FeedActivity : AppCompatActivity() {

    private lateinit var binding: FeedAdLayoutBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FeedAdLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val feedHandler = FeedHandler(this, App.UNIT_ID_FEED)

        val feedFragment : FeedFragment = supportFragmentManager.findFragmentById(R.id.feed_fragment) as FeedFragment
        if (feedFragment != null) {
            feedFragment.init(this, App.UNIT_ID_FEED)
        }
    }

}