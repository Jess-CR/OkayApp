package org.bedu.okayapp.Trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import org.bedu.okayapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //aqui se mete el codigo
        val view: View = inflater.inflate(R.layout.fragment_question, container, false)
        val view_pager2 = view.findViewById<ViewPager2>(R.id.view_pager2)
        val siguiente = view.findViewById<Button>(R.id.siguiente)

        view_pager2.adapter = activity?.let { viewpagerAdapter(generateDataSE(), it) }
        view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        val indicator=findViewById<CircleIndicator3>(R.id.indicator)
//        indicator.setViewPager(view_pager2)

        siguiente.setOnClickListener {
            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }
        //arriba codigoooo
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuestionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuestionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    //listaaaa
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