package room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface TriviaDao {
   /* @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(trivia:org.bedu.okayapp.Trivia)
*/
    @Query("SELECT * FROM questions ORDER BY id ASC")
     fun readAllData():LiveData<List<Trivia>>
}