package com.pch.app.daggerstudy.multibinding

import dagger.Component

@Component(modules = [IntoMapModule::class])
interface IntoMapComponent {

    fun getLongsByString() : Map<String, Long>
    fun getStringByClass() : Map<Class<*>, ITestFoo>
//    fun getStringByClass() : Map<ITestFoo, ITestFoo>
}