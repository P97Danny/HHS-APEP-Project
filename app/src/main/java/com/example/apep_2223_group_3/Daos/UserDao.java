package com.example.apep_2223_group_3.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.apep_2223_group_3.Models.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOneUser(User user);

    @Insert
    void insert(User user);

    @Insert
    void insertAll(User... users);

    @Query("SELECT * FROM user WHERE user_name = :userName")
    User getOneUser(String userName);

    @Query("SELECT * FROM user WHERE id = :id")
    User getUserById(int id);

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Query("DELETE FROM user")
    void deleteAll();
}
