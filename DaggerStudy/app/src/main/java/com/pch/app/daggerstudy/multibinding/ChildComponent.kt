package com.pch.app.daggerstudy.multibinding

import dagger.Subcomponent

@Subcomponent(modules = [ChildModule::class])
interface ChildComponent {

    fun strings() : Set<String>

    @Subcomponent.Builder
    interface Builder {
        fun build() : ChildComponent
    }
}