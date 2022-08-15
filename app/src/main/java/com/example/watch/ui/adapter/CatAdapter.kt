package com.example.watch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.watch.R
import com.example.watch.ui.model.DataModelCat
import kotlinx.android.synthetic.main.item_cat.view.*

class CatAdapter(val listText: ArrayList<DataModelCat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return ViewHolderCat(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderCat).getCat(listText[position])
    }

    override fun getItemCount(): Int {
        return listText.size
    }

    inner class ViewHolderCat(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun getCat(item: DataModelCat) {
            itemView.text_cat.text = item.text
        }
    }
}