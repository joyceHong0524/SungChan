package com.junga.sungchan

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_completed.view.*


class CompletedFragment() : Fragment() {

    private var type = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //어차피 이 fragment가 쓰이는 경우는 chef,customer 각각 한 번씩 이므로 이렇게 구분하도록 한다.
        type = context.getSharedPreferences("user", 0).getInt("type", 0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_completed, container, false)

        when (type) {
            0 -> {
                view.title.setText(R.string.completed_costomer)
                view.content.setText(R.string.completed_info_costomer)
            }
            1 -> {
                view.title.setText(R.string.completed_chef)
                view.content.setText(R.string.completed_info_chef)
                Handler().postDelayed(Runnable {
                    fragmentManager?.beginTransaction()?.replace(R.id.container, ChefListFragment())?.commit()
                }, 2000)
            }
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}