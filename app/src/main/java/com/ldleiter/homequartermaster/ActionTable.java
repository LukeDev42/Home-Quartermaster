package com.ldleiter.homequartermaster;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

import java.sql.Date;

@Entity(foreignKeys = @ForeignKey(entity = ItemTable.class, parentColumns = "id", childColumns = "itemID"))
public class ActionTable
{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @NonNull
    @ColumnInfo(name = "itemID")
    private long itemID;
}
