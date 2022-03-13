package na.severinchik.lesson5.presentation.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson5.data.source.local.PrefsSource


//------------------------------------------------------------------------------------------
// without params
//------------------------------------------------------------------------------------------
//class MainViewModel : ViewModel() {
//
//    fun todo() = "Hello from View Model"
//}
//------------------------------------------------------------------------------------------

//------------------------------------------------------------------------------------------
//with params
//------------------------------------------------------------------------------------------
//class MainViewModel(private val userName: String) : ViewModel() {
//    fun todo() = "Hello $userName, from View Model"
//}
//
//
//class MainViewModelFactory(private val userName: String) : ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            return MainViewModel(userName) as T
//        }
//        throw IllegalArgumentException("Incorrect providing view model")
//    }
//}
//------------------------------------------------------------------------------------------


//------------------------------------------------------------------------------------------
// activity extension
//------------------------------------------------------------------------------------------
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var counter = 0

    private val prefs = PrefsSource(application.applicationContext)

    fun fetchCounter() = prefs.getCountEntriesInApp()
    fun updateCounter(value: Int) = prefs.updateCountEntriesInApp(value)

    private val mState: MutableStateFlow<String> = MutableStateFlow("Loading...")
    val state: StateFlow<String> = mState

    fun todo() = "Hello from View Model"

    fun fetchData() {
        viewModelScope.launch {
            counter++
            mState.emit("Success $counter")
        }
    }
}


//class MainAndroidViewModel(application: Application) : AndroidViewModel(application) {
//
//    fun todo() =
//        if (getApplication<App>().isAllTextUpperCase) "Hello from View Model".uppercase() else "Hello from View Model"
//}

