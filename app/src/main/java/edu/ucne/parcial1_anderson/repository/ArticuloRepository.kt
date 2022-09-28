package edu.ucne.parcial1_anderson.repository

import edu.ucne.parcial1_anderson.data.ArticuloDb
import edu.ucne.parcial1_anderson.data.entity.ArticuloEntity
import javax.inject.Inject

class ArticuloRepository @Inject constructor(val db: ArticuloDb){

    suspend fun insertarArticulo(articulo: ArticuloEntity){
        db.articuloDao.insertarArticulo(articulo)
    }

    suspend fun modificarArticulo(articulo: ArticuloEntity){
        db.articuloDao.modificarArticulo(articulo)
    }

    fun getArticulo(ArticuloId: Int) = db.articuloDao.getArticulo(ArticuloId)

    fun getList() = db.articuloDao.getList()
}