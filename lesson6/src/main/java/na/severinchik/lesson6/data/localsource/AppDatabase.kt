package na.severinchik.lesson6.data.localsource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import na.severinchik.lesson6.data.localsource.dao.NotesDao
import na.severinchik.lesson6.data.localsource.entities.Note

private const val DATABASE_VERSION = 1
private const val DATABASE_NAME = "app_database"

@Database(entities = [Note::class], version = DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val notesDao: NotesDao

    companion object {
        fun getInstance(context: Context): AppDatabase = Room.databaseBuilder(
            context, AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}