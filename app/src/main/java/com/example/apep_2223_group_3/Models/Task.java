package com.example.apep_2223_group_3.Models;

import android.content.Context;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
import com.example.apep_2223_group_3.Database.CleaningBuddyDatabase;

@Entity(foreignKeys = {
        @ForeignKey(
            entity = RoomEntity.class,
            parentColumns = "id",
            childColumns = "roomId",
            onDelete = ForeignKey.SET_NULL),
        @ForeignKey(
                entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = ForeignKey.SET_NULL)
})
public class Task {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;
    private String description;
    private int interval;
    private Integer userId;
    private Integer roomId;

    private String roomName;
    private String userName;


    public Task(String name, String description, int interval) {
        this.name = name;
        this.interval = interval;
        this.description = description;
    }

    public Task(String name, String description, int interval, int user) {
        this.name = name;
        this.interval = interval;
        this.description = description;
    }
    public Task(String name, String description, int interval, int user, int room) {
        this.name = name;
        this.interval = interval;
        this.description = description;
        this.userId = user;
        this.roomId = room;
    }

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Task() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Newtask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", interval=" + interval +
                ", gebruiker='" + userId + '\'' +
                ", kamer='" + roomId + '\'' +
                '}';
    }

    public static void add(Task task, Context context) {
        CleaningBuddyDatabase.getDatabase(context).taskDao().insert(task);
    }

    public static Task getItemById(Context context, int id) {
        Task item;
        item = CleaningBuddyDatabase.getDatabase(context).taskDao().getbyId(id);
        if (item.getUserId() != null) {
            User userItem = CleaningBuddyDatabase.getDatabase(context).userDao().getUserById(item.getUserId());
            item.setUserName(userItem.getUserName());
        }
        if (item.getRoomId() != null) {
            RoomEntity roomItem = CleaningBuddyDatabase.getDatabase(context).roomDAO().getById(item.getRoomId());
            item.setRoomName(roomItem.getName());
        }

        return item;
    }


    public static List<Task> getAll(Context context) {
        return CleaningBuddyDatabase.getDatabase(context).taskDao().getAll();
    }

    public static List<Task> getAllForUser(Context context, Integer userId) {
        return CleaningBuddyDatabase.getDatabase(context).taskDao().getAllForUser(userId);
    }
}

