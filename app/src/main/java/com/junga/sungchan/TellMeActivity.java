package com.junga.sungchan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TellMeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_me);

        SharedPreferences pref = getSharedPreferences("user",MODE_PRIVATE);
        int type = pref.getInt("type",0);

        Button pass_btn = findViewById(R.id.pass_btn);
        Button keep_btn = findViewById(R.id.keep_btn);
        TextView textView = findViewById(R.id.main_textview);

        if( type==ChoiceActivity.Companion.getCUSTOMER()){
            textView.setText(R.string.tellme_customer);
            pass_btn.setOnClickListener(this);
            keep_btn.setOnClickListener(this);

        }else if ( type ==ChoiceActivity.Companion.getCHEF()){
            textView.setText(R.string.tellme_chef);
            keep_btn.setOnClickListener(this);
            pass_btn.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.pass_btn) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (view.getId() == R.id.keep_btn) {
            Intent intent = new Intent(this, FoodChoiceActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }
}
