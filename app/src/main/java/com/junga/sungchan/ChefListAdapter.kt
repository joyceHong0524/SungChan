package com.junga.sungchan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_info.view.*

class ChefListAdapter(val context : Context,val fragmentManager: FragmentManager) : RecyclerView.Adapter<ChefListAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_info,parent,false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardview.setOnClickListener(View.OnClickListener {
            fragmentManager.beginTransaction().replace(R.id.container,ChefInfoFragment()).commit()
        })
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val cardview = view.cardview
    }



}