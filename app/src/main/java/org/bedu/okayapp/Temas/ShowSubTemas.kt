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

//pendiente: el progreso se obtiene sacando el porcentaje de los subtemas


class ShowSubTemas : AppCompatActivity(),OnSubTemaClickListener {
    var listST=ArrayList<SubTemasDC>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityShowsubtemasBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        val theme =intent.getStringExtra("theme").toString()



        mTriviaViewModel.getSubTable(theme).observe(this, Observer { data ->
            var cats = data.distinctBy { it.subcat }

            cats.forEach { cat ->
                var sum = 0f
                var prom = 0f
                var size = 0f
                data.forEach {data ->
                    if (data.subcat == cat.subcat){
                        size += 1
                        sum += data.ok!!.toFloat()
                    }
                }
                prom = (sum/size)*100f

                listST.add(SubTemasDC(cat.subcat!!,
                    cat.icon!!,
                    prom.toInt()))
            }

            Picasso.get().load(cats.first { it.category==theme}.themeicon).into(binding.ThemeIcon)
            binding.textView4.text = theme
            var subtemaAdapter=SubTemas(listST,this)
            binding.recyclerView.layoutManager = GridLayoutManager(this, 3 )
            binding.recyclerView.adapter = subtemaAdapter
            subtemaAdapter.notifyDataSetChanged()
        })


        }

   /* private fun generateDataST():ArrayList<SubTemasDC>{
        var listST=ArrayList<SubTemasDC>()
        listST.add(
            SubTemasDC("Biologia Reproductiva",R.drawable.temas_1,20)
        )
        listST.add(
            SubTemasDC("ETS",R.drawable.temas_1,50)
        )
        listST.add(
            SubTemasDC("Subtema 3",R.drawable.temas_1,90)
        )
        return listST
    }*/
    override fun onSubTemaItemClicked(position: Int) {
        val intent = Intent(this, Seleccion::class.java)
        intent.putExtra("subcat",listST[position].title)
        startActivity(intent)
    }
}