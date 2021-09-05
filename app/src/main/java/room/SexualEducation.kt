package com.example.proyectobedufase3_prueba1.room
//ketzalli
//version de prueba de base de datos
//no implementada
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SexualEducation(
    @PrimaryKey(autoGenerate = true) val id:Int=0,
    val pregunta:String?,
    //val imagen:String?,//cambiarlo por imagenes
    val opcion1:String?,
    val opcion2:String?,
    val opcion3:String?,
    val respCorrecta: Int,
    val respUser: Int,
)
