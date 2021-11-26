package com.pch.app.daggerstudy.cunstructor_inject

import javax.inject.Inject

class PersonD @Inject constructor(name: String, age: Int, var gender: String) : PersonA(name, age) {
}