package com.pch.app.retrofitpractice.api

import io.reactivex.Single
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface InitApi {

    @POST("/api/v1/init")
    @Headers(
        "Content-Type: application/json;charset=UTF-8",
        "Accept: application/json;charset=UTF-8",
        "x-skp-c3po-sdk-package: com.skplanet.common.sdk",
        "x-skp-c3po-sdk-version: bb8v1",
        "x-skp-c3po-device-os: adr",
        "x-skp-c3po-device-os-version: 21",
        "x-skp-c3po-device-model: SKP-TEST",
        "x-skp-c3po-timezone: GMT+09:00")
    fun initCall(
        @Body body: Map<String, String>

    ) : Call<InitResponse>

    @POST("/api/v1/init")
    @Headers(
        "Content-Type: application/json;charset=UTF-8",
        "Accept: application/json;charset=UTF-8",
        "x-skp-c3po-sdk-package: com.skplanet.common.sdk",
        "x-skp-c3po-sdk-version: bb8v1",
        "x-skp-c3po-device-os: adr",
        "x-skp-c3po-device-os-version: 21",
        "x-skp-c3po-device-model: SKP-TEST",
        "x-skp-c3po-timezone: GMT+09:00")
    fun initSingle(
        @Body body: Map<String, String>

    ) : Single<InitResponse>
}