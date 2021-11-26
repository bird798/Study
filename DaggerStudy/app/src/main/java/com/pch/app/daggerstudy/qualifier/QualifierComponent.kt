package com.pch.app.daggerstudy.qualifier

import com.pch.app.daggerstudy.named.NamedClass
import com.pch.app.daggerstudy.named.NamedModule
import dagger.Component


@Component(modules = [QualifierModule::class])
interface QualifierComponent {

    fun inject(qualifierClass: QualifierClass)
}