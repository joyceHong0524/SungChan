package com.junga.sungchan

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragemtn_chef_info.*
import kotlinx.android.synthetic.main.fragemtn_chef_info.view.*


@SuppressLint("ValidFragment")
class ChefInfoFragment(val position: Int) : Fragment() {

    interface BadgeChangeListener {
        fun badgeChange()
    }


    var badgeChangeListener: BadgeChangeListener? = null
    val chefList = ChefListAdapter.Companion.cheflist

    var mContext: Context? = null
    var mFragmentManager: FragmentManager? = null
    var pref: SharedPreferences? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        request_btn.setOnClickListener(View.OnClickListener {
            val dialog = AlertDialog.Builder(mContext)
            dialog.setMessage("고용 신청 메시지를 보내시겠습니까?")
                    .setCancelable(false)
                    .setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->
                        mFragmentManager!!.beginTransaction().replace(R.id.container, CompletedFragment()).commit()
                        badgeChangeListener!!.badgeChange()
                        //This position represents which index has data.
                        pref!!.edit().putInt("send_request_position", position).apply()


                        dialogInterface.cancel()
                    })
                    .setNegativeButton("취소", DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })

            val alert = dialog.create()
            alert.show()

        })

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragemtn_chef_info, container, false);

        val data = chefList.get(position)

        val name = data.chefName + "님"
        view.chefName.setText(name)
        view.rate.setText(data.rate.toString())
        val distance = data.distance.toString() + "m"
        view.distance.setText(distance)
        view.numOfReview.setText(data.numOfReview)
        view.onePrice.setText(data.onePrice)
        view.multiplePrice.setText(data.multiplePrice)
        view.introduction.setText(data.introduction)
        view.menu.setText(data.availableMenu)

        view.attr1.setText(data.attr1)
        view.attr2.setText(data.attr2)
        view.attr3.setText(data.attr3)

        when (position % 5) {
            0 -> Glide.with(mContext!!).load(R.drawable.gaejang_list).into(view.image)
            1 -> Glide.with(mContext!!).load(R.drawable.samgetang_list).into(view.image)
            2 -> Glide.with(mContext!!).load(R.drawable.healthy_list).into(view.image)
            3 -> Glide.with(mContext!!).load(R.drawable.baby_list).into(view.image)
            4 -> Glide.with(mContext!!).load(R.drawable.cheese_list).into(view.image)
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mFragmentManager = fragmentManager
        pref = context.getSharedPreferences("user", 0)

        if (context is BadgeChangeListener) {
            badgeChangeListener = context
        }


    }
}