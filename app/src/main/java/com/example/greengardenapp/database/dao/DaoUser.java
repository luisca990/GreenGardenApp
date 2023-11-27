package com.example.greengardenapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.example.greengardenapp.models.UserModel;

import java.util.List;

@Dao
public interface DaoUser {
    @Query("SELECT * FROM usermodel WHERE email= :userEmail AND password= :userPassword")
    UserModel getUser(String userEmail, String userPassword);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insertUser(UserModel...userModels);


}
