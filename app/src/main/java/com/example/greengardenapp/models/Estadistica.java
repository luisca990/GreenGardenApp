package com.example.greengardenapp.models;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

public class Estadistica {

    public List<Entry> devolverDatosConsumoAgua(){
        List<Entry> listaConsumoAgua = new ArrayList<>();
        listaConsumoAgua.add(new Entry(0, 10));
        listaConsumoAgua.add(new Entry(1, 20));
        listaConsumoAgua.add(new Entry(2, 30));
        listaConsumoAgua.add(new Entry(3, 25));
        listaConsumoAgua.add(new Entry(4, 25));
        listaConsumoAgua.add(new Entry(5, 25));
        listaConsumoAgua.add(new Entry(6, 10));
        listaConsumoAgua.add(new Entry(7, 20));
        listaConsumoAgua.add(new Entry(8, 30));
        listaConsumoAgua.add(new Entry(9, 25));
        listaConsumoAgua.add(new Entry(10, 25));
        listaConsumoAgua.add(new Entry(11, 25));
        return listaConsumoAgua;
    }

}
