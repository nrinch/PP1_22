package na.severinchik.lesson6.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import na.severinchik.lesson6.data.localsource.AppDatabase
import na.severinchik.lesson6.data.localsource.entities.Note

class NotesRepository(private val database: AppDatabase) {
    private val noteDao by lazy {
        database.notesDao
    }

    suspend fun fetchAll(): Flow<List<Note>> = withContext(Dispatchers.IO) {
        noteDao.fetchAll()
    }

    suspend fun insert(note: Note) = withContext(Dispatchers.IO) {
        noteDao.insert(note)
    }
}