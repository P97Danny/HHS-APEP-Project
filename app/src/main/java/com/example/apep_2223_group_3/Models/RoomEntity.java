package com.example.apep_2223_group_3.Models;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.apep_2223_group_3.Database.CleaningBuddyDatabase;

import java.util.Collection;
import java.util.List;

@Entity
public class RoomEntity {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;

    public RoomEntity(String name) {
        this.name = name;
    }

    public RoomEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void add(RoomEntity newRoomEntity, Context context) {
        CleaningBuddyDatabase.getDatabase(context).roomDAO().insert(newRoomEntity);
    }

    public static List<RoomEntity> getAll(Context context) {
        return CleaningBuddyDatabase.getDatabase(context).roomDAO().getAll();
    }
}