package com.example.apep_2223_group_3.Activities.newtaskandOverview;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apep_2223_group_3.Activities.RoomOverview.RoomOverviewActivity;
import com.example.apep_2223_group_3.Adapters.TaskAdapter;
import com.example.apep_2223_group_3.Models.Task;
import com.example.apep_2223_group_3.R;
import java.util.ArrayList;
import java.util.List;

public class OverviewTaskActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    ActivityResultLauncher<Intent> launcher;
    private List<Task> taskList = new ArrayList<>();
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent intent = getIntent();
        userId = intent.getStringExtra("USERID");

        recyclerView = findViewById(R.id.overview_list_rv_id);
        taskList.clear();
        taskList = Task.getAllForUser(this, Integer.valueOf(userId));
        TaskAdapter adapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void goToNewTaskActivity(View view){
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
    }

    public void goToRoomOverview(View view) {
        Intent intent = new Intent(this, RoomOverviewActivity.class);
        startActivity(intent);
    }

    public void goToDetail(View view) {
        Intent intent = new Intent(this, TaskDetailActivity.class);
        String itemId = String.valueOf(view.getId());
        intent.putExtra("TASKID", itemId);
        intent.putExtra("USERID", userId);
        startActivity(intent);
    }
}