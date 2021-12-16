package com.ldleiter.homequartermaster;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ItemTable
{
    public ItemTable(int id, @NonNull String name, String description)
    {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.creationTime = System.currentTimeMillis();
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "CreationTime")
    private long creationTime;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setName(@NonNull String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    @NonNull
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public long getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime(long creationTime)
    {
        this.creationTime = creationTime;
    }
}
