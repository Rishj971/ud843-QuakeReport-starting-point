package com.example.android.quakereport;

/**
 * Created by RJ on 03-08-2017.
 */

public class EarthQuake {

    private String mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;


    public EarthQuake(String magnitude, String location, long timeInMilliSeconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliSeconds;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }


}