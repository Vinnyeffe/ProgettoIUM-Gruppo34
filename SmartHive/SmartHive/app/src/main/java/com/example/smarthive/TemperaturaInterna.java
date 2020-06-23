package com.example.smarthive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.Position;
import com.anychart.enums.TooltipPositionMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class TemperaturaInterna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura_interna);
        System.out.println("oncreate");
        AnyChartView anyChartView = findViewById(R.id.chartView);
        Cartesian cartesian = AnyChart.column();

        List<DataEntry> data = new ArrayList<>();


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String dataString;
        Random rnd = new Random();
        calendar.add(Calendar.DATE,-6);
        for(int i = 0 ; i < 6; i++){
            Date dataSuccessiva = calendar.getTime();
            dataString = dateFormat.format(dataSuccessiva);
            data.add(new ValueDataEntry(dataString,rnd.nextInt(15)+20 ));
            calendar.add(Calendar.DATE, 1 );
        }

        Date dataOggi = calendar.getTime();
        dataString = dateFormat.format(dataOggi);
        data.add(new ValueDataEntry(dataString, 30));



        Column column = cartesian.column(data);

        column.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("${%Value}{groupsSeparator: }");

        cartesian.animation(true);


        cartesian.yScale().minimum(0d);

        cartesian.yAxis(0).labels().format("{%Value}°C");

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
        cartesian.interactivity().hoverMode(HoverMode.BY_X);

        cartesian.xAxis(0).title("Giorni");
        cartesian.yAxis(0).title("Temperatura");

        anyChartView.setChart(cartesian);
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