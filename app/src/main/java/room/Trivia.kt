package room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName= "questions")
data class Trivia(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category:String?,
    val subcat:String?,
    val triviaQuestion: String?,
    val option1: String?,
    val option2: String?,
    val option3: String?,
    val correctAnswer: Int?,
    var userAnswer: Int?,
    var ok:Int?,
    val image: String?
)