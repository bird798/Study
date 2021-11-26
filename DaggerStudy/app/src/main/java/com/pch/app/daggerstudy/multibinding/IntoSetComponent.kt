package com.pch.app.daggerstudy.multibinding

import dagger.Component

@Component(modules = [IntoSetModule::class])
interface IntoSetComponent {

    fun getStringSet() : Set<String>

//    fun getString() : String
}
