package com.junga.sungchan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "SignUpActivity";

    EditText nickName_edt, email_edt, password_edt, phoneNumber_edit;

    Button signUp_btn;


    //TODO This shared preference will be just used for MVP product, it should be modified in the future.
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        pref = getSharedPreferences("user",MODE_PRIVATE);

        nickName_edt = findViewById(R.id.nickname_edt);
        email_edt = findViewById(R.id.email_edt);
        password_edt = findViewById(R.id.password_edt);
        phoneNumber_edit = findViewById(R.id.phoneNum_edt);

        signUp_btn = findViewById(R.id.signUp_btn);
        signUp_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUp_btn) {
            signUp();
        }
    }

    private void signUp(){
        //TODO Maybe It would be easier just using firebase authentication..?]

        String nickName = nickName_edt.getText().toString();
        String email = email_edt.getText().toString();
        String password = password_edt.getText().toString();
        String phoneNumber = phoneNumber_edit.getText().toString();

        editor = pref.edit();

        editor.putString("nickname",nickName);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.putString("phonenumber",phoneNumber);

        editor.commit();

        Log.d(TAG, "signUp: User " +nickName+" has been signed up");

        Intent intent = new Intent(SignUpActivity.this, ChoiceActivity.class);
        startActivity(intent);

    }
}
