package org.bedu.okayapp.Temas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.bedu.okayapp.R
import org.bedu.okayapp.databinding.ActivityCategoriesBinding
import org.bedu.okayapp.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val imageid = intent.getIntExtra("imageid", R.drawable.locked_item)

            binding.nameProfile.setText(name)
            binding.profileImage.setImageResource(imageid)

        }


       /* val icono = intArrayOf(
            R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a
        )
        val seccions = arrayOf(
            "Salud sexual y reproductiva",
            "Finanzas",
            "Vida laboral",
            "Medio ambiente"
        )

        val userArrayList: ArrayList<Seccion> = ArrayList()
        for (i in icono.indices) {
            val seccion = Seccion(
                seccions[i],icono [i]
            )
            userArrayList.add(seccion)
        }
        val listAdapterSeccion = ListAdapterSeccion(this, userArrayList)
        binding.listviewSeccion.setAdapter(listAdapterSeccion)
        binding.listviewSeccion.setClickable(true)*/
        /* binding.listviewSeccion.setOnItemClickListener { parent, view, position, id ->
             val i = Intent(this, UserActivity::class.java)
             i.putExtra("name", name[position])
             i.putExtra("imageid", imageId[position])
             startActivity(i)*/
    }
}
