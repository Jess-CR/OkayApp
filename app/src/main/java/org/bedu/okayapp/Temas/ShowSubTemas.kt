package org.bedu.okayapp.Temas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityShowsubtemasBinding

class ShowSubTemas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityShowsubtemasBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)
        binding.recyclerView.adapter = SubTemas(generateDataST())
    }

    private fun generateDataST():ArrayList<SubTemasDC>{
        var listST=ArrayList<SubTemasDC>()
        listST.add(
            SubTemasDC("Biologia Reproductiva",R.drawable.imgprueba,20)
        )
        listST.add(
            SubTemasDC("Enfermedades de transmision sexual",R.drawable.imgprueba,50)
        )
        listST.add(
            SubTemasDC("Subtema 3",R.drawable.imgprueba,90)
        )
        return listST
    }
}