package com.junga.sungchan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import org.jetbrains.anko.startActivity

class MaPageFragment : Fragment() {


    lateinit var mContext: Context
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_mypage, container, false)

        view.reset_btn.setOnClickListener {
            editor = pref.edit()
            editor.clear()
            editor.commit()

            mContext.startActivity<SplashActivity>()
        }


        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
        pref = context.getSharedPreferences("user", 0)
    }
}