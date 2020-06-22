package com.example.smarthive;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Parametri extends AppCompatActivity {

    ImageButton binIcon;
    TextView text_arnia;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametri);

        //popup rimozione arnia
        binIcon = (ImageButton) findViewById(R.id.bin_hive);

        binIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        text_arnia=findViewById(R.id.text_arnia);
        Intent i=getIntent();
        text_arnia.setText("Arnia "+i.getStringExtra("codice"));
    }

    public void openDialog(){

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

    public void climaCliccato(View v){
        Intent i = new Intent(getApplicationContext(), CondizioniClimatiche.class);
        startActivity(i);
    }

    public void temperaturaCliccato(View v){

    }

    public void saluteCliccato(View v){
        Intent i = new Intent(getApplicationContext(), StatoSalute.class);
        startActivity(i);
    }

    public void risorseCliccato(View v){

    }

    public void sciamaturaCliccato(View v){
        Intent i = new Intent(getApplicationContext(), Sciamatura.class);
        startActivity(i);
    }

    public void pesticidiCliccato(View v){
        Intent i = new Intent(getApplicationContext(), Pesticidi.class);
        startActivity(i);
    }
}
