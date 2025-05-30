package com.food_service_application.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food_service_application.data.model.FavoriteFood
import com.food_service_application.data.repository.FoodRepository
import com.food_service_application.utils.Resource
import com.food_service_application.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {

    val favoriteFoods: LiveData<List<FavoriteFood>> = repository.getAllFavorites()

    private val _addToCartResult = SingleLiveEvent<Resource<String>>()
    val addToCartResult: LiveData<Resource<String>> = _addToCartResult

    fun removeFromFavorites(favoriteFood: FavoriteFood) {
        viewModelScope.launch {
            repository.removeFromFavorites(favoriteFood.yemekId)
        }
    }

    fun addToCart(favoriteFood: FavoriteFood) {
        viewModelScope.launch {
            val food = favoriteFood.toFood()
            val result = repository.addToCartFromList(food)
            _addToCartResult.value = result
        }
    }
}