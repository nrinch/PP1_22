package na.severinchik.lesson5.presentation.screen.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson5.App
import na.severinchik.lesson5.data.entities.User

class UsersListViewModel(application: Application) : AndroidViewModel(application) {

    private val interactor = getApplication<App>().userInteractor

    private val mState: MutableStateFlow<List<User>> = MutableStateFlow(listOf())
    val state: StateFlow<List<User>> = mState


    fun getAllData() {
        viewModelScope.launch {
            mState.emit(interactor.getAll())
        }
    }

    fun getById(id: Int) {
        viewModelScope.launch {
            mState.emit(interactor.getById(id))
        }
    }

    fun add(user: User) {
        viewModelScope.launch {
            interactor.add(user)
        }
        getAllData()
    }
}