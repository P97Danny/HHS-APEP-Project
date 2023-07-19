package com.example.apep_2223_group_3.Utils;

import android.text.TextUtils;
import android.widget.EditText;

public class PasswordValidator {

    public static boolean passwordValidator(String password, String passwordSecond) {
        if (password.isEmpty()) {
            return false;
        }

        return password.equals(passwordSecond);
    }

}
