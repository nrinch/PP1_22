package na.severinchik.lesson6.data.remotesource

import na.severinchik.lesson6.data.remotesource.apies.CatsApi
import na.severinchik.lesson6.data.remotesource.apies.DogsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL_CATS = "https://catfact.ninja/"
private const val BASE_URL_DOGS = "https://dog.ceo/api/"

object RetrofitClient {
    private val interceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private fun getInstanceCatClient() = Retrofit.Builder()
        .baseUrl(BASE_URL_CATS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun getInstanceDogClient() = Retrofit.Builder()
        .baseUrl(BASE_URL_DOGS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val catApi: CatsApi
        get() = getInstanceCatClient().create(CatsApi::class.java)

    val dogApi: DogsApi
        get() = getInstanceDogClient().create(DogsApi::class.java)
}