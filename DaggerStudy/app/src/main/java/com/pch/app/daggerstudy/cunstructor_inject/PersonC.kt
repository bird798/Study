package com.pch.app.daggerstudy.cunstructor_inject

import javax.inject.Inject

class PersonC : PersonB() {

    @Inject
    lateinit var gender: String

    @JvmName("getGender1")
    fun getGender(): String {
        return gender
    }

}