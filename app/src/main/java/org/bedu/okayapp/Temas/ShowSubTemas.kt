package org.bedu.okayapp.Temas

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import org.bedu.okayapp.R
import org.bedu.okayapp.Trivia.QuestionFragment
import org.bedu.okayapp.Trivia.QuestionFragment.Companion.mTriviaViewModel
import org.bedu.okayapp.Trivia.Seleccion
import org.bedu.okayapp.databinding.ActivityShowsubtemasBinding
import room.TriviaViewModel
import kotlin.math.floor

//pendiente: el progreso se obtiene sacando el porcentaje de los subtemas


class ShowSubTemas : AppCompatActivity(),OnSubTemaClickListener {
    var listST=ArrayList<SubTemasDC>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityShowsubtemasBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val theme =intent.getStringExtra("theme").toString()
        mTriviaViewModel.getProgress(theme).observe(this, Observer {
                avg->
            binding.progressPogressBar.progress = avg

        })
        binding.textView4.text = theme
        var subtemaAdapter=SubTemas(listST,this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3 )
        binding.recyclerView.adapter = subtemaAdapter
        subtemaAdapter.notifyItemRangeChanged(0,listST.size)



        mTriviaViewModel.getSubTable(theme).observe(this, Observer { data ->
            var cats = data.distinctBy { it.subcat }

            cats.forEach { cat ->
                var sum = 0f
                var prom = 0f
                var size = 0f
                data.forEach {data ->
                    if (data.subcat == cat.subcat){
                        size += 1f
                        sum += data.ok!!.toFloat()
                    }
                }
                prom = (sum/size)*100f
                floor(prom)

                listST.add(SubTemasDC(cat.subcat!!,
                    cat.icon!!,
                    prom.toInt()))
            }
            Picasso.get().load(cats.first { it.category==theme}.themeicon).into(binding.ThemeIcon)

            var subtemaAdapter=SubTemas(listST,this)
            binding.recyclerView.layoutManager = GridLayoutManager(this, 3 )
            binding.recyclerView.adapter = subtemaAdapter
            subtemaAdapter.notifyItemRangeChanged(0,listST.size)
        })
    }

    override fun onSubTemaItemClicked(position: Int) {
        val intent = Intent(this, Seleccion::class.java)
        intent.putExtra("subcat",listST[position].title)
        startActivity(intent)
    }
}