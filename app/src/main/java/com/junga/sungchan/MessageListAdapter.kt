package com.junga.sungchan

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_info.view.*

class MessageListAdapter(val context : Context, val fragmentManager: FragmentManager,val type : Int, val whichFragment : Int) : RecyclerView.Adapter<MessageListAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view : View

        if(whichFragment==1) {
            if (type == 0) {
                view = LayoutInflater.from(context).inflate(R.layout.row_customer_message, parent, false)
            } else if (type == 1) {
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_message, parent, false)
                view.setOnClickListener(View.OnClickListener {
                    val dialog = AlertDialog.Builder(context)
                    dialog.setMessage("고용 신청을 수락 하시겠습니까?")
                            .setCancelable(false)
                            .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
                                fragmentManager!!.beginTransaction().replace(R.id.container,HiredFragment()).commit()
                                dialogInterface.cancel()
                            })
                            .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->
                                dialogInterface.cancel()
                            })

                    val alert = dialog.create()
                    alert.show()
                })
            } else {
                view = LayoutInflater.from(context).inflate(R.layout.row_customer_message, parent, false)
            }
        }else if(whichFragment==0){
            if(type ==0){
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire,parent,false)
            }else if(type ==1 ){
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire,parent,false)
            }else{
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire,parent,false)
            }
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire,parent,false)
        }
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.cardview.setOnClickListener(View.OnClickListener {
//            fragmentManager.beginTransaction().replace(R.id.container,ChefInfoFragment()).commit()
//        })
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val cardview = view.cardview
    }



}