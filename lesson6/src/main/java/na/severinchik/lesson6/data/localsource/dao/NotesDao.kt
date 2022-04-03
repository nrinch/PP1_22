package na.severinchik.lesson6.data.localsource.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import na.severinchik.lesson6.data.localsource.entities.Note

@Dao
interface NotesDao {
    @Insert
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM note_table")
    fun fetchAll(): Flow<List<Note>>

    @Query("SELECT * FROM note_table WHERE uid IN(:id)")
    suspend fun fetchById(id: Int): List<Note>

}