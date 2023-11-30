package com.example.greengardenapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.greengardenapp.models.Estadistica;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


import java.util.ArrayList;
import java.util.List;


public class EstadisticasActivity extends AppCompatActivity {
    Estadistica objManipulaDatosG=new Estadistica();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        TextView txtFooter = findViewById(R.id.footerText);
        LineChart lineChart = findViewById(R.id.lineChart);
        crearGraficoCosumoAgua(lineChart);

        txtFooter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar LoginActivity
                Intent login = new Intent(EstadisticasActivity.this, PrincipalActivity.class);
                startActivity(login);
            }
        });

    }
    private void crearGraficoCosumoAgua(LineChart lineChart){
        String[] meses = {"Ene", "Feb", "Mar", "Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};

        List<Entry> listaConsumoAgua= objManipulaDatosG.devolverDatosConsumoAgua(); //devuelve la lista de los datos a graficar
        LineDataSet dataSet = new LineDataSet(listaConsumoAgua, "Consumo de Agua (Litros)"); // Agrega una etiqueta apropiada
        dataSet.setColor(Color.BLUE); // Color de la línea
        dataSet.setValueTextColor(Color.BLACK); // Color del texto de los valores

        // Lista de conjuntos de datos
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);
        LineData lineData = new LineData (dataSets);
        lineChart.setData(lineData);

        // Configuración del eje X con etiquetas personalizadas
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(meses));

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // Opcional: Configurar la posición del eje X
        lineChart.getAxisRight().setEnabled(false); // Opcional: Desactivar el eje derecho
        lineChart.getDescription().setEnabled(false); // Opcional: Desactivar la descripción
        lineChart.animateY(1000); // Opcional: Animación de barras
        // Configurar el eje Y con un formateador personalizado para agregar "L" a los valores
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                return value + " L";
            }
        });
        leftAxis.setDrawGridLines(false);

        lineChart.invalidate(); // Refrescar el gráfico
    }
}
