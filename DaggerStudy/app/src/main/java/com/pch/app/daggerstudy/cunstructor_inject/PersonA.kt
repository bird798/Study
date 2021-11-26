package com.pch.app.daggerstudy.cunstructor_inject

import javax.inject.Inject

open class PersonA @Inject constructor(var name : String, var age : Int) {

}