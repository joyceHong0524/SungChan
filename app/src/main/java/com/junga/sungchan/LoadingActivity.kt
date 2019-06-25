package com.junga.sungchan

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.acitivity_loding.*
import org.jetbrains.anko.startActivity


class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_loding)


        val ref: SharedPreferences = getSharedPreferences("user", 0)
        val type = ref.getInt("type", 0);

        when (type) {
            0 -> loading_text.setText(R.string.registlation_in_process_customer)
            1 -> loading_text.setText(R.string.registlation_in_process_chef)
        }


        Glide.with(this).load(R.drawable.loading_spinner).into(gif)
        Handler().postDelayed(Runnable {
            when (type) {
                0 -> {
                    startActivity<MainActivity>()
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }
                1 -> {
                    startActivity<MainActivity>("from" to 100)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                } //To show completed Fragment
            }
            finish()
        }, 1500)
    }
}