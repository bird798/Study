package com.pch.app.daggerstudy.singleton

import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [SingletonModule::class])
interface SingletonComponent {

    fun getAny() : Any

    @Named("Singleton")
    fun getSingletonAny() : Any
}