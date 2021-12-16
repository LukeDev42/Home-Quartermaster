package com.ldleiter.homequartermaster;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity
public class ItemTable
{
    public ItemTable(long id, @NonNull String name, String description)
    {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.creationTime = System.currentTimeMillis();
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "CreationTime")
    private long creationTime;

    public void setId(long id)
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

    public long getId()
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
