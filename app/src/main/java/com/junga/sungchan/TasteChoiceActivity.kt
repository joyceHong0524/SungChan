package com.junga.sungchan

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_taste_choice.*

class TasteChoiceActivity: AppCompatActivity() , View.OnClickListener{


    //TasteChoiceActivity working flow

    // 1. 각 4개의 맛 영역 중에 하나씩 선택한다.
    //      - 꼭 4 영역 모두 다 선택해야 한다.
    //      - 한 영역에는 하나만 체크가 가능하다.

    // 2. 계속하기 버튼을 누른다.
    //      - SharedPreferences "user" 폴더에 favtastes key에 StringSet으로 저장된다.


    // Methods Explanation
    // taste box click -> check_box.visiblity changes to Visible.
    // All the boxes can be toggled.


    private lateinit var  pref : SharedPreferences;
    private lateinit var  editor: SharedPreferences.Editor;
    private var tasteList = arrayOf("","","","")

    override fun onClick(p0: View) {

        when(p0.id){
            R.id.keep_btn->{

            }

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taste_choice)

        keep_btn.setOnClickListener(this)

        spicy_0.setOnClickListener(this)
        spicy_1.setOnClickListener(this)
        spicy_2.setOnClickListener(this)
        salty_0.setOnClickListener(this)
        salty_1.setOnClickListener(this)
        salty_2.setOnClickListener(this)
        oily_0.setOnClickListener(this)
        oily_1.setOnClickListener(this)
        oily_2.setOnClickListener(this)
        vegi_0.setOnClickListener(this)
        vegi_1.setOnClickListener(this)
        vegi_2.setOnClickListener(this)

    }



    fun convertIdToString( id : Int) :String {
        when(id){
            R.id.spicy_0 -> return "spicy_0"
            R.id.spicy_1 -> return "spicy_1"
            R.id.spicy_2 -> return "spicy_2"
            R.id.salty_0 -> return "salty_0"
            R.id.salty_1 -> return "salty_1"
            R.id.salty_2 -> return "salty_2"
            R.id.oily_0 -> return "oliy_0"
            R.id.oily_1 -> return "oliy_1"
            R.id.oily_2 -> return "oliy_2"
            R.id.vegi_0 -> return "vegi_0"
            R.id.vegi_1 -> return "vegi_1"
            R.id.vegi_2 -> return "vegi_2"
        }
        return "NO_MATCH"
    }

    //This function check if it is clicked before or not.
    fun checkIfFilled(view : View){

    }





    }