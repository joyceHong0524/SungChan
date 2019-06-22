package com.junga.sungchan;

import android.content.Intent;
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

        Intent intent = getIntent();
        final int type = intent.getIntExtra("type",0);

        Button pass_btn = findViewById(R.id.pass_btn);
        Button keep_btn = findViewById(R.id.keep_btn);
        TextView textView = findViewById(R.id.main_textview);

        if( type==ChoiceActivity.Companion.getCHEF$app_debug()){
            textView.setText(R.string.tellme_customer);
        }else if ( type ==ChoiceActivity.Companion.getCUSTOMER$app_debug()){
            textView.setText(R.string.tellme_chef);
        }

        pass_btn.setOnClickListener(this);
        keep_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.pass_btn) {
            //TODO : Go to 1-3-1 page right away.
        } else if (view.getId() == R.id.keep_btn) {
            Intent intent = new Intent(this, FoodChoiceActivity.class);
            startActivity(intent);
        }
    }
}
