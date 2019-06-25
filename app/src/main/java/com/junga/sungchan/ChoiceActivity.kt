package com.junga.sungchan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choice.*
import org.jetbrains.anko.startActivity

class ChoiceActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        customer_btn.setOnClickListener(this)
        chef_btn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.customer_btn) {
            editor = pref.edit()
            editor.putInt("type", 0)
            editor.apply()
            startActivity<TellMeActivity>()

        } else if (view.id == R.id.chef_btn) {
            editor = pref.edit()
            editor.putInt("type", 1)
            editor.apply()
            startActivity<TellMeActivity>()


        }
    }

    companion object {

        // For shared preferences "user",
        // type means
        // 0 : Customer
        // 1 : Chef

        val CUSTOMER = 0
        val CHEF = 1
    }
}
