package com.pdinc.alljavthings.DataStorage;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1)
abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
