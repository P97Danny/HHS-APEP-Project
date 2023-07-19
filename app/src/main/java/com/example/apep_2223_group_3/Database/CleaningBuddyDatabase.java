package com.example.apep_2223_group_3.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.apep_2223_group_3.Daos.RoomDAO;
import com.example.apep_2223_group_3.Daos.TaskHistoryDao;
import com.example.apep_2223_group_3.Daos.TaskDao;
import com.example.apep_2223_group_3.Daos.UserDao;
import com.example.apep_2223_group_3.Models.Task;
import com.example.apep_2223_group_3.Models.TaskHistory;

import com.example.apep_2223_group_3.Models.User;
import com.example.apep_2223_group_3.Models.RoomEntity;

@Database(entities = {User.class, RoomEntity.class, Task.class, TaskHistory.class}, version = 9, exportSchema = false)
public abstract class CleaningBuddyDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract RoomDAO roomDAO();
    public abstract TaskDao taskDao();
    public abstract TaskHistoryDao taskHistoryDao();

    public static CleaningBuddyDatabase getDatabase(Context context) {
        CleaningBuddyDatabase database;
        synchronized (CleaningBuddyDatabase.class) {
            database = Room.databaseBuilder(
                        context, CleaningBuddyDatabase.class, "cleaning_buddy"
                    ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
}
