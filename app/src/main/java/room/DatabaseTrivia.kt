package room
//ketzalli
//base de datos para las preguntas
//no implementado
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [SexualEducation::class],
    version = 1
)

abstract class DatabaseTrivia : RoomDatabase() {
    abstract fun TriviaDAO(): TriviaDAO

    companion object {
        private var INSTANCE: DatabaseTrivia? = null

        fun getInstance(context: Context): DatabaseTrivia {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseTrivia::class.java, "database-name"
                ).build()
            }
            return INSTANCE!!
        }
    }
}