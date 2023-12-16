package com.example.greengardenapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.greengardenapp.database.dao.DaoCompost;
import com.example.greengardenapp.database.dao.DaoFertilizer;
import com.example.greengardenapp.database.dao.DaoUser;
import com.example.greengardenapp.database.dao.DaoWater;
import com.example.greengardenapp.models.CompostModel;
import com.example.greengardenapp.models.FertilizerModel;
import com.example.greengardenapp.models.UserModel;
import com.example.greengardenapp.models.WaterModel;

@Database(
        entities = {UserModel.class, WaterModel.class, FertilizerModel.class, CompostModel.class},
        version = 4
)
public abstract class DataBase extends RoomDatabase {
    public abstract DaoUser daoUser();

    public abstract DaoWater daoWater();
    public abstract DaoFertilizer daoFertilizer();
    public  abstract DaoCompost daoCompost();
}
