package com.example.smarthive;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Account {
    private String email;
    private String password;
    private ArrayList<String> arnie;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        this.arnie=new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getArnie() { return arnie; }

    public void setArnie(ArrayList<String> arnie) { this.arnie = arnie; }

    @Override
    public boolean equals(@Nullable Object obj) {
        return ((Account) obj).getEmail().equals(this.email) && ((Account) obj).getPassword().equals(this.password);
    }
}
