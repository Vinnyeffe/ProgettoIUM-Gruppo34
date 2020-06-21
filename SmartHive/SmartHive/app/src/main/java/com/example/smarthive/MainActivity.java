package com.example.smarthive;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static Account account;
    private TextInputEditText email;
    private TextInputEditText password;
    private LinearLayout linearLayout;
    private TextView errortextView;
    private LinearLayout.LayoutParams layoutParams;
    private TextInputLayout textInputLayoutEmail, textInputLayoutPassword;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        linearLayout=findViewById(R.id.linearLayout);
        textInputLayoutEmail=findViewById(R.id.tInputEmail);
        textInputLayoutPassword=findViewById(R.id.tInputPassword);
        errortextView=new TextView(getApplicationContext());
        errortextView.setTextSize(18);
        layoutParams=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.CENTER;
        //errortextView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.error));
        errortextView.setTypeface(null, Typeface.BOLD);
        errortextView.setPadding(50,20,50,20);
        errortextView.setTextColor(getColor(R.color.colorRed));
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
        textInputLayoutEmail.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edittext));
        textInputLayoutPassword.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edittext));

        if (emailText.equals("")){
            textInputLayoutEmail.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edittext_error));
            errortextView.setText(R.string.empty_email);
            linearLayout.addView(errortextView,2,layoutParams);
            return;
        }
        if (passwordText.equals("")){
            textInputLayoutPassword.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.edittext_error));
            errortextView.setText(R.string.empty_password);
            linearLayout.addView(errortextView,2,layoutParams);
            return;
        }
        Account accountLog=new Account(/*"fabrizio.barra@smarthive.it","fabrizio"*/ emailText,passwordText);

        if (!accountLog.equals(account)){
            errortextView.setText(R.string.invalid_emailPassword);
            linearLayout.addView(errortextView,2,layoutParams);
            return;
        }

        Intent i=new Intent();
        i.setClass(this,HomePage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public static Account getAccount() {
        return account;
    }


}
