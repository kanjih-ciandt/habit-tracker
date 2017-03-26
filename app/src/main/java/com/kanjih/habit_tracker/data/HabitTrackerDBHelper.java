package com.kanjih.habit_tracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kanjih.habit_tracker.data.HabitContract.HabitEntry;

/**
 * Created by kneto on 3/26/17.
 */
public class HabitTrackerDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitTrackerDBHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "habittracker.db";

    /**
     *  Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;


    public HabitTrackerDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_TASK + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_TIME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_ALTITUDE + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_LATITUDE + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_LONGITITUDE + " TEXT NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
