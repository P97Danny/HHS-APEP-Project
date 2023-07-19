package com.example.apep_2223_group_3.Activities.newtaskandOverview;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.widget.Toast;
//import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.apep_2223_group_3.Activities.RoomOverview.RoomOverviewActivity;
import com.example.apep_2223_group_3.Models.Task;
import com.example.apep_2223_group_3.Models.RoomEntity;
import com.example.apep_2223_group_3.Models.User;
import com.example.apep_2223_group_3.R;
import com.example.apep_2223_group_3.Utils.NameAndDescValidatie;

public class NewTaskActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Spinner spinnerRoom = findViewById(R.id.newtask_kamers_spnr_id);
        ArrayAdapter<RoomEntity> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                RoomEntity.getAll(this)
        );
        spinnerRoom.setAdapter(adapter);

        Spinner spinnerUser = findViewById(R.id.newtask_user_spnr_id);
        ArrayAdapter<User> adapter2 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                User.getAll(this)
        );
        spinnerUser.setAdapter(adapter2);
    }

    public void save(View view) {
        Task newTask = null;
        EditText nameET = findViewById(R.id.newtask_name_et_id);
        EditText descriptionEt = findViewById(R.id.newtask_description_et_id);
        String name = nameET.getText().toString();
        String description = descriptionEt.getText().toString();

        Spinner spinnerUser = findViewById(R.id.newtask_user_spnr_id);
        Spinner spinnerRoom = findViewById(R.id.newtask_kamers_spnr_id);

        if (!NameAndDescValidatie.checkOfNameIsEmpty(name)) {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!NameAndDescValidatie.checkOfNameAndDescriptionIsStrings(name, description)) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
            return;
        }

        if( spinnerUser.getSelectedItem() != null && spinnerRoom.getSelectedItem() !=null) {
            User user = (User) spinnerUser.getSelectedItem();
            RoomEntity room = (RoomEntity) spinnerRoom.getSelectedItem();
            newTask = new Task(name, description, 8, user.getId(), room.getId());

        } else if (spinnerRoom.getSelectedItem() != null) {
            RoomEntity room = (RoomEntity) spinnerRoom.getSelectedItem();
            newTask = new Task(name, description, 8, room.getId());

        } else if (spinnerUser.getSelectedItem() != null) {
            User user = (User) spinnerUser.getSelectedItem();
            newTask = new Task(name, description, 8, user.getId());
        }


//        //opslaan van radiobuttons veld
//        RadioButton radioButtonDagelijks = findViewById(R.id.newtask_interval_radio_btn_id);
//        RadioButton radioButtonWekelijks = findViewById(R.id.newtask_interval_radio2_btn_id);
//        RadioButton radioButtonCustom = findViewById(R.id.newtask_interval_radio_custom_btn_id);
//        EditText customRadioButtonET = findViewById(R.id.edit_text_radio3_id); //tekstveld die bij radiobutton custom hoort
//        String customRadioButtonInput = customRadioButtonET.getText().toString(); //tekst uit radiobutton custom word opgehaald

        Task.add(newTask, this);
        Intent intent = new Intent(this, OverviewTaskActivity.class);
        startActivity(intent);
}
    public void cancel (View view) {
        finish();
    }

}