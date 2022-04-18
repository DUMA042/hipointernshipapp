package com.example.hhrhr.Data



import com.example.hipointernapp.Domain.UserInfo
import com.example.hipointernapp.Domain.UserInfoInput
import com.example.hipointernapp.Domain.hippointo
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "https://hipolabs.com/api/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface hippoApiService {
    @GET("internship-periods")
    fun getProperties(): Deferred<List<hippointo>>

    @POST("internship-applications")
    fun setapplication(@Body userData: UserInfoInput):Deferred<List<UserInfo>>

}

object hippoApi {
    val retrofitService : hippoApiService by lazy { retrofit.create(hippoApiService::class.java)}
}







