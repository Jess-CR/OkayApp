package org.bedu.okayapp.Temas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.bedu.okayapp.R

class ListAdapter(context: Context?, userArrayList: ArrayList<Categorias>) :
    ArrayAdapter<Categorias?>(
        context!!, R.layout.list_item,
        userArrayList!! as List<Categorias?>
    ) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val user = getItem(position)
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }
        val imageView = convertView!!.findViewById<ImageView>(R.id.profile_pic)
        val userName = convertView.findViewById<TextView>(R.id.personName)
        imageView.setImageResource(user!!.imageId)
        userName.text = user.name
        return convertView
    }
}