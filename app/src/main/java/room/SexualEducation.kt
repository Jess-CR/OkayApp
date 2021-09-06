package room
//ketzalli
//tabla SexualEducation de la base de datos
//no implementado
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SexualEducation(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val pregunta: String?,
    val imagen: String?,//cambiarlo por imagenes
    val opcion1: String?,
    val opcion2: String?,
    val opcion3: String?,
    val respCorrecta: String?,
    val respUser: String?,
)
