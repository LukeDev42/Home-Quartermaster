package com.ldleiter.homequartermaster;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository
{
    private static ItemRepository instance;
    private List<ItemTable> mItems;
    private QuartermasterDatabase qmDb;

    public static ItemRepository getInstance(Context context)
    {
        instance = new ItemRepository(context);
        return instance;
    }

    private ItemRepository(Context context)
    {
        qmDb = QuartermasterDatabase.getInstance(context.getApplicationContext());
        mItems = qmDb.itemDao().getItems();
    }

    public List<ItemTable> getItems()
    {
        return mItems;
    }

    public ItemTable getItem(int itemId)
    {
        for (ItemTable item : mItems)
        {
            if (item.getId() == itemId)
            {
                return item;
            }
        }
        return null;
    }

    public void insertItem(ItemTable newItem)
    {
        qmDb.itemDao().insertItem(newItem);
    }
}
