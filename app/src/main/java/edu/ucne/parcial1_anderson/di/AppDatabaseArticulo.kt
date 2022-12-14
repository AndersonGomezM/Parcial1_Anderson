package edu.ucne.parcial1_anderson.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.parcial1_anderson.data.ArticuloDb
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseArticulo {
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): ArticuloDb {
        return Room.databaseBuilder(
            context,
            ArticuloDb::class.java,
            "Articulo.db"
        ).fallbackToDestructiveMigration().build()
    }
}