package com.pch.app.daggerstudy.dependency

import dagger.Component


@Component(modules = [CafeModule::class])
interface CafeComponent {

    fun inject(cafe : Cafe)
}