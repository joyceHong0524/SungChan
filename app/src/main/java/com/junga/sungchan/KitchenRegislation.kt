package com.junga.sungchan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kitchen_regislation.*
import org.jetbrains.anko.startActivity

class KitchenRegislation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kitchen_regislation)

        registlation_btn.setOnClickListener {
            startActivity<LoadingActivity>()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        }
    }
}
