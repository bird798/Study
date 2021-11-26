package com.pch.app.daggerstudy.bind

import dagger.Component

@Component(modules = [BindModule::class])
interface BindComponent {

    fun getIBind() : IBind
    fun getBuindClass() : BindClass
    fun getBuindClass2() : BindClass2
}