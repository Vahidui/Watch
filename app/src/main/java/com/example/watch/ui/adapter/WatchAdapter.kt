package com.example.watch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.EventListener
import coil.load
import com.example.watch.R
import com.example.watch.dto.post_model.Post_Model
import com.example.watch.ui.lis.InterfaceWatch
import com.example.watch.ui.model.DataModelWatch
import kotlinx.android.synthetic.main.item_watch.view.*

class WatchAdapter(private val listWatch: ArrayList<Post_Model>,val listener:InterfaceWatch) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_watch, parent, false)
        return ViewHolderWatch(layout)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolderWatch).getWatch(listWatch[position],listener)
    }

    override fun getItemCount(): Int {
        return listWatch.size
    }

    inner class ViewHolderWatch(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun getWatch(item: Post_Model,listener: InterfaceWatch) {
            itemView.img1.load(item.cover)
            itemView.tv_data.text = item.createdAt
            itemView.tv_price.text = item.title
            itemView.setOnClickListener{
                listener.fragmentWatch(item = item)
            }
        }
    }

}