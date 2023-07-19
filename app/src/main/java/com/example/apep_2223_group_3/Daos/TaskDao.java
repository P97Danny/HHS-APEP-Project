package com.example.apep_2223_group_3.Daos;
import com.example.apep_2223_group_3.Models.Task;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;




import java.util.List;

@Dao
public interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Task task);

    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

    @Query("select * from Task")
    List<Task> getAll();

    @Query("select * from Task WHERE userId = :userId and userId = null")
    List<Task> getAllForUser(Integer userId);

    @Query("select * from Task where id = :id")
    Task getbyId(int id);
}
