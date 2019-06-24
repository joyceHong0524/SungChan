package com.junga.sungchan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTx= fragmentManager.beginTransaction()
        fragmentTx.replace(R.id.container, ChefListFragment())
        fragmentTx.commit();
    }
}
