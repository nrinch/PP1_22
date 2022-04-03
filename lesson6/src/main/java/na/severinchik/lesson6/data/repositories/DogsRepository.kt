package na.severinchik.lesson6.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.remotesource.apies.DogsApi

class DogsRepository(private val api: DogsApi) {
    suspend fun fetchImage() = withContext(Dispatchers.IO) {
        api.fetchDogImage()
    }
}