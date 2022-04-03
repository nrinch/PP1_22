package na.severinchik.lesson6.data.remotesource.apies

import na.severinchik.lesson6.data.remotesource.responses.CatsResponse
import retrofit2.http.GET

interface CatsApi {
    @GET("fact")
    suspend fun fetchFact():CatsResponse
}