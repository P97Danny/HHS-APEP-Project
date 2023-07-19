package com.example.apep_2223_group_3.Activities.RoomOverview;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apep_2223_group_3.Adapters.RoomOverviewAdapter;
import com.example.apep_2223_group_3.Models.RoomEntity;
import com.example.apep_2223_group_3.R;

import java.util.ArrayList;
import java.util.List;


public class RoomOverviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<RoomEntity> roomList = new ArrayList<>();
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomoverview);

        roomList.clear();
        roomList.addAll(RoomEntity.getAll(this));
        recyclerView = findViewById(R.id.room_overview_lv_rooms);
        RoomOverviewAdapter adapter = new RoomOverviewAdapter(roomList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void onActivityResult(ActivityResult result) {
        roomList.clear();
        roomList.addAll(RoomEntity.getAll(this));
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public void goToRoomCreation(View view) {
        Intent intent = new Intent(this, RoomCreationActivity.class);
        startActivity(intent);
    }

    /*public void goToRoomDetails(View view) {
        Intent intent = new Intent(this, RoomDetailsActivity.class);
        startActivity(intent);
    }*/

}
