package com.pch.app.daggerstudy.bind

import javax.inject.Inject

class BindClass2 @Inject constructor() : IBind {

    @Inject
    lateinit var age : Number

    override fun getPersonName() = "$age"
}