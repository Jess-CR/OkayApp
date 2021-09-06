package org.bedu.okayapp
//ketzalli
//agrega contenido al recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import org.bedu.okayapp.databinding.ActivityBaseQuestionBinding


class BaseQuestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityBaseQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TriviaAdapter(generateDataSE(), this)
    }

    private fun generateDataSE(): ArrayList<SexualEducationDC> {
        var listSE = ArrayList<SexualEducationDC>()
        listSE.add(
            SexualEducationDC(
                "¿Cuáles de estos son tus derechos?",
                R.drawable.imgprueba,
                "A vivir libres de discriminación basada en mi sexo, sexualidad o género",
                "A decidir si tener o no hijos y cómo y cuándo tenerlos",
                "Todas las anteriores",
                3,
                0
            )
        )
        listSE.add(
            SexualEducationDC(
                "Tu amiga está viviendo una relación de pareja abusiva… ¿Qué le aconsejas?",
                R.drawable.imgprueba,
                "Que no sea tonta y que termine esa relación",
                "Que trate de arreglar los problemas con su pareja",
                "Que busque ayuda familiar y orientación profesional (ONG’s, grupos de apoyo) para salir de esa relación",
                3,
                0
            )
        )
        listSE.add(
            SexualEducationDC(
                "Deseas tener relaciones sexuales con tu pareja, pero te ha dicho que no. ¿Qué harías?",
                R.drawable.imgprueba,
                "Tratar de convencer por todos los medios a tu pareja para que te acepte. Si te ama lo debería hacer",
                "Respetar su decisión y hablar abiertamente sobre el tema para llegar a un acuerdo con el que ambos estén cómodos",
                "Engañar a mi pareja con otra persona que sí me dé lo que deseo",
                2,
                0
            )
        )
        return listSE
    }
}