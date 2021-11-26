package com.pch.app.daggerstudy

import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app : App, appModule: AppModule) : AppComponent
    }
}