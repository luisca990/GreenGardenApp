package com.example.greengardenapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class UserModel {

    @PrimaryKey
    @NonNull
    private String email;
    private String name;
    private String password;
    private Boolean acceptTerms;
    private Boolean acceptNews;

    public UserModel(@NonNull String email, String name, String password, Boolean acceptTerms, Boolean acceptNews) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.acceptTerms = acceptTerms;
        this.acceptNews = acceptNews;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(Boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public Boolean getAcceptNews() {
        return acceptNews;
    }

    public void setAcceptNews(Boolean acceptNews) {
        this.acceptNews = acceptNews;
    }
}
