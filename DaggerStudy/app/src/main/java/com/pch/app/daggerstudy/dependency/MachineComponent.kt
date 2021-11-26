package com.pch.app.daggerstudy.dependency

import dagger.Component
import dagger.Subcomponent

@Subcomponent(modules = [MachineModule::class])
interface MachineComponent {

    fun getCoffee() : Coffee
    fun getWater() : Water
    fun inject(machine: Machine)

    @Subcomponent.Builder
    interface Builder {
        fun setMachineModule(coffeeMachineModule: MachineModule) : Builder
        fun build() : MachineComponent
    }
}