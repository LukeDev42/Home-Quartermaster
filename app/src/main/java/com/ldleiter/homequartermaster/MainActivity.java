package com.ldleiter.homequartermaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createObjectGroup(View view)
    {
        ObjectGroup ot = new ObjectGroup("Car", "This is all my cars");
        Log.i("CreateObjectButton", "This button created an object");
    };
}