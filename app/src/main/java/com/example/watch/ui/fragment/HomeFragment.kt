package com.example.watch.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watch.R
import com.example.watch.dto.post_model.Post_Model
import com.example.watch.netWork.NewsApiObject
import com.example.watch.ui.adapter.CatAdapter
import com.example.watch.ui.adapter.WatchAdapter
import com.example.watch.ui.lis.InterfaceWatch
import com.example.watch.ui.model.DataModelWatch
import com.example.watch.ui.model.DayCat
import com.example.watch.ui.model.DayWatch
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.HttpException
import java.io.IOError

class HomeFragment : Fragment(R.layout.fragment_home), InterfaceWatch {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            progress.visibility = View.VISIBLE
            val response = try {
                NewsApiObject.newsObject.getNewsPost()
            }catch (ioError:IOError){
                progress.visibility = View.GONE
                return@launchWhenCreated

            }catch (http:HttpException){
                progress.visibility = View.GONE
                return@launchWhenCreated
            }
            progress.visibility =View.GONE
            if (response.isSuccessful&&response.body()!=null)
            recWatch(response.body()!!)else
             Toast.makeText(requireActivity(),"Error",Toast.LENGTH_SHORT).show()
        }
        rec()

    }

    private fun rec() {
        rv_cat.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_cat.adapter = CatAdapter(listText = DayCat().listItem)
    }

    private fun recWatch(item:ArrayList<Post_Model>) {
        rv_watch.layoutManager =
            GridLayoutManager(requireActivity(), 2, GridLayoutManager.VERTICAL, false)
        rv_watch.adapter = WatchAdapter(listWatch = item, this)
    }

    override fun fragmentWatch(item: Post_Model) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, WatchFragment.getWatchFragment(item = item))
            .addToBackStack(null).commit()
    }
}