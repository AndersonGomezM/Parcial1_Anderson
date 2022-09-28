package edu.ucne.parcial1_anderson.data

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.parcial1_anderson.data.dao.ArticuloDao
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity

@Database(
    version = 2,
    entities = [ArticuloEntity::class],
    exportSchema = false
)
abstract class ArticuloDb : RoomDatabase() {
    abstract val articuloDao: ArticuloDao
}