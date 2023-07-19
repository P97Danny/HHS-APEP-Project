package com.example.apep_2223_group_3.Utils;

public class NameAndDescValidatie {

    public static boolean checkOfNameIsEmpty (String name) {
        if (name.isEmpty()) {
            return false;
        }
        return true;
    }
    public static boolean checkOfNameAndDescriptionIsStrings (String name, String description) {
        System.out.println("Beshcrijving" + description);
        System.out.println("Naam" + name.matches("[a-zA-Z]+"));

        if (!name.matches("[a-zA-Z]+") && !description.matches("[a-zA-Z]+")) {
            return false;
        }
        return true;
    }

}

