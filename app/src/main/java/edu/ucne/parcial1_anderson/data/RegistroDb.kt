package edu.ucne.parcial1_anderson.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.parcial1_anderson.data.entity.RegistroEntity

@Database(
    version = 1,
    entities = [RegistroEntity::class],
    exportSchema = false
)
abstract class RegistroDb : RoomDatabase() {
    /*abstract val registroDao: String*/

}