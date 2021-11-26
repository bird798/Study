package com.pch.app.daggerstudy.practice

import com.pch.app.daggerstudy.singleton.ContainerChild
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module {

    @Provides
    fun getName()  = "Name ${System.currentTimeMillis()}"

    @Provides
    fun getAge()  = System.currentTimeMillis() % 20

    @Singleton
    @Provides
    fun getContainer() : ContainerChild = ContainerChild("ninano", 11)
}