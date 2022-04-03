package na.severinchik.lesson6.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.remotesource.apies.CatsApi
import na.severinchik.lesson6.data.remotesource.responses.CatsResponse

class CatsRepository(private val api: CatsApi) {
    suspend fun fetchFact(): CatsResponse = withContext(Dispatchers.IO) {
        api.fetchFact()
    }
}
