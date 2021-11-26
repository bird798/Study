package com.pch.app.daggerstudy.bind

import javax.inject.Inject

class BindClass @Inject constructor() : IBind {

    @Inject
    lateinit var name : String

    override fun getPersonName() = name
}