package com.example.smarthive;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Parametri extends AppCompatActivity {

    ImageButton binIcon;
    TextView text_arnia;
    Account accountAttivo;

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
        accountAttivo = (Account) i.getSerializableExtra("account");
    }

    public void openDialog(){
        View view = this.getLayoutInflater().inflate(R.layout.dialog_rimozione_arnia,null);
        Button conferma = view.findViewById(R.id.btn_conferma);
        Button annulla = view.findViewById(R.id.btn_annulla);

        final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(Parametri.this);
        alertDialogBuilder.setView(view);
        final AlertDialog dialog = alertDialogBuilder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        conferma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String codice = getIntent().getStringExtra("codice");
                accountAttivo.getArnie().remove(codice);
                Intent i = new Intent(getApplicationContext(),HomePage.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.putExtra("account",accountAttivo);
                startActivity(i);
            }
        });
        annulla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
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
        Intent i = new Intent(getApplicationContext(), TemperaturaInterna.class);
        startActivity(i);
    }

    public void saluteCliccato(View v){
        Intent i = new Intent(getApplicationContext(), StatoSalute.class);
        startActivity(i);
    }

    public void risorseCliccato(View v){
        Intent i = new Intent(getApplicationContext(), RisorseAlimentari.class);
        startActivity(i);
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
