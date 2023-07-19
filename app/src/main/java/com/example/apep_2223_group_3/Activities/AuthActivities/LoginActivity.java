package com.example.apep_2223_group_3.Activities.AuthActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apep_2223_group_3.Activities.newtaskandOverview.OverviewTaskActivity;
import com.example.apep_2223_group_3.Models.User;
import com.example.apep_2223_group_3.R;

public class LoginActivity extends AppCompatActivity {
    EditText userName;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = findViewById(R.id.login_et_username);
        password = findViewById(R.id.login_et_password);
        userName.setBackgroundColor(getResources().getColor(R.color.defaultInput, this.getTheme()));
        password.setBackgroundColor(getResources().getColor(R.color.defaultInput, this.getTheme()));
    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        User userExist = null;
        if (!TextUtils.isEmpty(userName.getText()) && !TextUtils.isEmpty(password.getText())) {
            try {
                userExist = User.getOneUser(userName.getText().toString(), this);
                if (userExist == null) {
                    userName.setBackgroundColor(getResources().getColor(R.color.errorColor, this.getTheme()));
                    Toast.makeText(this,"Kon geen account vinden met gebruikersnaam: " + userName.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            } catch (SQLiteConstraintException e) {
                Toast.makeText(this,"Er is een fout opgetreden op de server.", Toast.LENGTH_SHORT).show();
            }

            if (userExist != null && password.getText().toString().equals(userExist.getPassword())){
                Intent intent = new Intent(this, OverviewTaskActivity.class);
                intent.putExtra("USERID", String.valueOf(userExist.getId()));
                startActivity(intent);
            } else {
                userName.setBackgroundColor(getResources().getColor(R.color.errorColor, this.getTheme()));
                password.setBackgroundColor(getResources().getColor(R.color.errorColor, this.getTheme()));
                Toast.makeText(this,"Controleer uw wachtwoord of gebruikersnaam.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Vul alle gegevens in", Toast.LENGTH_SHORT).show();
        }
    }
}