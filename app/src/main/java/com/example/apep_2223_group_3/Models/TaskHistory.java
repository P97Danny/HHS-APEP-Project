package com.example.apep_2223_group_3.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.apep_2223_group_3.Utils.Converters;

import java.util.Date;

@Entity(tableName = "TaskHistory", foreignKeys = {
    @ForeignKey(
        entity = Task.class,
        parentColumns = "id",
        childColumns = "taskId",
        onDelete = ForeignKey.SET_NULL)
})
public class TaskHistory {
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private Integer taskId;
    private Integer userId;

    @TypeConverters({Converters.class})
    private String dateChecked;

    public TaskHistory() {
    }

    public TaskHistory(Integer taskId, String dateChecked, Integer userId) {
        this.taskId = taskId;
        this.userId = userId;
        this.dateChecked = dateChecked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDateChecked() {
        return dateChecked;
    }

    public void setDateChecked(String dateChecked) {
        this.dateChecked = dateChecked;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
