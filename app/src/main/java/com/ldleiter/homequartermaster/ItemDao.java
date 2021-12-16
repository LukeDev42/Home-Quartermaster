package com.ldleiter.homequartermaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public class ItemDao
{
    @Query("SELECT * FROM ItemTable WHERE id = :id")
    public ItemTable getItem(long id);

    @Query("SELECT * FROM ItemTable ORDER BY id")
    public List<ItemTable> getItems();
}
