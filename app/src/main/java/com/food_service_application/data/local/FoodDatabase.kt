package com.food_service_application.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.food_service_application.data.model.FavoriteFood
import com.food_service_application.data.model.CartFood


@Database(
    entities = [FavoriteFood::class, CartFood::class],
    version = 1,
    exportSchema = false
)
abstract class FoodDatabase : RoomDatabase() {

    abstract fun favoriteFoodDao(): FavoriteFoodDao
    abstract fun cartFoodDao(): CartFoodDao

    companion object {
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "food_delivery_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}