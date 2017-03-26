package com.kanjih.habit_tracker;

import android.content.Context;
import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.kanjih.habit_tracker.bs.HabitTrackerService;
import com.kanjih.habit_tracker.to.HabitTrackerTO;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import static android.media.CamcorderProfile.get;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.kanjih.habit_tracker", appContext.getPackageName());
    }


    @Test
    public void testInsertRead() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        //String task, Date timestamp, String latitude, String longitude, String altitude
        HabitTrackerTO to = new HabitTrackerTO("walking with dog", new Date(), "44.968046", "-94.420307", "11123");

        HabitTrackerService service = new HabitTrackerService(appContext);

        Cursor cursor = service.findAll();

        assertTrue(cursor.getCount() > 1);

        List<HabitTrackerTO> list = service.getHabitUsingCursor(cursor);
        HabitTrackerTO tracker = list.get(0);
        assertEquals(to.getTask(), tracker.getTask());
        assertEquals(to.getLatitude(), tracker.getLatitude());
        assertEquals(to.getLongitude(), tracker.getLongitude());

    }
}
