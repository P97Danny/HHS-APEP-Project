package com.example.apep_2223_group_3.Models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class newKamer {

    private static ArrayList<newKamer> kamers = new ArrayList<newKamer>(){{
                add(new newKamer("Jon Snow"));
                add(new newKamer("Vincent Chase"));
                add(new newKamer("Mr. White"));
            }};

@PrimaryKey
    private Integer id;
    private String name;
    private String description;

    public newKamer(String name) {
        this.name = name;
    }

    public newKamer() {
    }

    public newKamer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static ArrayList<newKamer> getKamers() {
        return kamers;
    }

    public static void setKamers(ArrayList<newKamer> kamers) {
        newKamer.kamers = kamers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void add(newKamer newkamer) {newKamer.kamers.add(newkamer);}

    public static ArrayList<newKamer> getAll() {return newKamer.kamers; }

    @Override
    public String toString() {
        return getName();
    }

}



