package com.example.greengardenapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.greengardenapp.models.CompostModel;


import java.util.List;

@Dao
public interface DaoCompost {
    @Query("SELECT * FROM compostmodel")
    List<CompostModel> getCompost();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCompost(CompostModel...compostModels);
}
