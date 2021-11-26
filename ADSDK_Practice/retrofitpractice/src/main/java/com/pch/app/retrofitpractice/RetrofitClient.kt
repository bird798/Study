package com.pch.app.retrofitpractice

import android.text.TextUtils
import android.util.Log
import com.pch.app.retrofitpractice.api.InitApi
import com.pch.app.retrofitpractice.api.InitResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.NullPointerException

object RetrofitClient {

    val TAG = "RetrofitClient"

    val BASE_URL = "https://pxsensdev.syrup.co.kr"


    fun init() {

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val server : InitApi = retrofit.create(InitApi::class.java)

        val body = JSONObject()
        body.put("duid", "golive")
        body.put("appId", "J3i2ADJ20AK3dkD8")
        body.put("udid", "123456789012345")
        body.put("hash", "abcdefghijklmnop0")


        val map = HashMap<String, String>()
        map.put("duid", "golive")
        map.put("appId", "J3i2ADJ20AK3dkD8")
        map.put("udid", "123456789012345")
        map.put("hash", "abcdefghijklmnop0")


        server.initCall(map)
            .enqueue(object : Callback<InitResponse> {

                override fun onResponse(call: Call<InitResponse>, response: Response<InitResponse>) {

                    Log.d(TAG, call.toString() + " " + response.toString())
                }

                override fun onFailure(call: Call<InitResponse>, t: Throwable) {
                    Log.d(TAG, call.toString() + " " + t.toString())
                }

            }
            )

        server.initSingle(map)
            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                    response ->
                Single.create<InitResponse> { emitter ->
//                    emitter.onSuccess()
                    Log.d("NINANO", response.toString() + " " + response.toString())
                }
            }
            .subscribe()

        Single.create<String> {

            emitter ->
                Log.d("Single", "emitter:$emitter")
                emitter.onSuccess("")
                emitter.onSuccess("abc")

        }
            .doOnError() {
                Log.d("Single", "doOnError", it)
                it.printStackTrace()
            }
            .subscribe() {
                value ->
                    if (!TextUtils.isEmpty(value)) {
                        Log.d("Single", "value:$value")
                    }
                    else {
                        Log.d("Single", "value is empty")
                    }
                    Log.d("Single", "subscribe")
            }


    }

}