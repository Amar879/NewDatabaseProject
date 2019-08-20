package com.example.newdatabaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static androidx.room.Room.databaseBuilder;


public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        fragmentManager=getSupportFragmentManager();



        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container,new HomeFragment()).commit();
            myAppDatabase= databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();
        }

    }



}
