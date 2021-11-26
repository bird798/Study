package com.pch.app.daggerstudy.cunstructor_inject

import dagger.Module
import dagger.Provides

@Module
class PersonModule {

    @Provides
    fun provideName() : String {
        return "Charles"
    }

    @Provides
    fun provideAge() : Int {
        return 100;
    }

//    @Provides
//    fun provideGender() : String {
//        return "male"
//    }
}