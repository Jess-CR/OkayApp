package room

import androidx.lifecycle.LiveData

class TriviaRepository (private val triviaDao: TriviaDao){

    val readAllData:LiveData<List<Trivia>> = triviaDao.readAllData()

    /*suspend fun addItem(trivia: org.bedu.okayapp.Trivia){
        triviaDao.addUser(trivia)
    }*/
    suspend fun updateItem(trivia: Trivia){
        triviaDao.updateItem(trivia)
    }
    fun getCategories():LiveData<List<SubTable>>{
        return triviaDao.getCategories()
    }

    fun getSubCat(category:String):LiveData<List<String>>{
        return triviaDao.getSubCat(category)
    }

    fun getProgress(category: String): LiveData<Int> {
        return triviaDao.getProgres(category)
    }
    fun getTotalProgress(): LiveData<Int> {
        return triviaDao.getTotalProgres()
    }
    fun getSubTable(cat:String):LiveData<List<SubTable>>{
        return triviaDao.getSubTable(cat)
    }


}