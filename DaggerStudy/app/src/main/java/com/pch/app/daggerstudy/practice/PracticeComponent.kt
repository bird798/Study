package com.pch.app.daggerstudy.practice

import com.pch.app.daggerstudy.singleton.ContainerChild
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [Module::class])
interface PracticeComponent {

    fun getContainer() : ContainerChild
}