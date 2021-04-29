package com.pdinc.alljavthings.DataStorage;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    String name;
    String address;
    String number;
    Integer age;
    @PrimaryKey(autoGenerate = true)
    Long id;

    public User(String name, String address, String number, int age) {
        this.name=name;
        this.address=address;
        this.number=number;
        this.age=age;
    }
}
