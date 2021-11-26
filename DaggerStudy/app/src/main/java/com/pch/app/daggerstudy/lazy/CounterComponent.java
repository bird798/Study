package com.pch.app.daggerstudy.lazy;

import dagger.Component;

@Component(modules = CounterModule.class)
public interface CounterComponent {

    void inject(Counter counter);
}
