package com.junga.sungchan

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_taste_choice.*
import org.jetbrains.anko.startActivity

class TasteChoiceActivity : AppCompatActivity(), View.OnClickListener {


    //TasteChoiceActivity working flow

    // 1. 각 4개의 맛 영역 중에 하나씩 선택한다.
    //      - 꼭 4 영역 모두 다 선택해야 한다.
    //      - 한 영역에는 하나만 체크가 가능하다.

    // 2. 계속하기 버튼을 누른다.
    //      - SharedPreferences "user" 폴더에 favtastes key에 StringSet으로 저장된다.


    // Methods Explanation
    // taste box click -> check_box.visiblity changes to Visible.
    // All the boxes can be toggled.


    private val TAG = this::class.java.simpleName

    private lateinit var pref: SharedPreferences;
    private lateinit var editor: SharedPreferences.Editor;
    private var tasteList = arrayOf("", "", "", "")
    var type: Int = 0

    override fun onClick(p0: View) {

        when (p0.id) {
            R.id.keep_btn -> {
                for (a in tasteList) {
                    if (a.isEmpty()) {
                        Snackbar.make(layout_parent, "4개 영역 모두 선택해 주세요", Snackbar.LENGTH_SHORT).show();
                        return
                    }
                }

                editor = pref.edit()

                var set = HashSet<String>()
                set.addAll(tasteList)

                editor.putStringSet("favtastes", set)
                editor.commit()

                //For check
                for (a in set) {
                    Log.d(TAG, a)
                }

                when (type) {
                    0 -> {
                        startActivity<LoadingActivity>()
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    }
                    1 -> {
                        startActivity<KitchenRegislation>()
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                    }
                }

            }
            R.id.spicy_0, R.id.spicy_1, R.id.spicy_2, R.id.check_spicy0,
            R.id.check_spicy1, R.id.check_spicy2,
            R.id.salty_0, R.id.salty_1, R.id.salty_2, R.id.oily_0, R.id.oily_1,
            R.id.oily_2, R.id.vegi_0, R.id.vegi_1, R.id.vegi_2,
            R.id.check_salty0, R.id.check_salty1, R.id.check_salty2,
            R.id.check_oily0, R.id.check_oily1, R.id.check_oily2,
            R.id.check_vegi0, R.id.check_vegi1, R.id.check_vegi2 -> checkIfFilled(p0)
        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taste_choice)

        pref = getSharedPreferences("user", Context.MODE_PRIVATE)
        type = pref.getInt("type", 0)

        when (type) {
            0 -> textView9.setText(R.string.whichtaste_customer)
            1 -> textView9.setText(R.string.whichtaste_chef)
        }



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
        check_spicy0.setOnClickListener(this)
        check_spicy1.setOnClickListener(this)
        check_spicy2.setOnClickListener(this)
        check_salty0.setOnClickListener(this)
        check_salty1.setOnClickListener(this)
        check_salty2.setOnClickListener(this)
        check_oily0.setOnClickListener(this)
        check_oily1.setOnClickListener(this)
        check_oily2.setOnClickListener(this)
        check_vegi0.setOnClickListener(this)
        check_vegi1.setOnClickListener(this)
        check_vegi2.setOnClickListener(this)
    }


    //This function check if it is clicked before or not.
    fun checkIfFilled(view: View) {

        when (view.id) {

            R.id.spicy_0, R.id.spicy_1, R.id.spicy_2 -> {

                if (tasteList[0].isEmpty()) {
                    when (view.id) {
                        R.id.spicy_0 -> {
                            check_spicy0.visibility = View.VISIBLE
                            tasteList[0] = convertIdToString(R.id.spicy_0)
                        }
                        R.id.spicy_1 -> {
                            check_spicy1.visibility = View.VISIBLE
                            tasteList[0] = convertIdToString(R.id.spicy_1)
                        }
                        R.id.spicy_2 -> {
                            check_spicy2.visibility = View.VISIBLE
                            tasteList[0] = convertIdToString(R.id.spicy_2)
                        }
                    }
                } else {
                    Snackbar.make(layout_parent, "영역별 하나만 선택 가능합니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
            R.id.salty_0, R.id.salty_1, R.id.salty_2 -> {
                if (tasteList[1].isEmpty()) {
                    when (view.id) {
                        R.id.salty_0 -> {
                            check_salty0.visibility = View.VISIBLE
                            tasteList[1] = convertIdToString(R.id.salty_0)
                        }
                        R.id.salty_1 -> {
                            check_salty1.visibility = View.VISIBLE
                            tasteList[1] = convertIdToString(R.id.salty_1)
                        }
                        R.id.salty_2 -> {
                            check_salty2.visibility = View.VISIBLE
                            tasteList[1] = convertIdToString(R.id.salty_2)
                        }
                    }
                } else {
                    Snackbar.make(layout_parent, "영역별 하나만 선택 가능합니다.", Snackbar.LENGTH_SHORT).show()
                }

            }
            R.id.oily_0, R.id.oily_1, R.id.oily_2 -> {
                if (tasteList[2].isEmpty()) {
                    when (view.id) {
                        R.id.oily_0 -> {
                            check_oily0.visibility = View.VISIBLE
                            tasteList[2] = convertIdToString(R.id.oily_0)
                        }
                        R.id.oily_1 -> {
                            check_oily1.visibility = View.VISIBLE
                            tasteList[2] = convertIdToString(R.id.oily_1)
                        }
                        R.id.oily_2 -> {
                            check_oily2.visibility = View.VISIBLE
                            tasteList[2] = convertIdToString(R.id.oily_2)
                        }
                    }
                } else {
                    Snackbar.make(layout_parent, "영역별 하나만 선택 가능합니다.", Snackbar.LENGTH_SHORT).show()
                }

            }
            R.id.vegi_0, R.id.vegi_1, R.id.vegi_2 -> {
                if (tasteList[3].isEmpty()) {
                    when (view.id) {
                        R.id.vegi_0 -> {
                            check_vegi0.visibility = View.VISIBLE
                            tasteList[3] = convertIdToString(R.id.vegi_0)
                        }
                        R.id.vegi_1 -> {
                            check_vegi1.visibility = View.VISIBLE
                            tasteList[3] = convertIdToString(R.id.vegi_1)
                        }
                        R.id.vegi_2 -> {
                            check_vegi2.visibility = View.VISIBLE
                            tasteList[3] = convertIdToString(R.id.vegi_2)
                        }
                    }
                } else {
                    Snackbar.make(layout_parent, "영역별 하나만 선택 가능합니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
            R.id.check_spicy0, R.id.check_spicy1, R.id.check_spicy2 -> {
                when (view.id) {
                    R.id.check_spicy0 -> {
                        tasteList[0] = ""
                        check_spicy0.visibility = View.INVISIBLE
                    }
                    R.id.check_spicy1 -> {
                        tasteList[0] = ""
                        check_spicy1.visibility = View.INVISIBLE
                    }
                    R.id.check_spicy2 -> {
                        tasteList[0] = ""
                        check_spicy2.visibility = View.INVISIBLE
                    }
                }
            }
            R.id.check_salty0, R.id.check_salty1, R.id.check_salty2 -> {
                when (view.id) {
                    R.id.check_salty0 -> {
                        tasteList[1] = ""
                        check_salty0.visibility = View.INVISIBLE
                    }
                    R.id.check_salty1 -> {
                        tasteList[1] = ""
                        check_salty1.visibility = View.INVISIBLE
                    }
                    R.id.check_salty2 -> {
                        tasteList[1] = ""
                        check_salty2.visibility = View.INVISIBLE
                    }
                }
            }
            R.id.check_oily0, R.id.check_oily1, R.id.check_oily2 -> {
                when (view.id) {
                    R.id.check_oily0 -> {
                        tasteList[2] = ""
                        check_oily0.visibility = View.INVISIBLE
                    }
                    R.id.check_oily1 -> {
                        tasteList[2] = ""
                        check_oily1.visibility = View.INVISIBLE
                    }
                    R.id.check_oily2 -> {
                        tasteList[2] = ""
                        check_oily2.visibility = View.INVISIBLE
                    }
                }
            }
            R.id.check_vegi0, R.id.check_vegi1, R.id.check_vegi2 -> {
                when (view.id) {
                    R.id.check_vegi0 -> {
                        tasteList[3] = ""
                        check_vegi0.visibility = View.INVISIBLE
                    }
                    R.id.check_vegi1 -> {
                        tasteList[3] = ""
                        check_vegi1.visibility = View.INVISIBLE
                    }
                    R.id.check_vegi2 -> {
                        tasteList[3] = ""
                        check_vegi2.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }


    fun convertIdToString(id: Int): String {
        when (id) {
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
}