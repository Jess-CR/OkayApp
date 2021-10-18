package org.bedu.okayapp.Temas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.bedu.okayapp.R

class Temas (private var listaT:ArrayList<TemasDC>,private val onTemaClickListener:OnTemaClickListener): RecyclerView.Adapter<Temas.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_tema, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaT[position])
        holder.itemView.setOnClickListener{
            onTemaClickListener.onTemaItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return listaT.size
    }

    class ViewHolder(private var view: View) :
        RecyclerView.ViewHolder(view) {
        val titleTheme: TextView
        val imageTheme: ImageView
        val progressTheme: ProgressBar

        init {
            titleTheme = view.findViewById(R.id.titleTheme)
            imageTheme = view.findViewById(R.id.imageTheme)
            progressTheme = view.findViewById(R.id.progressTheme)
        }

        fun bind(TemasDC: TemasDC) {
            titleTheme.text = TemasDC.title
            imageTheme.setImageResource(TemasDC.imageId)
            progressTheme.progress = TemasDC.percentage

        }
    }
}
