package com.food_service_application.data.model

data class FoodsResponse(
    val yemekler: List<Food>?,
    val success: Int
)