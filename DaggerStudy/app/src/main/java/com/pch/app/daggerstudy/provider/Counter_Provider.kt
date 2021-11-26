package com.pch.app.daggerstudy.provider

import javax.inject.Inject
import javax.inject.Provider

class Counter_Provider {

    @Inject
    lateinit var provider : Provider<Int>

    fun printProvider() {
        println("printing...")
        println(provider!!.get())
        println(provider!!.get())
        println(provider!!.get())
    }
}