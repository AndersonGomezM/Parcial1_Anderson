package edu.ucne.parcial1_anderson.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Articulos")
class ArticuloEntity (
    @PrimaryKey(autoGenerate = true)
    val articuloId: Int = 0,
    val descripcion: String,
    val marca: String,
    val existencia: Double
)