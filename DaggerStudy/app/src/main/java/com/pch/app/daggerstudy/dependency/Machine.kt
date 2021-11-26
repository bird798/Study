package com.pch.app.daggerstudy.dependency

class Machine(builder: MachineComponent.Builder) {

    private var component : MachineComponent

    init {
        component = builder.setMachineModule(MachineModule())
            .build()
        component.inject(this)
    }

    fun extract() : Coffee {
        return component.getCoffee()
    }


}