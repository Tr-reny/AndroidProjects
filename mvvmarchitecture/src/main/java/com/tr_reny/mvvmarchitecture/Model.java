package com.tr_reny.mvvmarchitecture;


import androidx.annotation.Nullable;
/**Created by Reny K. on 23rd 2022.
 * this is a model class that holds the email and password entered by user */
public class Model {
    @Nullable
    String email, password;

    public Model(@Nullable String email, @Nullable String password) {
        this.email = email;
        this.password = password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}