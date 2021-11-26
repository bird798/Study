package com.pch.app.daggerstudy.member_injecttion

import com.pch.app.daggerstudy.provision_inject.Person
import javax.inject.Inject

class MyClass {

    @Inject
    public lateinit var str : String

    @Inject
    lateinit var person: Person

    @JvmName("getStr1")
    fun getStr() : String                                                                                            {
        return str
    }

    @JvmName("getPerson1")
    fun getPerson() : Person {
        return person
    }

}