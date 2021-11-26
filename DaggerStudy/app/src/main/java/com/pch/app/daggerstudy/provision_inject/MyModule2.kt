package com.pch.app.daggerstudy.provision_inject

import dagger.Module
import dagger.Provides

@Module(includes = [MyModule::class])
//@Module
class MyModule2 {

    lateinit var person: Person

    @Provides
    fun provideBirthDay() : Int {
        return 791218;
    }

    @Provides
    fun providePerson(name : String, birthday : Int) : Person {
        return Person(name, birthday)
    }

    @JvmName("setPerson1")
    fun setPerson(person : Person) {
        this.person = person
    }
}