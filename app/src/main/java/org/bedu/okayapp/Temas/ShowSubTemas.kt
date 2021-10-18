package org.bedu.okayapp.Temas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.bedu.okayapp.R
import org.bedu.okayapp.Trivia.Seleccion
import org.bedu.okayapp.databinding.ActivityShowsubtemasBinding

//pendiente: el progreso se obtiene sacando el porcentaje de los subtemas


class ShowSubTemas : AppCompatActivity(),OnSubTemaClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityShowsubtemasBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)


        var subtemaAdapter=SubTemas(generateDataST(),this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 3 )
        binding.recyclerView.adapter = subtemaAdapter
        subtemaAdapter.notifyDataSetChanged()
    }

    private fun generateDataST():ArrayList<SubTemasDC>{
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
    }
    override fun onSubTemaItemClicked(position: Int) {
        val intent = Intent(this, Seleccion::class.java)
        startActivity(intent)
    }
}