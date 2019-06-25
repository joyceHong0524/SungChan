package com.junga.sungchan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragemtn_chef_info.*
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.google.android.material.snackbar.Snackbar


class ChefInfoFragment : Fragment(){

    var mContext: Context? = null
    var mFragmentManager : FragmentManager? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        request_btn.setOnClickListener(View.OnClickListener {
            val dialog = AlertDialog.Builder(mContext)
            dialog.setMessage("고용 신청 메시지를 보내시겠습니까?")
                    .setCancelable(false)
                    .setPositiveButton("확인",DialogInterface.OnClickListener { dialogInterface, i ->
                        mFragmentManager!!.beginTransaction().replace(R.id.container,CompletedFragment()).commit()
                        dialogInterface.cancel()
                    })
                    .setNegativeButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.cancel()
                    })

            val alert = dialog.create()
            alert.show()

        })

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = layoutInflater.inflate(R.layout.fragemtn_chef_info,container,false);
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        mFragmentManager = fragmentManager
    }
}