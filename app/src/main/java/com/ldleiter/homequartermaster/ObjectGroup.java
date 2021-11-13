package com.ldleiter.homequartermaster;

import android.util.Log;

public class ObjectGroup
{

    public ObjectGroup(String name, String description) {
        Log.i("CreateObjectConstructor", "Create new object type");
        this.name = name;
        this.description = description;
    };
    private String name;
    private String description;

}
