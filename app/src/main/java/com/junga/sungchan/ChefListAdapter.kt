package com.junga.sungchan

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_info.view.*

class ChefListAdapter(val context: Context, val fragmentManager: FragmentManager) : RecyclerView.Adapter<ChefListAdapter.MyViewHolder>() {

    //****** R E A D  M E************
    //This is a dummy data. If you want to make an real app
    //you should pass the ArrayList<ChefData> from MainActivity


    companion object {
        val chefDummy1 = ChefData("박 막례", "여수 손맛", 4.9, 340, "50+개", "잡채, 간장 국수, 7첩 반상", "2시간", "14000원",
                "32000원", "저는 전라도에서 나고 자라 평생을 요리하면서 지냈습니다. 직접 음식을 해드리는 기쁨으로 요즘엔 삽니다.", "간장게장, 간장국수 , 불고기, 잡채, 그외 모든 한식 문의 주세요","한식","정성가득","베테랑")
        val chefDummy2 = ChefData("홍 미례", "천년의 맛", 4.9, 500, "60+개", "사골 곰탕, 삼계탕, 갈비탕 ", "2시간 30분", "30000원",
                "46000원", "기력 보충에는 든든한 보양식 만한 것이 없습니다. 항상 정성을 담아 진심으로 요리합니다.", "사골 곰탕(강추), 삼계탕, 갈비탕, 꼬리 곰탕, 초계탕 그 외 모든 보양식 문의 바랍니다.","원기보충","한식","복날")
        val chefDummy3 = ChefData("김 규리", "웰빙 팜", 4.2, 300, "100+개", "스무디볼, 야채 샐러드, 닭가슴살", "30분", "8000원",
                "20000원", "다들 잘 못 알고 계시는게, 다이어트는 굶어서 빼는 것이 아닙니다. 맛있게 살 빼실 수 있도록 도와드립니다.", "아보카도 스무디볼, 리코타 치즈 샐러드, 닭가슴살 스테이크, 모든 종류 샐러드","다이어트","건강식","샐러드")
        val chefDummy4 = ChefData("박 소영", "베이비 푸드", 4.9, 200, "40+개", "소고기 단호박죽, 두부 버섯찜 ", "2시간", "20000원",
                "32000원", "영양학을 공부했기 때문에 아기의 개월 수에 맞게 맞춤으로 이유식을 만들어 드립니다. 한 번에 3끼용을 보내드립니다.", "치커리 양파죽, 단호박 치즈 피자, 소고기 단호박죽, 두부 버섯찜","3끼해결","유기농","이유식")
        val chefDummy5 = ChefData("김 선아", "사랑의 밥집", 4.3, 200, "10+개", "떡볶이, 소떡소떡, 치즈그라탕", "1시간 30분", "10000원",
                "22000원", "제 주방은 분식을 전문으로 합니다. 어렸을 때 학교앞에서 먹었던 떡볶이 맛을 그대로 재현해 드립니다. 원하시는 분식은 문의 주세요", "뚝배기 치즈 떡볶이, 소떡소떡, 치즈 그라탕, 치즈 토마토 스파게티, 새우 튀김 외 모든 분식 가능합니다.","추억st","분식","JMT")

        var cheflist = arrayListOf<ChefData>(chefDummy1, chefDummy2, chefDummy3, chefDummy4, chefDummy5, chefDummy1, chefDummy2, chefDummy3, chefDummy4, chefDummy5)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_info, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cheflist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.cardview.setOnClickListener(View.OnClickListener {
            fragmentManager.beginTransaction().replace(R.id.container, ChefInfoFragment(position)).commit()
        })

        val data = cheflist.get(position)

        val name = data.chefName + "님"
        val distance = data.distance.toString() + "m"
        val estimatedTime = "예상 고용 시간: " + data.estimatedTime
        val rate = data.rate.toString() + "개"

        holder.chefName.setText(name)
        holder.kitchenName.setText(data.kitchenName)
        holder.distance.setText(distance)
        holder.mainFood.setText(data.mainFood)
        holder.estimatedTime.setText(estimatedTime)
        holder.rate.setText(rate)

        when (position % 5) {
            0 -> Glide.with(context).load(R.drawable.gaejang_list).into(holder.image)
            1 -> Glide.with(context).load(R.drawable.samgetang_list).into(holder.image)
            2 -> Glide.with(context).load(R.drawable.healthy_list).into(holder.image)
            3 -> Glide.with(context).load(R.drawable.baby_list).into(holder.image)
            4 -> Glide.with(context).load(R.drawable.cheese_list).into(holder.image)
        }

    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.image
        val cardview = view.cardview
        val chefName = view.chefName
        val kitchenName = view.text
        val rate = view.rate
        val distance = view.distance
        val mainFood = view.mainFood
        val estimatedTime = view.estimatedTime
    }


}