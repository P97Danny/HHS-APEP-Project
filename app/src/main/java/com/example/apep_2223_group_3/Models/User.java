package com.example.apep_2223_group_3.Models;

import android.content.Context;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.apep_2223_group_3.Database.CleaningBuddyDatabase;


import java.io.Serializable;
import java.util.List;


@Entity(tableName = "user", indices = {@Index(value = {"user_name"}, unique = true)})
public class User implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "user_name")
    public String userName;
    @ColumnInfo(name = "password")
    public String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    // Model queries
    public static User getOneUser(String userName, Context context) {
        return CleaningBuddyDatabase.getDatabase(context).userDao().getOneUser(userName);
    }

    public static void setOneUser(User user, Context context) {
        CleaningBuddyDatabase.getDatabase(context).userDao().insertOneUser(user);
    }


    public static void add(User user, Context context) {
        //dit was met lijst:Newtask.newtask.add(newtask);
        CleaningBuddyDatabase.getDatabase(context).userDao().insert(user);
    }

    public static List<User> getAll(Context context) {
        //database gaat niet goed met arrayList, daarom word het een list. En je haalt hiermee data uit database
        return CleaningBuddyDatabase.getDatabase(context).userDao().getAllUsers();
    }

    @Override
    public String toString() {
        return userName;
    }
}
