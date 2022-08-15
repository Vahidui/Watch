package com.example.watch.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.load
import com.example.watch.R
import com.example.watch.dto.post_model.Post_Model
import com.example.watch.ui.model.DataModelWatch
import kotlinx.android.synthetic.main.fragment_watch.*

class WatchFragment:Fragment(R.layout.fragment_watch) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image21.load(listWatch?.cover)
        text_Data.text = listWatch?.createdAt
        text_titel.text = listWatch?.title
        text_about.text = listWatch?.body
        text_price.text = listWatch?.title
    }
    companion object{
        var listWatch:Post_Model? = null
        fun getWatchFragment(item:Post_Model):WatchFragment{
            listWatch = item
            return WatchFragment()
        }
    }
}