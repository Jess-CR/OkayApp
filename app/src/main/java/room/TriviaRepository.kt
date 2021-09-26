package room

import androidx.lifecycle.LiveData

class TriviaRepository (private val triviaDao: TriviaDao){

    val readAllData:LiveData<List<Trivia>> = triviaDao.readAllData()

    /*suspend fun addItem(trivia: org.bedu.okayapp.Trivia){
        triviaDao.addUser(trivia)
    }*/

}