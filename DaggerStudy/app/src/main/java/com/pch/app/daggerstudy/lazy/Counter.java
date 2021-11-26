package com.pch.app.daggerstudy.lazy;

import javax.inject.Inject;

import dagger.Lazy;

public class Counter {
    @Inject
    Lazy<Integer> lazy;

    public void printLazy() {
        System.out.println("printing...");
        System.out.println(lazy.get());
        System.out.println(lazy.get());
        System.out.println(lazy.get());
    }
}
