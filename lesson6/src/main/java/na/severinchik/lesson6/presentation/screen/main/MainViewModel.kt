package na.severinchik.lesson6.presentation.screen.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.lesson6.data.localsource.AppDatabase
import na.severinchik.lesson6.data.localsource.entities.Note
import na.severinchik.lesson6.data.repositories.NotesRepository
import java.util.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database: AppDatabase = AppDatabase.getInstance(application.applicationContext)
    private val repository: NotesRepository = NotesRepository(database)

    private val mState: MutableSharedFlow<List<Note>> = MutableSharedFlow()
    val state: SharedFlow<List<Note>> = mState

    fun update() {
        viewModelScope.launch {
            repository.fetchAll().collect {
                mState.emit(it)
            }
        }
    }

    fun insert() {
        viewModelScope.launch {
            val note: Note = Note(
                title = "Buy",
                body = "Milk,meat",
                date = Calendar.getInstance().time.time
            )
            repository.insert(note)
        }
    }

}