package com.pdinc.alljavthings.DataStorage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User... user);

    @Insert
    void insertAll(User...users);

    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE age>= :age")
    List<User> getUsersWithAge(Integer age);
}