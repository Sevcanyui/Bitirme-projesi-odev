package com.food_service_application.data.model

data class CartResponse(
    val sepet_yemekler: List<CartFood>?,
    val success: Int
)

data class CrudResponse(
    val success: Int,
    val message: String
)