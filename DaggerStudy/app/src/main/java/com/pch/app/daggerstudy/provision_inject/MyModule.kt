package com.pch.app.daggerstudy.provision_inject

import dagger.Module
import dagger.Provides

@Module
abstract class MyModule {

    companion object {
        @Provides
        fun provideName() : String {
            return "Chanhee Park"
        }
    }

//    @Provides
//    fun provideName() : String {
//        return "Park Chan Hee";
//    }


    fun provideHelloWorld2() : String {
        return "Hello World2"
    }
}