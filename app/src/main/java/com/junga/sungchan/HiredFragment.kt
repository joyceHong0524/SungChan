package com.junga.sungchan

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_my_message.*
import kotlinx.android.synthetic.main.fragment_my_message.view.*
import kotlinx.android.synthetic.main.fragment_my_message.view.recycler_view

class HiredFragment : Fragment(){

    private var type : Int = 0
    private lateinit var mFragmentManager: FragmentManager
    private val thisFragment = 0;
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.title.setText(R.string.my_hire)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MessageListAdapter(context!!,mFragmentManager,type,thisFragment)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_my_message,container,false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        type = context.getSharedPreferences("user",0).getInt("type",0)
        mFragmentManager = fragmentManager!!

    }
}