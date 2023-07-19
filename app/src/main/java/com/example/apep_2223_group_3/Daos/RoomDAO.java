package com.example.apep_2223_group_3.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.apep_2223_group_3.Models.RoomEntity;

import java.util.List;

@Dao
public interface RoomDAO {
    @Insert
    void insert(RoomEntity newRoomEntity);

    @Update
    void update(RoomEntity newRoomEntity);

    @Delete
    void delete(RoomEntity newRoomEntity);

    @Query("select * from RoomEntity")
    List<RoomEntity> getAll();

    @Query("select * from RoomEntity where id =:id")
    RoomEntity getById(int id);
}


