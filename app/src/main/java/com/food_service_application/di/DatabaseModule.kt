package com.food_service_application.di

import android.content.Context
import androidx.room.Room
import com.food_service_application.data.local.CartFoodDao
import com.food_service_application.data.local.FavoriteFoodDao
import com.food_service_application.data.local.FoodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FoodDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FoodDatabase::class.java,
            "food_delivery_database"
        ).build()
    }

    @Provides
    fun provideFavoriteFoodDao(database: FoodDatabase): FavoriteFoodDao {
        return database.favoriteFoodDao()
    }

    @Provides
    fun provideCartFoodDao(database: FoodDatabase): CartFoodDao {
        return database.cartFoodDao()
    }
}