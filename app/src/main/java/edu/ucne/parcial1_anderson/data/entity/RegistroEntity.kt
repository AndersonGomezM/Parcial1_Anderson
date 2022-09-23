package edu.ucne.parcial1_anderson.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Registros")
class RegistroEntity (
    @PrimaryKey(autoGenerate = true)
    val registroId: Int = 0,
    val variable1: String,
    val variable2: String,
    val num: Double
)