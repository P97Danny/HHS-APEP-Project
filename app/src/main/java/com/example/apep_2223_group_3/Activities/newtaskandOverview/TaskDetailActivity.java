package com.example.apep_2223_group_3.Activities.newtaskandOverview;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apep_2223_group_3.Adapters.TaskHistoryAdapter;
import com.example.apep_2223_group_3.Database.CleaningBuddyDatabase;
import com.example.apep_2223_group_3.Models.RoomEntity;
import com.example.apep_2223_group_3.Models.Task;
import com.example.apep_2223_group_3.Models.TaskHistory;
import com.example.apep_2223_group_3.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TaskDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    Task item;
    List<TaskHistory> historyList = new ArrayList<>();
    private Integer userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);


        recyclerView = findViewById(R.id.task_detail_recycler);
        TaskHistoryAdapter adapter = new TaskHistoryAdapter(historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        int itemId = Integer.parseInt(intent.getStringExtra("TASKID"));
        userId = Integer.parseInt(intent.getStringExtra("USERID"));
        item = Task.getItemById(this, itemId);

        TextView title = findViewById(R.id.task_detail_title_tv);
        TextView description = findViewById(R.id.task_detail_description_tv);
        TextView user = findViewById(R.id.task_detail_user_tv);
        TextView room = findViewById(R.id.task_detail_room_tv);

        title.setText(item.getName());
        description.setText(item.getDescription());
        user.setText(item.getUserName());
        room.setText(item.getRoomName());

        historyList.clear();
        historyList.addAll(CleaningBuddyDatabase.getDatabase(this).taskHistoryDao().getAllTaksHistory(itemId));
    }

    public void markTaskAsDone(View view) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String date = formatter.format(Calendar.getInstance().getTime());

        TaskHistory newHistoryItem = new TaskHistory(item.getId(), date, userId);
        CleaningBuddyDatabase.getDatabase(this).taskHistoryDao().insertOne(newHistoryItem);
        historyList.add(newHistoryItem);
    }
}