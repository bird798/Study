package com.pch.app.daggerstudy.dependency

import dagger.Module
import dagger.Provides

@Module
class MachineModule {

    @Provides
    fun provideCoffeeBean() : CoffeeBean {
        return CoffeeBean()
    }
}