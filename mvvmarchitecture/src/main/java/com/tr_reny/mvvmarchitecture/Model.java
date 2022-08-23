package com.tr_reny.mvvmarchitecture;


import androidx.annotation.Nullable;
/**Created by Reny K. on 23rd 2022.
 * this is a model class that holds the email and password entered by user */
public class Model {
    @Nullable
    String name,password;

    public Model(@Nullable String name, @Nullable String password) {
        this.name = name;
        this.password = password;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getPassword() {
        return password;
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
