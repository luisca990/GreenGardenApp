package com.example.greengardenapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CompostModel {
    @PrimaryKey
    @NonNull
    private String month;
    private int amountCompost;
    private int priceConsume;

    public CompostModel(@NonNull String month, int amountCompost, int priceConsume) {
        this.month = month;
        this.amountCompost = amountCompost;
        this.priceConsume = priceConsume;
    }


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getAmountCompost() {
        return amountCompost;
    }

    public void setAmountCompost(int amountCompost) {
        this.amountCompost = amountCompost;
    }

    public int getPriceConsume() {
        return priceConsume;
    }

    public void setPriceConsume(int priceConsume) {
        this.priceConsume = priceConsume;
    }
}
