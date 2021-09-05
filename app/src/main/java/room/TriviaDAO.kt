package com.example.proyectobedufase3_prueba1.room
//ketzalli
//version de prueba de base de datos
//no implementada
import androidx.room.*

@Dao
interface TriviaDAO {
    @Insert
    fun insertSE(sexualEducation: SexualEducation)

    @Update
    fun updateSE(sexualEducation: SexualEducation)

    @Delete
    fun removeSE(sexualEducation: SexualEducation)

    @Query("DELETE FROM SexualEducation WHERE id=:id")
    fun removeSEById(id: Int)
//
//    @Delete
//    fun removeSE(vararg sexualEducation: SexualEducation)

    @Query("SELECT * FROM SexualEducation")
    fun getSE(): List<SexualEducation>

//    @Query("SELECT * FROM SexualEducation WHERE id = :id")
//    fun getSEById(id: Int): SexualEducation
}