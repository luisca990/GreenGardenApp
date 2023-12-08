package com.example.greengardenapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.greengardenapp.models.WaterModel;

import java.util.List;

@Dao
public interface DaoWater {

    @Query("SELECT * FROM watermodel")
    List<WaterModel> getWater();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWater(WaterModel...waterModels);
}
