package com.pch.app.daggerstudy.lazy_kot

import dagger.Component

@Component(modules = [CounterModule_Kot::class])
interface CounterComponent_Kot {

    fun inject(counter: Counter_Kot?)
}