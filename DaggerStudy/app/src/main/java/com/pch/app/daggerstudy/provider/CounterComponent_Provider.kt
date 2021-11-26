package com.pch.app.daggerstudy.provider

import dagger.Component

@Component(modules = [CounterModule_Provider::class])
interface CounterComponent_Provider {

    fun inject(counter: Counter_Provider?)
}