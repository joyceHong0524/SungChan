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
    override fun onMenuItemReselect(itemId: Int, position: Int, fromUser: Boolean) {
        Toast.makeText(this,"$itemId and position: $position",Toast.LENGTH_SHORT).show()


    }

    override fun onMenuItemSelect(itemId: Int, position: Int, fromUser: Boolean) {
        Toast.makeText(this,"$itemId and position: $position",Toast.LENGTH_SHORT).show()
        
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.home -> {
                val fragment = ChefListFragment(supportFragmentManager)
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.hire -> {
                Toast.makeText(this, "clicked 2", Toast.LENGTH_SHORT).show()
//                    val fragment = ChapterFragment()
//                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                            .commit()
//                    return@OnNavigationItemSelectedListener true
            }
            R.id.message -> {
                Toast.makeText(this, "clicked 3", Toast.LENGTH_SHORT).show()

//                    val fragment = StoreFragment()
//                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                            .commit()
//                    return@OnNavigationItemSelectedListener true
            }
            R.id.mypage -> {
//                    val fragment = StoreFragment()
//                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                            .commit()
//                    return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = ChefListFragment(supportFragmentManager)
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
        }

        val fragmentManager = supportFragmentManager
        val fragmentTx = fragmentManager.beginTransaction()
        fragmentTx.replace(R.id.container, ChefListFragment(fragmentManager))
        fragmentTx.commit();

        bottom_navigation.menuItemSelectionListener = this
    }

}