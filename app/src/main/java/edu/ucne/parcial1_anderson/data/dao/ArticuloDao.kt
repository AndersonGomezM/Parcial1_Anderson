package edu.ucne.parcial1_anderson.data.dao

import androidx.room.*
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticuloDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarArticulo(articulo: ArticuloEntity)

    @Update
    suspend fun modificarArticulo(articulo: ArticuloEntity)

    @Query("SELECT * " +
            "FROM Articulos " +
            "WHERE articuloId = :id " +
            "LIMIT 1")
    fun getArticulo(id: Int): Flow<ArticuloEntity>


    @Query("SELECT * FROM Articulos")
    fun getList(): Flow<List <ArticuloEntity>>

}