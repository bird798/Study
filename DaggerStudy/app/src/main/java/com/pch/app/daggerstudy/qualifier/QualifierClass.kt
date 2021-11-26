package com.pch.app.daggerstudy.qualifier

import javax.inject.Inject


class QualifierClass {
    @Inject
    @Hello_Kot
    lateinit var strHello : String

    @Inject
    lateinit var strWorld : String
}