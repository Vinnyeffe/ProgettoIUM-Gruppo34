package com.example.smarthive;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputFilter;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HomePage extends AppCompatActivity {
    private LinearLayout containerListaArnie;
    private Account accountAttivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findViewById(R.id.tastoHome).setBackgroundColor(getResources().getColor(R.color.light_gray));
        findViewById(R.id.tastoHome).setEnabled(false);
        containerListaArnie = findViewById(R.id.containerListaArnie);
        Intent intent = getIntent();
        if(intent != null ){
            accountAttivo= (Account)intent.getSerializableExtra("account");
            for(String s: accountAttivo.getArnie()){
                creaArnia(s);
            }
        }
    }

    public void aggiungiArniaCliccato(View v){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePage.this);
        alertDialog.setTitle("Aggiungi Arnia");
        alertDialog.setMessage("Inserisci il codice dell'arnia:");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setFilters(new InputFilter[] { new InputFilter.LengthFilter(9) });
        alertDialog.setView(input);
        alertDialog.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String s = input.getText().toString();
                if(s==null || s.equals("")){
                    return;
                }
                creaArnia(s);
                accountAttivo.getArnie().add(s);
                SharedPreferences spUtenti = getSharedPreferences(getResources().getString(R.string.file_arnie), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = spUtenti.edit();
                Set<String> set = new HashSet<String>();
                set.addAll(accountAttivo.getArnie());
                editor.putStringSet(accountAttivo.getEmail(),set);
                editor.commit();
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


    void creaArnia(String nomeArnia){
        LinearLayout ll = new LinearLayout(this);
        getLayoutInflater().inflate(R.layout.list_element,ll);
        Button buttonArnia = ll.findViewById(R.id.buttonArnia);
        buttonArnia.setText("Arnia "+nomeArnia);
        buttonArnia.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Parametri.class);
                startActivity(i);
            }
        });
        ll.setTag(nomeArnia);
        containerListaArnie.addView(ll);
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