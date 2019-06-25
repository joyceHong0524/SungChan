package com.junga.sungchan

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_info.view.*

class MessageListAdapter(val context: Context, val fragmentManager: FragmentManager, val type: Int, val whichFragment: Int) : RecyclerView.Adapter<MessageListAdapter.MyViewHolder>() {


    val list_position = context.getSharedPreferences("user", 0).getInt("send_request_position", 0)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view: View

        if (whichFragment == 1) {
            if (type == 0) {
                view = LayoutInflater.from(context).inflate(R.layout.row_customer_message, parent, false)
                val string = ChefListAdapter.Companion.cheflist.get(list_position).chefName + "님께서 수락하셨습니다."
                view.text.setText(string)
                when (list_position % 5) {
                    0 -> Glide.with(context).load(R.drawable.gaejang_list).into(view.image)
                    1 -> Glide.with(context).load(R.drawable.samgetang_list).into(view.image)
                    2 -> Glide.with(context).load(R.drawable.healthy_list).into(view.image)
                    3 -> Glide.with(context).load(R.drawable.baby_list).into(view.image)
                    4 -> Glide.with(context).load(R.drawable.cheese_list).into(view.image)
                }
            } else if (type == 1) {
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_message, parent, false)
                view.setOnClickListener(View.OnClickListener {
                    val dialog = AlertDialog.Builder(context)
                    dialog.setMessage("고용 신청을 수락 하시겠습니까?")
                            .setCancelable(false)
                            .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
                                fragmentManager!!.beginTransaction().replace(R.id.container, HiredFragment()).commit()
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
        } else if (whichFragment == 0) {
            if (type == 0) {
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire, parent, false)
                val string = ChefListAdapter.Companion.cheflist.get(list_position).chefName + "님과의 약속."
                view.text.setText(string)
                when (list_position % 5) {
                    0 -> Glide.with(context).load(R.drawable.gaejang_list).into(view.image)
                    1 -> Glide.with(context).load(R.drawable.samgetang_list).into(view.image)
                    2 -> Glide.with(context).load(R.drawable.healthy_list).into(view.image)
                    3 -> Glide.with(context).load(R.drawable.baby_list).into(view.image)
                    4 -> Glide.with(context).load(R.drawable.cheese_list).into(view.image)
                }
            } else if (type == 1) {
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire, parent, false)
            } else {
                view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire, parent, false)
            }
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.row_chef_hire, parent, false)
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


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val cardview = view.cardview
    }


}