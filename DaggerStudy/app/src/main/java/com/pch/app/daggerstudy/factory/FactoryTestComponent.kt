package com.pch.app.daggerstudy.factory

import dagger.BindsInstance
import dagger.Component

@Component(modules = [FactoryTestModule::class])
interface FactoryTestComponent {

    fun getNumber() : Int
    fun getString() : String

    @Component.Factory
    interface Builder {
        fun create(
                @BindsInstance number : Int
            ) : FactoryTestComponent
    }
}