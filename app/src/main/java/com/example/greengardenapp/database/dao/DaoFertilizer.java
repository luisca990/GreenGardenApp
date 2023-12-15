package com.example.greengardenapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.greengardenapp.models.FertilizerModel;


import java.util.List;
@Dao
public interface DaoFertilizer {
    @Query("SELECT * FROM fertilizermodel")
   List<FertilizerModel> getFertilizer();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFertilizer(FertilizerModel...fertilizerModels);
}
