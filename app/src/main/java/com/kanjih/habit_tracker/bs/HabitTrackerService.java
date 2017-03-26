package com.kanjih.habit_tracker.bs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.kanjih.habit_tracker.data.HabitTrackerDBHelper;
import com.kanjih.habit_tracker.to.HabitTrackerTO;
import com.kanjih.habit_tracker.data.HabitContract.HabitEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kneto on 3/26/17.
 */

public class HabitTrackerService {

    private Context context = null;

    private HabitTrackerDBHelper dbHelper = null;

    public SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");



    public HabitTrackerService(Context context) {
        this.context = context;
        dbHelper = new HabitTrackerDBHelper(context);
    }

    public long insertHabit(HabitTrackerTO habit){

        // Gets the database in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_TASK, habit.getTask());
        values.put(HabitEntry.COLUMN_HABIT_TIME, DATE_FORMAT.format(habit.getTimestamp()));
        values.put(HabitEntry.COLUMN_HABIT_LATITUDE, habit.getLatitude());
        values.put(HabitEntry.COLUMN_HABIT_LONGITITUDE, habit.getLongitude());
        values.put(HabitEntry.COLUMN_HABIT_ALTITUDE, habit.getAltitude());

        return db.insert(HabitEntry.TABLE_NAME, null, values);
    }



    public Cursor findAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        return this.simpleQuery(null,null);
    }


    public List<HabitTrackerTO> getHabitUsingCursor(Cursor cursor) throws Exception{
        cursor.moveToFirst();
        List<HabitTrackerTO> list =  new ArrayList<HabitTrackerTO>();

        // Figure out the index of each column
        int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
        int taskColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TASK);
        int timeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_TIME);
        int latitudeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_LATITUDE);
        int longitudeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_LONGITITUDE);
        int altitudeColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_ALTITUDE);
        // Iterate through all the returned rows in the cursor
        while (cursor.moveToNext()) {
            HabitTrackerTO habitTrackerTO = new HabitTrackerTO();
            habitTrackerTO.setId(cursor.getInt(idColumnIndex));
            habitTrackerTO.setTask(cursor.getString(taskColumnIndex));
            habitTrackerTO.setTimestamp(DATE_FORMAT.parse(cursor.getString(timeColumnIndex)));
            habitTrackerTO.setLatitude(cursor.getString(latitudeColumnIndex));
            habitTrackerTO.setLongitude(cursor.getString(longitudeColumnIndex));
            habitTrackerTO.setAltitude(cursor.getString(altitudeColumnIndex));
            list.add(habitTrackerTO);

        }

        return list;
    }

    private Cursor simpleQuery(String selections, String[] selectionArgs){
        // Create and/or open a database to read from it
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_TASK,
                HabitEntry.COLUMN_HABIT_TIME,
                HabitEntry.COLUMN_HABIT_LONGITITUDE,
                HabitEntry.COLUMN_HABIT_LATITUDE,
                HabitEntry.COLUMN_HABIT_ALTITUDE,

        };

        return db.query(HabitEntry.TABLE_NAME,projection,selections,selectionArgs,null,null,null);
    }


}
