package com.pch.app.daggerstudy.dependency

import javax.inject.Inject

class CoffeeBean
class Water

class Coffee @Inject constructor(coffeeBean : CoffeeBean, water : Water){
}