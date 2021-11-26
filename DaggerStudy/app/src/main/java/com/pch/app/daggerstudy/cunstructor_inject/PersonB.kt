package com.pch.app.daggerstudy.cunstructor_inject

import javax.inject.Inject

open class PersonB (){

    @Inject
    lateinit var name: String

    var age : Int = 0

    @JvmName("setAge2")
    @Inject
    fun setAge(age: Int) {
        this.age = age
    }

    @JvmName("getName2")
    fun getName(): String? {
        return name
    }

    @JvmName("getAge2")
    fun getAge(): Int {
        return age
    }

}