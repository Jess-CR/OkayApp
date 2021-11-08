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

    fun getSubCat(category:String):LiveData<List<String>>{
        return triviaDao.getSubCat(category)
    }


}