package com.example.newdatabaseproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public  interface MyDao {

    @Insert
public void addUser(User user);


//    @Query("select * from users")
//public List<User>getUser();


    @Delete
    public void deleteUser(User user);

    @Query("select * from users")
    public List<User> findUser();


    @Query("DELETE FROM users")
    public void deleteAllUsers();

    @Update
    public void userUpdate(User user);

    @Query("select * from users")
    public List<User> findUsers();
}
