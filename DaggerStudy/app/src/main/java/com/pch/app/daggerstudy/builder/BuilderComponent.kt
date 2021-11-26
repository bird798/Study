package com.pch.app.daggerstudy.builder

import com.pch.app.daggerstudy.provision_inject.MyModule2
import com.pch.app.daggerstudy.provision_inject.Person
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MyModule2::class])
interface BuilderComponent {

    fun getTestModule() : BuilderTestModule

    fun getName() : String
//    fun getInt() : Int

//    fun getModule2() : MyModule2

    @Component.Builder
    interface Builder {

//        @BindsInstance
        fun setModule2(myModule : MyModule2) : Builder
        @BindsInstance
        fun setMyModule(myModule: BuilderTestModule) : Builder
        fun build() : BuilderComponent
    }
}