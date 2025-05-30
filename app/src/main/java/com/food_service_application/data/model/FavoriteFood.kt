package com.food_service_application.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favorite_foods")
data class FavoriteFood(
    @PrimaryKey
    val yemekId: Int,
    val yemekAdi: String,
    val yemekResimAdi: String,
    val yemekFiyat: Int,
    val addedDate: Long = System.currentTimeMillis()
) : Parcelable {

    val imageUrl: String
        get() = "http://kasimadalan.pe.hu/yemekler/resimler/$yemekResimAdi"

    val formattedPrice: String
        get() = "₺$yemekFiyat"

    fun toFood(): Food {
        return Food(
            yemekId = yemekId,
            yemekAdi = yemekAdi,
            yemekResimAdi = yemekResimAdi,
            yemekFiyat = yemekFiyat
        )
    }
}