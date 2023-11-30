package com.example.greengardenapp.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.greengardenapp.database.dao.DaoUser;
import com.example.greengardenapp.models.UserModel;

@Database(
        entities = {UserModel.class},
        version = 1
)
public abstract class DataBase extends RoomDatabase {
    public abstract DaoUser daoUser();
}
