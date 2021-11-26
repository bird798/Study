package com.pch.app.daggerstudy.provision_inject

import com.pch.app.daggerstudy.member_injecttion.MyClass
import dagger.Component
import dagger.MembersInjector

@Component(modules = [MyModule2::class])
interface MyComponent {
    fun getString():String  //  프로비전 메써드 바인드된 모듈로 부터 의존성 을 제공
    fun getInt():Int
    fun getPerson():Person

    fun inject(myClass: MyClass)

    fun getInject() : MembersInjector<MyClass>  //  Member Inject를 직접 사용하는 경우
}

