package com.ldleiter.homequartermaster;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao
{
    @Query("SELECT * FROM ItemTable WHERE id = :id")
    public ItemTable getItem(long id);

    @Query("SELECT * FROM ItemTable ORDER BY id")
    public List<ItemTable> getItems();

    @Query("SELECT * FROM ItemTable WHERE name = :name")
    public ItemTable getItemByText(String name);

    @Query("SELECT * FROM ItemTable ORDER BY creationTime DESC")
    public List<ItemTable> getItemsNewerFirst();

    @Query("SELECT * FROM ItemTable ORDER BY creationTime ASC")
    public List<ItemTable> getItemsOlderirst();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertItem(ItemTable item);

    @Update
    public void updateItem(ItemTable item);

    @Delete
    public void deleteItem(ItemTable item);
}
