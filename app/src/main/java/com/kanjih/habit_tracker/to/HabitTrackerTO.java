package com.kanjih.habit_tracker.to;

import java.util.Date;

/**
 * Created by kneto on 3/26/17.
 */

public class HabitTrackerTO {
    private int id;
    private String task;
    private Date timestamp;
    private String latitude;
    private String longitude;
    private String altitude;


    /**
     *
     */
    public HabitTrackerTO() {
    }

    public HabitTrackerTO(String task, Date timestamp, String latitude, String longitude, String altitude) {
        this.task = task;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }
}
