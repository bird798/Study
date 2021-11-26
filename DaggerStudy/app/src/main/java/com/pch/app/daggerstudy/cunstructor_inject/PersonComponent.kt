package com.pch.app.daggerstudy.cunstructor_inject

import dagger.Component

@Component(modules = [PersonModule::class])
interface PersonComponent {

    fun getPersonA() : PersonA   // 프로비전 메서드
    fun getPersonD() : PersonD

    fun inject(personB : PersonB)  //  멤버- 인젝션 메서드
    fun inject(personC : PersonC)
}