package com.junga.sungchan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_food_choice.*
import org.jetbrains.anko.startActivity

class FoodChoiceActivity : AppCompatActivity(), View.OnClickListener {

    // <Food Choice Acitivity working process>


    // 1. 원하는 요리 선택 3개
    //    - 최소 한 개, 최대 세 개까지 선택할 수 잇음
    //    - 누르면 체크 이미지가 토글이 됨.

    // 2. 계속하기 버튼
    //    - 버튼을 누르게 되면 다음으로 갈 수 있음.
    //    - 최소 하나는 선택해야 갈 수 있음.

    private val TAG = this::class.java.simpleName

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    //favfoods
    //favtastes

    var counter = 0
    var foodList = ArrayList<String>()

    //This Boolean variables is for toggle.
    var koreanB: Boolean = false
    var bansangB: Boolean = false
    var italianB: Boolean = false
    var chineseB: Boolean = false
    var japaneseB: Boolean = false
    var bunsikB: Boolean = false
    var snackB: Boolean = false
    var healthyB: Boolean = false
    var babyB: Boolean = false

    override fun onClick(view: View) {

        when (view.id) {
            R.id.keep_btn -> {

                if(checkMinimusToast(counter)) return

                for (element in foodList) {
                    Log.d(TAG, "Clicked food list $element counter : $counter")
                }
                editor = pref.edit()

                val set = HashSet<String>()

                set.addAll(foodList)
//                for (a in set){
//                    Log.d(TAG,"It is in the set -----> $a");
//                }
                editor.putStringSet("favfoods", set)
                editor.apply()

                startActivity<TasteChoiceActivity>()
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)


            }
            R.id.koreanT -> {
                toggleBox(view)
            }
            R.id.italianT -> {
                toggleBox(view)
            }
            R.id.chineseT -> {
                toggleBox(view)
            }
            R.id.japaneseT -> {
                toggleBox(view)
            }
            R.id.bunsikT -> {
                toggleBox(view)
            }
            R.id.snackT -> {
                toggleBox(view)
            }
            R.id.healthyT -> {
                toggleBox(view)
            }
            R.id.babyT -> {
                toggleBox(view)
            }
            R.id.bansangT -> {
                toggleBox(view)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_choice)

        pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        val type = pref.getInt("type",-1)

        when (type){
            0 -> textView9.setText(R.string.whichfood_customer)
            1 -> textView9.setText(R.string.whichfood_cherf)
        }

        keep_btn.setOnClickListener(this)

        koreanT.setOnClickListener(this)
        italianT.setOnClickListener(this)
        chineseT.setOnClickListener(this)
        japaneseT.setOnClickListener(this)
        bunsikT.setOnClickListener(this)
        snackT.setOnClickListener(this)
        healthyT.setOnClickListener(this)
        babyT.setOnClickListener(this)
        bansangT.setOnClickListener(this)

    }


    fun toggleBox(view: View) {

        when (view.id) {

            R.id.koreanT -> {
                korean.visibility = if (!koreanB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("korean")
                    Log.d(TAG, "Korean food has been added")
                    koreanB = true
                    View.VISIBLE
                } else {

                    Log.d(TAG, "Korean food has been deleted")
                    koreanB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.italianT -> {
                italian.visibility = if (!italianB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("italian")
                    Log.d(TAG, "italian food has been added")
                    italianB = true
                    View.VISIBLE
                } else {
                    foodList.remove("italian")
                    Log.d(TAG, "italian food has been deleted")
                    italianB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.chineseT -> {
                chinese.visibility = if (!chineseB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("chinese")
                    chineseB = true
                    Log.d(TAG, "chinese food has been added")
                    View.VISIBLE
                } else {
                    foodList.remove("chinese")
                    Log.d(TAG, "chinese food has been deleted")
                    chineseB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.japaneseT -> {
                japanese.visibility = if (!japaneseB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("japanese")
                    Log.d(TAG, "japnese food has been added")
                    japaneseB = true
                    View.VISIBLE
                } else {
                    foodList.remove("japanese")
                    Log.d(TAG, "japanese food has been deleted")
                    japaneseB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.bunsikT -> {
                bunsik.visibility = if (!bunsikB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("bunsik")
                    Log.d(TAG, "bunsik food has been added")
                    bunsikB = true
                    View.VISIBLE
                } else {
                    foodList.remove("bunsik")
                    Log.d(TAG, "bunsik food has been deleted")
                    counter--
                    chineseB = false
                    View.INVISIBLE
                }
            }

            R.id.snackT -> {
                snack.visibility = if (!snackB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("snack")
                    Log.d(TAG, "snack food has been added")
                    snackB = true
                    View.VISIBLE
                } else {
                    foodList.remove("snack")
                    Log.d(TAG, "snack food has been deleted")
                    snackB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.healthyT -> {
                healthy.visibility = if (!healthyB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("healthy")
                    Log.d(TAG, "healthy food has been added")
                    healthyB = true
                    View.VISIBLE
                } else {
                    foodList.remove("healthy")
                    Log.d(TAG, "healthy food has been deleted")
                    healthyB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.babyT -> {
                baby.visibility = if (!babyB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("baby")
                    Log.d(TAG, "baby food has been added")
                    babyB = true
                    View.VISIBLE
                } else {
                    foodList.remove("baby")
                    Log.d(TAG, "baby food has been deleted")
                    babyB = false
                    counter--
                    View.INVISIBLE
                }
            }

            R.id.bansangT -> {
                bansang.visibility = if (!bansangB) { //if koreanB가 false였다면, checkbox를 보이게끔 바꿔라
                    if (checkMaximumToast(counter)) {
                        return;
                    }
                    counter++
                    foodList.add("bansang")
                    Log.d(TAG, "bansang food has been added")
                    bansangB = true
                    View.VISIBLE
                } else {
                    foodList.remove("bansang")
                    Log.d(TAG, "bansang food has been deleted")
                    bansangB = false
                    counter--
                    View.INVISIBLE
                }
            }
        }
    }

    //Check if already 3 boxes were checked, if so, Show error toast to user.
    fun checkMaximumToast(counter: Int): Boolean {
        if (counter >= 3) {
            Snackbar.make(layout_parent, "최대 3개 까지만 선택 가능합니다.", Snackbar.LENGTH_SHORT).show()
//            Toast.makeText(this, "최대 3개 까지만 선택하실 수 있습니다.", Toast.LENGTH_SHORT).show()
            return true
        } else {
            return false
        }
    }

    fun checkMinimusToast(counter: Int): Boolean {
        if (counter <= 0){
            Snackbar.make(layout_parent,"적어도 하나는 선택 해야합니다.",Snackbar.LENGTH_SHORT).show()
            return true
        }
        else return false
    }
}
