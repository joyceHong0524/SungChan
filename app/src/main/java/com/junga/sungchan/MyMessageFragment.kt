package com.junga.sungchan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_chef_list.*

class MyMessageFragment : Fragment() {


    private lateinit var mFragmentManager: FragmentManager
    private lateinit var pref: SharedPreferences
    var type: Int = 0
    val thisFragment = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = layoutInflater.inflate(R.layout.fragment_my_message, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MessageListAdapter(context!!, mFragmentManager, type, thisFragment)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mFragmentManager = fragmentManager!!
        pref = context.getSharedPreferences("user", 0)
        type = pref.getInt("type", -1)
    }


}