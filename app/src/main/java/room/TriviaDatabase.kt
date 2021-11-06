package room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Trivia::class],version = 2,exportSchema = false)
abstract class TriviaDatabase: RoomDatabase() {

    abstract fun triviaDao():TriviaDao

    companion object{
        @Volatile
        private var INSTANCE:TriviaDatabase? = null

        fun getDatabase(context: Context):TriviaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TriviaDatabase::class.java,
                    "trivia.db"
                ).createFromAsset("database/trivia.db")
                    //.fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }


}
