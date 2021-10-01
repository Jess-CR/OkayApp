package room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface TriviaDao {
   /* @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(trivia:org.bedu.okayapp.Trivia)
*/
   @Update
   suspend fun updateItem(vararg trivia: Trivia)

    @Query("SELECT * FROM questions ORDER BY id ASC")
     fun readAllData():LiveData<List<Trivia>>
}