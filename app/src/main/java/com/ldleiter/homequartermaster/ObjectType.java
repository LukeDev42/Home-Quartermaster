package com.ldleiter.homequartermaster;

import java.util.Date;

public class ObjectType {

    public ObjectType (String objectName, Date goodUntil) {
        System.out.println("Create new object type");
        this.objectName = objectName;
        this.goodUntil = goodUntil;

    };
    private String objectName;
    private Date goodUntil;

}
