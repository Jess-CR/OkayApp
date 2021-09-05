package com.example.proyectobedufase3_prueba1.room
//ketzalli
//version de prueba de base de datos
//no implementada
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [SexualEducation::class],
    version = 1
)

abstract class DatabaseTrivia : RoomDatabase() {

    companion object {
        private var dbInstance: DatabaseTrivia? = null

        const val DB_NAME = "Database_Trivia"

        fun getInstance(context: Context): DatabaseTrivia {
            if (dbInstance == null) {
                synchronized(DatabaseTrivia::class) {
                    dbInstance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseTrivia::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }
    }
    abstract fun triviaDao():TriviaDAO
}