package com.example.greengardenapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FertilizerModel {

//    @PrimaryKey(autoGenerate = true)
//    private int id;

    @PrimaryKey
    @NonNull
    private String month;
    private int amountFertilizer;
    private int priceConsume;



    public FertilizerModel(@NonNull String month, int amountFertilizer, int priceConsume) {
        this.amountFertilizer = amountFertilizer;
        this.priceConsume = priceConsume;
        this.month = month;
    }

   public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAmountFertilizer() {
        return amountFertilizer;
    }

    public void setAmountFertilizer(int amountFertilizer) {
        this.amountFertilizer = amountFertilizer;
    }

    public int getPriceConsume() {
        return priceConsume;
    }

    public void setPriceConsume(int priceConsume) {
        this.priceConsume = priceConsume;
    }
}