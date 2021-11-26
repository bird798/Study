package com.pch.app.daggerstudy.singleton

import javax.inject.Inject
import javax.inject.Singleton

open class ContainerSuper @Inject constructor(val name : String){
}

class ContainerChild @Inject constructor(name : String, val age : Int) : ContainerSuper(name) {
}