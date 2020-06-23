package com.example.smarthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ToggleButton;

public class Impostazioni extends AppCompatActivity {
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impostazioni);
        findViewById(R.id.tastoImpostazioni).setBackgroundColor(getResources().getColor(R.color.light_gray));
        findViewById(R.id.tastoImpostazioni).setEnabled(false);
    }

    public void esciCliccato(View v){
        Intent i = new Intent(this,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
        startActivity(i);
    }


    public void impostazioniCliccato(MenuItem item){
        Intent i = new Intent(this,Impostazioni.class);
        startActivity(i);
    }


    public void homeCliccato(MenuItem item){
        Intent i = new Intent(this, HomePage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(i);
    }
}