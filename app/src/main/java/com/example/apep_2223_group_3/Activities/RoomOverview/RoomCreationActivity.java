package com.example.apep_2223_group_3.Activities.RoomOverview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.example.apep_2223_group_3.Models.RoomEntity;
import com.example.apep_2223_group_3.R;

import java.util.ArrayList;

public class RoomCreationActivity  extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomcreation);
    }

    public void createRoom(View view) {
        EditText etRoomName = findViewById(R.id.room_creation_et_task_list);

        if (!TextUtils.isEmpty(etRoomName.getText())) {
            RoomEntity newRoomEntity = new RoomEntity(etRoomName.getText().toString());
            RoomEntity.add(newRoomEntity, this);

            Intent intent = new Intent(this, RoomOverviewActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Room already exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToRoomOverview(View view) {
        Intent intent = new Intent(this, RoomOverviewActivity.class);
        startActivity(intent);
    }
}
