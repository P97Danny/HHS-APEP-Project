package com.example.apep_2223_group_3;

import static org.junit.Assert.assertEquals;

import com.example.apep_2223_group_3.Utils.PasswordValidator;

import org.junit.Test;

public class UserTest {
    @Test
    public void passwordValidator_should_return_true() {
        String password1 = "SuperSecret";
        String password2 = "SuperSecret";

        boolean result =  PasswordValidator.passwordValidator(password1, password2);

        boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void passwordValidator_should_return_false() {
        String password1 = "SuperSecret";
        String password2 = "SuperSecretOrNot";

        boolean result =  PasswordValidator.passwordValidator(password1, password2);

        boolean expected = false;
        assertEquals(expected, result);
    }
}
