package com.junga.sungchan


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_chef_list.*


class ChefListFragment() : Fragment() {

    private lateinit var adapter: ChefListAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var mContext: Context
    private lateinit var mFragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chef_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recycler_view.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(mContext)
            // set the custom adapter to the RecyclerView
            adapter = ChefListAdapter(context!!, mFragmentManager)
        }

        address.text = "역삼동 624-17"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mFragmentManager = fragmentManager!!
    }


}
