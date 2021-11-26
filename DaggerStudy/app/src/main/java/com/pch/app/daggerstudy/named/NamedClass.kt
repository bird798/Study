package com.pch.app.daggerstudy.named

import javax.inject.Inject
import javax.inject.Named

class NamedClass {

    @Inject
    @Named("Hello")
    lateinit var strHello : String

    @Inject
    @Named("World")
    lateinit var strWorld : String

}