package na.severinchik.lesson6.data.remotesource.apies

import na.severinchik.lesson6.data.remotesource.responses.DogsResponse
import retrofit2.http.GET

interface DogsApi {
    @GET("breeds/image/random")
    suspend fun fetchDogImage(): DogsResponse
}