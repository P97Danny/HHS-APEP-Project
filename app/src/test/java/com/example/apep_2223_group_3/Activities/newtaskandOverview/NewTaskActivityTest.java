package com.example.apep_2223_group_3.Activities.newtaskandOverview;
import static org.junit.Assert.*;
import com.example.apep_2223_group_3.Utils.NameAndDescValidatie;
import org.junit.Test;

public class NewTaskActivityTest {

   @Test
    public void checkOfNameAndDescriptionIsStrings_should_return_true() {
        String name = "test";
        String description = "test";

        boolean result = NameAndDescValidatie.checkOfNameAndDescriptionIsStrings(name, description);
        boolean expected = true;
        assertEquals(expected, result);
    }
   @Test
    public void checkOfNameAndDescriptionIsStrings_should_return_false() {
       String tekens = "433>><.";

       boolean result = NameAndDescValidatie.checkOfNameAndDescriptionIsStrings(tekens, tekens);
       boolean expected = false;
       assertEquals(expected, result);
    }
    @Test
    public void checkOfNameIsEmpty_should_return_false() {
        String name = "";

        boolean result = NameAndDescValidatie.checkOfNameIsEmpty(name);
        boolean expected = false;
        assertEquals(expected, result);
    }
    @Test
    public void checkOfNameIsEmpty_should_return_true() {
        String name = "test";

        boolean result = NameAndDescValidatie.checkOfNameIsEmpty(name);
        boolean expected = true;
        assertEquals(expected, result);
    }

    }

