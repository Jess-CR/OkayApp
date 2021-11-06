package room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TriviaViewModel(application: Application):AndroidViewModel(application) {

     val readAllData: LiveData<List<Trivia>>
    private val repository:TriviaRepository
    init{
        val triviaDao = TriviaDatabase.getDatabase(application).triviaDao()
        repository = TriviaRepository((triviaDao))
        readAllData = repository.readAllData
    }
    fun updateItem(trivia: Trivia){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateItem(trivia)
        }
    }
    fun getCategories():LiveData<List<String>>{
        return repository.getCategories()
    }

    fun getSubCat(cat:String):LiveData<List<String>>{
            return repository.getSubCat(cat)
        }
     fun getProgress(cat: String): LiveData<Int> {
        return repository.getProgress(cat)
    }
    fun getTotalProgress(): LiveData<Int> {
        return repository.getTotalProgress()
    }

    }

    /*fun addItem(trivia: org.bedu.okayapp.Trivia){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addItem(trivia)
        }
    }*/


