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
        if (instance == null)
        {
            instance = new ItemRepository(context);
        }
        return instance;
    }

    private ItemRepository(Context context)
    {
        qmDb = QuartermasterDatabase.getInstance(context.getApplicationContext());
        mItems = qmDb.itemDao().getItems();
//        Resources res = context.getResources();
//        String[] bands = res.getStringArray(R.array.items);
//        String[] descriptions = res.getStringArray(R.array.itemDescriptions);
//        for (int i = 0; i < bands.length; i++)
//        {
//            mItems.add(new Item(i + 1, bands[i], descriptions[i]));
//        }
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
}
