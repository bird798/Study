package com.pch.app.daggerstudy.dependency

import dagger.Module
import dagger.Provides

@Module(subcomponents = [MachineComponent::class])
class CafeModule {

    @Provides
    fun provideWater() = Water()

    @Provides
    fun provideMachine(builder : MachineComponent.Builder) : Machine {
        return Machine(builder)
    }
}