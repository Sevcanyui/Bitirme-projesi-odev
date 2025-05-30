package com.food_service_application.data.remote

import com.food_service_application.data.model.CartResponse
import com.food_service_application.data.model.CrudResponse
import com.food_service_application.data.model.FoodsResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodApiService {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getAllFoods(): Response<FoodsResponse>

    @FormUrlEncoded
    @POST("yemekler/sepeteYemekEkle.php")
    suspend fun addToCart(
        @Field("yemek_adi") yemek_adi: String,
        @Field("yemek_resim_adi") yemek_resim_adi: String,
        @Field("yemek_fiyat") yemek_fiyat: Int,
        @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
        @Field("kullanici_adi") kullanici_adi: String = "tamer_akdeniz"
    ): Response<CrudResponse>

    @FormUrlEncoded
    @POST("yemekler/sepettekiYemekleriGetir.php")
    suspend fun getCartFoods(
        @Field("kullanici_adi") kullanici_adi: String = "tamer_akdeniz"
    ): Response<CartResponse>

    @FormUrlEncoded
    @POST("yemekler/sepettenYemekSil.php")
    suspend fun removeFromCart(
        @Field("sepet_yemek_id") sepet_yemek_id: Int,
        @Field("kullanici_adi") kullanici_adi: String = "tamer_akdeniz"
    ): Response<CrudResponse>
}