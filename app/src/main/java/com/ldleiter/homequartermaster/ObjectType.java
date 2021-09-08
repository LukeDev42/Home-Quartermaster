package com.ldleiter.homequartermaster;

import android.util.Log;

import java.util.Date;

public class ObjectType {

    public ObjectType (String objectName, Date goodUntil) {
        Log.i("CreateObjectConstructor", "Create new object type");
        this.objectName = objectName;
        this.goodUntil = goodUntil;

    };
    private String objectName;
    private Date goodUntil;

}
