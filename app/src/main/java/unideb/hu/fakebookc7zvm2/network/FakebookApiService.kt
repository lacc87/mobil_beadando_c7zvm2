package unideb.hu.fakebookc7zvm2.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import kotlinx.coroutines.Deferred
import retrofit2.http.Path


private const val BASE_URL =
    "https://jsonplaceholder.typicode.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface FakebookApiService {
    @GET("users")
    fun getUsers():
            Deferred<List<User>>

    @GET("posts/{id}")
    fun getPosts(@Path("id") id: String?):
            Deferred<List<Post>>
}

object FakebookApi {
    val retrofitService : FakebookApiService by lazy { retrofit.create(FakebookApiService::class.java) }
}