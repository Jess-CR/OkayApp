package room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class TriviaViewModel(application: Application):AndroidViewModel(application) {

     val readAllData: LiveData<List<Trivia>>
    private val repository:TriviaRepository
    init{
        val triviaDao = TriviaDatabase.getDatabase(application).triviaDao()
        repository = TriviaRepository((triviaDao))
        readAllData = repository.readAllData
    }

    /*fun addItem(trivia: org.bedu.okayapp.Trivia){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(trivia)
        }
    }*/


}