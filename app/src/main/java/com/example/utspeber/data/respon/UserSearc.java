package com.example.utspeber.data.respon;

import com.example.utspeber.data.respon.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserSearch {
    @SerializedName("items")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }
}