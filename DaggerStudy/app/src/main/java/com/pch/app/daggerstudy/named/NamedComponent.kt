package com.pch.app.daggerstudy.named

import dagger.Component

@Component(modules = [NamedModule::class])
interface NamedComponent {

    fun inject(namedClass: NamedClass)
}