package com.example.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class VenueAdapter extends ArrayAdapter<Venue>{

    public VenueAdapter(Context context, ArrayList<Venue> venues) {
        super(context, 0, venues);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Venue currentVenue = getItem(position);

        // Find the TextView in the list_item.xml layout with
        // Name of the Venue is stored here
        TextView nameTextView = convertView.findViewById(R.id.name_text_view);
        // Get the Current Venue Name
        // the set the current Venue to the text view.
        nameTextView.setText(currentVenue.getName());

        /// Find the ImageView in the list_item.xml layout with
        // Image of the Venue is stored here
        ImageView imageView = convertView.findViewById(R.id.image);
        // Get the Current Venue Image
        // the set the current Venue to the text view.
        imageView.setImageResource(currentVenue.getTheImage());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return convertView;
    }
}
