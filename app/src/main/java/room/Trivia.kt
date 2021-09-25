package room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName= "questions")
data class Trivia(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
     val triviaQuestion: String?,
    val image: String?,//cambiarlo por imagenes
    val option1: String?,
    val option2: String?,
    val option3: String?,
    val correctAnswer: Int?,
    val userAnswer: Int?,
)