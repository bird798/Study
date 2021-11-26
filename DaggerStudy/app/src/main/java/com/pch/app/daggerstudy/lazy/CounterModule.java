package com.pch.app.daggerstudy.lazy;

import dagger.Module;
import dagger.Provides;

@Module
public class CounterModule {

    int next = 100;

    @Provides
    Integer providerInterger() {
        System.out.println("Computing....");
        return next++;
    }
}
