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

    @Query("SELECT DISTINCT category from questions")
    fun getCategories():LiveData<List<String>>

    @Query("SELECT DISTINCT subcat from questions WHERE category  LIKE:cat")
      fun getSubCat(cat:String):LiveData<List<String>>

    @Query("SELECT 100*AVG(ok) from questions WHERE category LIKE:cat")
     fun getProgres(cat:String):LiveData<Int>

    @Query("SELECT 100*AVG(ok) from questions")
    fun getTotalProgres():LiveData<Int>

}