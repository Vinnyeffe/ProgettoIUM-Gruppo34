package com.example.smarthive;

import androidx.annotation.Nullable;

public class Account {
    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
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

    @Override
    public boolean equals(@Nullable Object obj) {
        return ((Account) obj).getEmail().equals(this.email) && ((Account) obj).getPassword().equals(this.password);
    }
}
