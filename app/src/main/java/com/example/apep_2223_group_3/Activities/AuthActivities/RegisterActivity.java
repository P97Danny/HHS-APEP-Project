package com.example.apep_2223_group_3.Activities.AuthActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apep_2223_group_3.Database.CleaningBuddyDatabase;
import com.example.apep_2223_group_3.Models.User;
import com.example.apep_2223_group_3.R;
import com.example.apep_2223_group_3.Utils.PasswordValidator;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void backToLogin(View view) {
        finish();
    }

    public void registerUser(View view) {
        User existUser = null;
        EditText etUserName = findViewById(R.id.register_et_username);
        EditText etPassword = findViewById(R.id.register_et_password);
        EditText etPassword2 = findViewById(R.id.register_et_password_2);

        if (!TextUtils.isEmpty(etUserName.getText()) && PasswordValidator.passwordValidator(etPassword.getText().toString(), etPassword2.getText().toString())) {
            try {
                existUser = CleaningBuddyDatabase.getDatabase(this).userDao().getOneUser(etUserName.getText().toString());
            } catch (SQLiteConstraintException e) {
                Toast.makeText(this,"Failed to get the user" + e,Toast.LENGTH_SHORT).show();
            }

            if (existUser == null) {
                User newUser = new User(etUserName.getText().toString(), etPassword.getText().toString());
                try {
                    User.setOneUser(newUser, this);
                } catch (SQLiteConstraintException e) {
                    Toast.makeText(this,"Failed to insert the user" + e,Toast.LENGTH_SHORT).show();
                }
                finish();
            } else {
                Toast.makeText(this,"User exists already",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Invalid input",Toast.LENGTH_SHORT).show();
        }
    }
}