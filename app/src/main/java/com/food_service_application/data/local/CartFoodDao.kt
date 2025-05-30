package com.food_service_application.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.food_service_application.data.model.CartFood

@Dao
interface CartFoodDao {
    @Query("SELECT * FROM cart_foods")
    fun getAllCartFoods(): LiveData<List<CartFood>>

    @Query("SELECT * FROM cart_foods WHERE sepetYemekId = :cartFoodId")
    suspend fun getCartFoodById(cartFoodId: Int): CartFood?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartFood(cartFood: CartFood)

    @Update
    suspend fun updateCartFood(cartFood: CartFood)

    @Delete
    suspend fun deleteCartFood(cartFood: CartFood)

    @Query("DELETE FROM cart_foods WHERE sepetYemekId = :cartFoodId")
    suspend fun deleteCartFoodById(cartFoodId: Int)

    @Query("DELETE FROM cart_foods")
    suspend fun clearCart()

    @Query("SELECT SUM(yemekFiyat * yemekSiparisAdet) FROM cart_foods")
    suspend fun getTotalPrice(): Int?

    @Query("SELECT SUM(yemekSiparisAdet) FROM cart_foods")
    suspend fun getTotalQuantity(): Int?
}