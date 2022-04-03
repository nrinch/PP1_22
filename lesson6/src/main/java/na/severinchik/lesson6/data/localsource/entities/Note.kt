package na.severinchik.lesson6.data.localsource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "body")val body:String,
    @ColumnInfo(name = "date") val date:Long
){
    @PrimaryKey(autoGenerate = true)
    var uid:Int = 0
}


/// uid:Int | title:String | body:String | date:Long
///     1     Notification        smth          2.04.2022
