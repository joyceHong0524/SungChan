package com.junga.sungchan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toolbar

class MainActivity : AppCompatActivity() ,BottomNavigation.OnMenuItemSelectionListener {

    val fm = supportFragmentManager

    override fun onMenuItemReselect(itemId: Int, position: Int, fromUser: Boolean) {



    }

    override fun onMenuItemSelect(itemId: Int, position: Int, fromUser: Boolean) {
        when(position){
            0 ->  fm.beginTransaction().replace(R.id.container,ChefListFragment()).commit()
            1 ->  fm.beginTransaction().replace(R.id.container,HiredFragment()).commit()
            2->   fm.beginTransaction().replace(R.id.container,MyMessageFragment()).commit()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val type = getSharedPreferences("user",0).getInt("type",0)
        when(type){
            0 -> {
                val fragment = ChefListFragment()
                fm.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
            }
            1 -> {
                val fragment = CompletedFragment()
                fm.beginTransaction().replace(R.id.container,fragment,fragment.javaClass.simpleName).commit()
            }
        }

        //여기서 menuItemSelectionListener를 재 정의해 주는 것이다.
        bottom_navigation.menuItemSelectionListener = this
    }

}