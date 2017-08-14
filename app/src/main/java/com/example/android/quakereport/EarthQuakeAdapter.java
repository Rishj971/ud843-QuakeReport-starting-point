package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by RJ on 03-08-2017.
 */

public class EarthQuakeAdapter extends ArrayAdapter<EarthQuake> {

    public EarthQuakeAdapter(Context context, ArrayList<EarthQuake> earthQuakes)
    {

super(context , 0 , earthQuakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.eathquake_list_item, parent, false);
        }



        // Get the {@link AndroidFlavor} object located at this position in the list
        EarthQuake currentEarthQuake =  getItem(position);

        // Find the TextView in the earthquake_list_item.xml layout with the ID version_name
        TextView magnitude = (TextView) listView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        magnitude.setText(currentEarthQuake.getMagnitude());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView location = (TextView) listView.findViewById(R.id.location);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        location.setText(currentEarthQuake.getLocation());
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthQuake.getTimeInMilliseconds());




        // Find the TextView with view ID date
        TextView dateView = (TextView) listView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        /**
         * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
         */
        private String formatDate(Date dateObject) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
            return dateFormat.format(dateObject);
        }

        /**
         * Return the formatted date string (i.e. "4:30 PM") from a Date object.
         */
        private String formatTime(Date dateObject) {
            SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
            return timeFormat.format(dateObject);
        }



        // Return the list item view that is now showing the appropriate data
        return listView;

    }

}
