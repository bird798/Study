package com.pch.app.daggerstudy.multibinding

import dagger.Component

@Component(modules = [MultiBindsModules::class])
interface MultibindsComponent {

    fun getStrings() : Set<String>
}