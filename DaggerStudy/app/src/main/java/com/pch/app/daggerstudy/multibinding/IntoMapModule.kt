package com.pch.app.daggerstudy.multibinding

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import javax.inject.Named

@Module
class IntoMapModule {

    companion object {
        @Provides
        @IntoMap
        @StringKey("foo")
        fun provideFooValue() = 100L

        @Provides
        @IntoMap
        @StringKey("foo1")
        fun provideFooValue1() = 100L

        @Provides
        @IntoMap
        @StringKey("foo2")
        fun provideFooValue2() = 100L


        @Provides
        @IntoMap
        @ClassKey(TestFoo::class)
        fun provideFooStr() : ITestFoo = TestFoo()

        @Provides
        @IntoMap
        @ClassKey(TestFoo2::class)
        fun provideFooStr2() : ITestFoo = TestFoo2()


        @Provides
        @IntoMap
        @ClassKey(TestFoo3::class)
        fun provideFooStr3() : ITestFoo = TestFoo2()

    }
}

interface ITestFoo
class TestFoo : ITestFoo
class TestFoo2 : ITestFoo
class TestFoo3 : ITestFoo