package com.kanjih.habit_tracker.data;

import android.provider.BaseColumns;

/**
 * Created by kneto on 3/26/17.
 */

public final class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habittracker";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_TASK = "task";
        public static final String COLUMN_HABIT_TIME = "time";
        public static final String COLUMN_HABIT_LATITUDE = "latitude";
        public static final String COLUMN_HABIT_LONGITITUDE = "longitude";
        public static final String COLUMN_HABIT_ALTITUDE = "altitude";
    }

}
