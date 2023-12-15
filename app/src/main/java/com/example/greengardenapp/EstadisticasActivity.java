package com.example.greengardenapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.room.Room;

import com.example.greengardenapp.database.DataBase;
import com.example.greengardenapp.models.FertilizerModel;
import com.example.greengardenapp.models.WaterModel;
import com.github.mikephil.charting.charts.BarChart;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;
import java.util.List;


public class EstadisticasActivity extends AppCompatActivity {

    CardView cardWater,cardFertilizer;
    BarChart graphWater;
    LineChart graphFertilizer;
    ImageButton btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        TextView txtFooter = findViewById(R.id.footerText);
        cardWater = findViewById(R.id.card_view_e1);
        graphWater = findViewById(R.id.chartWater);
        btnReturn = findViewById(R.id.LogoBack);

        //variables para el gráfico de consumo de abono
        cardFertilizer=findViewById(R.id.card_view_e2);
        graphFertilizer=findViewById(R.id.chartFertilizer);

        DataBase database = Room.databaseBuilder(
                getApplicationContext(),
                DataBase.class,
                "GreenGarden"
        ).allowMainThreadQueries().build();

        List<WaterModel> listDataWater = database.daoWater().getWater();

        graphWater(listDataWater);

        cardWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent water = new Intent(EstadisticasActivity.this, CategoryAguaActivity.class);
                startActivity(water);
            }
        });


        List<FertilizerModel> listDataFertilizer = database.daoFertilizer().getFertilizer();

        graphFertilizer(listDataFertilizer);

        cardFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fertilizer = new Intent(EstadisticasActivity.this, CategoryAbonoActivity.class);
                startActivity(fertilizer);
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(EstadisticasActivity.this, PrincipalActivity.class);
                startActivity(login);
            }
        });

    }



    private void graphWater(List<WaterModel> list){
        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        System.out.println(list.size()+"Hola Hola");
        for (int i = 0; i < list.size(); i++) {
            entries.add(
                    new BarEntry(
                            Float.parseFloat(String.valueOf(calculateValue(list.get(i).getWater(), list.get(i).getConsume()))),
                            i
                    ));

            labels.add(
                    list.get(i).getMonth()
            );

        }

        BarDataSet bardataset = new BarDataSet(entries, "Cells");


        BarData data = new BarData(labels, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        graphWater.setData(data);

        //setting graph
        //set format of values axis Y to $2
        YAxis yAxis = graphWater.getAxisLeft();
        yAxis.setValueFormatter((value, yAxis1) -> "$"+value);
        YAxis yAxisRight = graphWater.getAxisRight();
        yAxisRight.setEnabled(false);
        graphWater.setDescription("");
        graphWater.getLegend().setEnabled(false);

    }

    private Integer calculateValue(int water, int consume){
        int result = water*consume;
        return result;
    }

    private void graphFertilizer(List<FertilizerModel> listDataFertilizer) {
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        System.out.println(listDataFertilizer.size()+"Hola Hola");
        for (int i = 0; i < listDataFertilizer.size(); i++) {
            entries.add(
                    new Entry(
                            Float.parseFloat(String.valueOf(listDataFertilizer.get(i).getAmountFertilizer())),
                            i
                    ));

            labels.add(
                    listDataFertilizer.get(i).getMonth()
            );
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "Cells");

        LineData data = new LineData(labels, lineDataSet);
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        graphFertilizer.setData(data);

// Configurar el gráfico
        YAxis yAxis = graphFertilizer.getAxisLeft();
        yAxis.setValueFormatter((value, yAxis1) -> "$" + value);
        YAxis yAxisRight = graphFertilizer.getAxisRight();
        yAxisRight.setEnabled(false);
        graphFertilizer.setDescription("");
        graphFertilizer.getLegend().setEnabled(false);
    }

}
