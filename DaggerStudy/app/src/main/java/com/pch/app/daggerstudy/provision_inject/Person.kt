package com.pch.app.daggerstudy.provision_inject

import android.content.Context

class Person (val name:String, val birthday: Int){

    lateinit var context: Context

    override fun toString(): String {
        return "${javaClass.simpleName}(name:$name, Birthday:$birthday)"
    }
}