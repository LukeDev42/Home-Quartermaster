package com.ldleiter.homequartermaster;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.io.File;

@Database(entities = {ItemTable.class}, version = 1, exportSchema = false)
public abstract class QuartermasterDatabase extends RoomDatabase
{
    private static final String DATABASE_NAME = "HomeQuartermaster.db";

    private static QuartermasterDatabase qmDatabase;

    public static QuartermasterDatabase getInstance(Context context)
    {
        if (qmDatabase == null)
        {
            qmDatabase = Room.databaseBuilder(context, QuartermasterDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
            qmDatabase.addStarterData();
        }

        return qmDatabase;
    }

    public abstract ItemDao itemDao();

    private void addStarterData()
    {
        int id = 0;
        if (itemDao().getItems().size() == 0)
        {
            runInTransaction(() ->
            {
                ItemTable item = new ItemTable(0, "Camry", "A 2004 camry with 1802k miles on it");
                itemDao().insertItem(item);

                item = new ItemTable(1, "Hammer", "This is a hammer");
                itemDao().insertItem(item);

                item = new ItemTable(2, "Wrench", "This is a wrench");
                itemDao().insertItem(item);

                item = new ItemTable(3, "Screwdriver-Flat Head", "This is a flat head screwdriver");
                itemDao().insertItem(item);

                item = new ItemTable(4, "Screwdriver-Philips Head", "This is a philips head screwdriver");
                itemDao().insertItem(item);

                item = new ItemTable(5, "Drill", "This is an electric drill");
                itemDao().insertItem(item);

                item = new ItemTable(6, "14 in Axe", "This is an axe with a 14 in handle");
                itemDao().insertItem(item);

                item = new ItemTable(7, "Drill Bits", "These are different drill bits for an electric drill");
                itemDao().insertItem(item);

                item = new ItemTable(8, "Hand Saw", "This is a saw used to make wooden planks");
                itemDao().insertItem(item);

                item = new ItemTable(9, "Table Saw", "A moterized saw integrated into a table for splitting wooden planks");
                itemDao().insertItem(item);

                item = new ItemTable(10, "Tire Iron", "Used to take the lug nuts off of a tire");
                itemDao().insertItem(item);

                item = new ItemTable(11, "WD-40", "A lubricant useful for many applications; lubricant, cleaning, protection");
                itemDao().insertItem(item);

                item = new ItemTable(12, "Box Cutter", "A razor sharp knife for butting boxes and other paper based products");
                itemDao().insertItem(item);

                item = new ItemTable(13, "Metal File", "A file for smoothing corners and refinishing metal surfaces");
                itemDao().insertItem(item);

                item = new ItemTable(14, "Chisel", "Used o cut small pieces of wood precisely, often used in corners of furniture");
                itemDao().insertItem(item);

                item = new ItemTable(15, "Acer Laptop", "Luke's laptop primarily used for school");
                itemDao().insertItem(item);

                item = new ItemTable(16, "Thinkpad Laptop", "Elizabeth's laptop primarily used for crafting projects and light gaming");
                itemDao().insertItem(item);
            });
        }
    }


}
