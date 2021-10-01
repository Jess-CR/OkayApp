package org.bedu.okayapp.Trivia

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import org.bedu.okayapp.R
import room.TriviaViewModel

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

        val adapter =  viewpagerAdapter(this.requireContext())

        mTriviaViewModel = ViewModelProvider(this).get(TriviaViewModel::class.java)
        mTriviaViewModel.readAllData.observe(viewLifecycleOwner, Observer { trivia->
            adapter.setData(trivia)

        })
        view_pager2.adapter = adapter




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
        lateinit var mTriviaViewModel: TriviaViewModel
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



}