package com.example.smarthive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public Account account;
    private TextInputEditText email;
    private TextInputEditText password;
    private LinearLayout linearLayout;
    private TextView errortextView;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        linearLayout=findViewById(R.id.linearLayout);
        errortextView=new TextView(getApplicationContext());
        errortextView.setTextSize(18);
        layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.CENTER;
        errortextView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.error));
        errortextView.setTypeface(null, Typeface.BOLD);
        errortextView.setPadding(50,20,50,20);
        account=new Account("fabrizio.barra@smarthive.it","fabrizio");
    }

    public void registratiCliccato(View v){
        Intent intent=new Intent(this, Registrazione.class);
        startActivity(intent);
    }

    public void loginCliccato(View v){
        String emailText=email.getText().toString();
        String passwordText=password.getText().toString();

        linearLayout.removeView(errortextView);

        if (emailText.equals("")){
            errortextView.setText(R.string.empty_email);
            linearLayout.addView(errortextView,0,layoutParams);
            return;
        }
        if (passwordText.equals("")){
            errortextView.setText(R.string.empty_password);
            linearLayout.addView(errortextView,0,layoutParams);
            return;
        }
        Account accountLog=new Account(emailText,passwordText);

        if (!accountLog.equals(account)){
            errortextView.setText(R.string.invalid_emailPassword);
            linearLayout.addView(errortextView,0,layoutParams);
            return;
        }


        //Intent i=new Intent();
    }
}
