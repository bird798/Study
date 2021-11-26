package com.pch.app.daggerstudy.lazy_kot

import dagger.Lazy
import javax.inject.Inject

class Counter_Kot {
    @Inject
    lateinit var lazy: Lazy<Int>

    fun printLazy() {
        println("printing...")
        println(lazy!!.get())
        println(lazy!!.get())
        println(lazy!!.get())
    }
}