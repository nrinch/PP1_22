package na.severinchik.lesson6.presentation.screen.dogsandcats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.data.remotesource.RetrofitClient
import na.severinchik.lesson6.data.repositories.CatsRepository
import na.severinchik.lesson6.data.repositories.DogsRepository
import na.severinchik.lesson6.presentation.states.DogAndCatState

class DogAndCatViewModel(application: Application) : AndroidViewModel(application) {
    private val catsApi = RetrofitClient.catApi
    private val catsRepository = CatsRepository(api = catsApi)

    private val dogApi = RetrofitClient.dogApi
    private val dogRepository = DogsRepository(api = dogApi)

    private val mState: MutableSharedFlow<DogAndCatState> = MutableSharedFlow()
    val state: SharedFlow<DogAndCatState> = mState

    fun fetch() {
        viewModelScope.launch {
            val catResponse = catsRepository.fetchFact()
            val dogResponse = dogRepository.fetchImage()
            val state = DogAndCatState(
                factCat = catResponse.value,
                linkDog = dogResponse.link
            )
            mState.emit(state)
        }
    }
}