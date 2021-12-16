package com.ldleiter.homequartermaster;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository
{
    private static ItemRepository instance;
    private List<Item> mItems;

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
        mItems = new ArrayList<>();
        Resources res = context.getResources();
        String[] bands = res.getStringArray(R.array.items);
        String[] descriptions = res.getStringArray(R.array.itemDescriptions);
        for (int i = 0; i < bands.length; i++)
        {
            mItems.add(new Item(i + 1, bands[i], descriptions[i]));
        }
    }

    public List<Item> getItems()
    {
        return mItems;
    }

    public Item getItem(int itemId)
    {
        for (Item item : mItems)
        {
            if (item.getId() == itemId)
            {
                return item;
            }
        }
        return null;
    }
}
