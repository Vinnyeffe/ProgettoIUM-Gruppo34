package com.example.smarthive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    private LinearLayout containerListaArnie;
    private Button aggiungiArniaButton;
    private int numArnie = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findViewById(R.id.tastoHome).setBackgroundColor(getResources().getColor(R.color.light_gray));
        findViewById(R.id.tastoHome).setEnabled(false);
        containerListaArnie = findViewById(R.id.containerListaArnie);
        aggiungiArniaButton = findViewById(R.id.aggiungiArniaButton);
        aggiungiArniaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePage.this);
                alertDialog.setTitle("Aggiungi Arnia");
                alertDialog.setMessage("Inserisci arnia num."+numArnie);

                alertDialog.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        creaArnia("Arnia "+(numArnie++));
                    }
                });

                alertDialog.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.create().show();
            }
        });
    }


    void creaArnia(String nomeArnia){
        LinearLayout ll = new LinearLayout(this);
        getLayoutInflater().inflate(R.layout.list_element,ll);
        Button buttonArnia = ll.findViewById(R.id.buttonArnia);
        buttonArnia.setText(nomeArnia);
        buttonArnia.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Parametri.class);
                startActivity(i);
            }
        });
        containerListaArnie.addView(ll);
    }


    public void impostazioniCliccato(MenuItem item){
        Intent i = new Intent(this,Impostazioni.class);
        startActivity(i);
    }


}