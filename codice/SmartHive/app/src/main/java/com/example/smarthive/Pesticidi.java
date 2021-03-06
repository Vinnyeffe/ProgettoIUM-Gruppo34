package com.example.smarthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class Pesticidi extends AppCompatActivity {
    private Account accountAttivo;
    private String codiceArnia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesticidi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i=getIntent();
        accountAttivo = (Account) i.getSerializableExtra("account");
        codiceArnia=i.getStringExtra("codice");
    }

    public void impostazioniCliccato(MenuItem item){
        Intent i = new Intent(this,Impostazioni.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i=new Intent(getApplicationContext(),Parametri.class);
                i.putExtra("account", accountAttivo);
                i.putExtra("codice",codiceArnia);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
        }
        return true;
    }

    public void homeCliccato(MenuItem item){
        Intent i = new Intent(this, HomePage.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP );
        startActivity(i);
    }
}