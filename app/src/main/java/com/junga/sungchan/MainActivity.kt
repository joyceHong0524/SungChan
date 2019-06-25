package com.junga.sungchan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import it.sephiroth.android.library.bottomnavigation.BadgeProvider
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), BottomNavigation.OnMenuItemSelectionListener, ChefInfoFragment.BadgeChangeListener {


    val fm = supportFragmentManager
    var badgeProvider: BadgeProvider? = null;

    override fun onMenuItemReselect(itemId: Int, position: Int, fromUser: Boolean) {


    }

    override fun onMenuItemSelect(itemId: Int, position: Int, fromUser: Boolean) {
        when (position) {
            0 -> fm.beginTransaction().replace(R.id.container, ChefListFragment()).commit()
            1 -> fm.beginTransaction().replace(R.id.container, HiredFragment()).commit()
            2 -> {
                fm.beginTransaction().replace(R.id.container, MyMessageFragment()).commit()
                badgeProvider?.remove(R.id.message)
            }
            3 -> fm.beginTransaction().replace(R.id.container, MaPageFragment()).commit()
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val type = getSharedPreferences("user", 0).getInt("type", 0)
        when (type) {
            0 -> {
                val fragment = ChefListFragment()
                fm.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
            }
            1 -> {
                if (intent.getIntExtra("from", -1) == 100) { // if that is 100, it is from loadingActivity of Chef.
                    val fragment = CompletedFragment()
                    fm.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.simpleName).commit()
                } else {
                    val fragment = ChefListFragment()
                    fm.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.simpleName).commit()
                }
            }
        }

        //여기서 menuItemSelectionListener를 재 정의해 주는 것이다.
        bottom_navigation.menuItemSelectionListener = this

        badgeProvider = bottom_navigation.badgeProvider!!

    }

    override fun onBackPressed() {
        startActivity<MainActivity>()
//        fm.beginTransaction().replace(R.id.container,ChefListFragment(),ChefListFragment().javaClass.simpleName).commit();
    }

    override fun badgeChange() {
        badgeProvider?.show(R.id.message)
    }

}