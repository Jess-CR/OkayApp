package org.bedu.okayapp
//ketzalli
//agrega contenido al recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import org.bedu.okayapp.databinding.ActivityBaseQuestionBinding
import room.TriviaViewModel


class BaseQuestion : AppCompatActivity() {
    private lateinit var mTriviaViewModel: TriviaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBaseQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter =  TriviaAdapter()
        val recycler = binding.recyclerView
        recycler.adapter =adapter
        recycler.layoutManager = LinearLayoutManager(this)


        mTriviaViewModel = ViewModelProvider(this).get(TriviaViewModel::class.java)
        mTriviaViewModel.readAllData.observe(this, Observer { trivia->
            adapter.setData(trivia)
        })

    }
}