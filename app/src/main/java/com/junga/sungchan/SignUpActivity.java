package com.junga.sungchan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {


    EditText nickName_edt, email_edt, password_edt, phoneNumber_edit;

    Button signUp_btn;


    //TODO This shared preference will be just used for MVP product, it should be modified in the future.
    SharedPreferences pref = getSharedPreferences("user",MODE_PRIVATE);
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nickName_edt = findViewById(R.id.nickname_edt);
        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);
        phoneNumber_edit = findViewById(R.id.phoneNum_edt);

        signUp_btn = findViewById(R.id.signUp_btn);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUp_btn) {
            signUp();
            Intent intent = new Intent(SignUpActivity.this, ChoiceActivity.class);

        }
    }


    private void signUp(){
        //TODO Maybe It would be easier just using firebase authentication..?


    }
}
