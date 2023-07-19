package com.example.apep_2223_group_3.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.apep_2223_group_3.Models.TaskHistory;

import java.util.List;


@Dao
public interface TaskHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOne(TaskHistory taksHistory);

    @Query("SELECT * FROM taskhistory WHERE taskId = :taskId")
    List<TaskHistory> getAllTaksHistory(Integer taskId);
}
