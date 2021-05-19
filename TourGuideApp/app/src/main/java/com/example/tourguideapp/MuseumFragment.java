package com.example.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumFragment extends Fragment {

    // 6 of the 6 Intents sent when a Venue is selected
    // Name of the Venue
    public static final String EXTRA_NAME = "com.example.tourguideapp.EXTRA_NAME";
    // Address of the Venue
    public static final String EXTRA_ADDRESS = "com.example.tourguideapp.EXTRA_ADDRESS";
    // About of the Venue
    public static final String EXTRA_ABOUT = "com.example.tourguideapp.EXTRA_ABOUT";
    // Telephone Number of the Venue
    public static final String EXTRA_TELEPHONE = "com.example.tourguideapp.EXTRA_TELEPHONE";
    // Website of the address of the Venue
    public static final String EXTRA_WEBSITE = "com.example.tourguideapp.EXTRA_WEBSITE";
    // Image of the Venue
    public static final String EXTRA_IMAGE = "com.example.tourguideapp.EXTRA_IMAGE";

    public MuseumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        final ArrayList<Venue> venues = new ArrayList<Venue>();

        /*
            //List of Venues added into array
            // 0, name, 1 address, 2, about, 3 telephone number, 4 website. 5 image file of venue
            // total of 10 items added
            // name, about are stored as stings in the strings.xml file
         */
        venues.add(new Venue(R.string.name_maritime, R.string.address_museum_maritime,
                R.string.about_maritime, R.string.museum_tel_maritime,
                R.string.website_museum_maritime,
                R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_cutty_sark, R.string.address_museum_cutty_sark,
                R.string.about_cutty_sark, R.string.museum_tel_cutty_sark,
                R.string.website_museum_cutty_sark, R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_oberavtory,
                R.string.address_museum_oberavtory,
                R.string.about_oberavtory, R.string.museum_tel_oberavtory,
                R.string.website_museum_oberavtory, R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_queen, R.string.address_museum_queen,
                R.string.about_queen, R.string.museum_tel_queen,
                R.string.website_museum_queen, R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_ranger, R.string.address_museum_ranger,
                R.string.about_ranger, R.string.museum_tel_ranger,
                R.string.website_museum_ranger,
                R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_old_college, R.string.address_museum_old_college,
                R.string.about_old_college, R.string.museum_tel_old_college,
                R.string.website_museum_old_college, R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_planetarium,
                R.string.address_museum_planetarium,
                R.string.about_planetarium, R.string.museum_tel_planetarium,
                R.string.website_museum_planetarium,
                R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_prime, R.string.address_museum_prime,
                R.string.about_prime, R.string.museum_tel_prime,
                R.string.website_museum_prime,
                R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_painted, R.string.address_museum_painted,
                R.string.about_painted, R.string.museum_tel_painted,
                R.string.website_museum_painted,
                R.drawable.main_alfege));
        venues.add(new Venue(R.string.name_alfege, R.string.address_museum_alfege,
                R.string.about_alfege,
                R.string.museum_tel_alfege, R.string.website_museum_alfege,
                R.drawable.main_alfege));

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        VenueAdapter adapter = new VenueAdapter(getActivity(), venues);


        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Venue} object at the given position the user clicked on
                Venue venue = venues.get(position);
                // gets the resource int of the name
                int venueNameAsInt = venue.getName();
                //gets string stored in the id and turns it into a string.
                String venueName = getString(venueNameAsInt);
                //gets the address of the venue as int
                int venueAddressAsInt = venue.getAddress();
                //gets string stored in the id and turns it into a string.
                String venueAddress = getString(venueAddressAsInt);
                // gets the resource int of the about of the venue
                int venueAboutAsInt = venue.getTheAbout();
                //gets string stored in the id and turns it into a string.
                String venueAbout = getString(venueAboutAsInt);
                // gets the telephone number of venue
                int venueTelephoneNumberAsInt = venue.getTelephoneNumber();
                // int telephone ID gets turned into a string
                String venueTelephoneNumber = getString(venueTelephoneNumberAsInt);
                // gets the website of the venue as an ID
                int venueWebsiteAsInt = venue.getWebsiteAddress();
                // int Website gets turned into a string
                String venueWebsite = getString(venueWebsiteAsInt);
                // gets the resource int of the of the image file.
                // image file is the image of the venue.
                int venueImage = venue.getTheImage();

                // Call the openNowPlayingActivity method and send the song vairables to be sent
                openDetailsActivity(venueImage, venueName, venueAddress, venueAbout, venueTelephoneNumber, venueWebsite);

            }
        });
        return rootView;

    }

    /*
        // Method use to create and send intents
        // @param image, Image of the venue
        // @param name, Name of the venue
        // @param address, Address of the venue
        // @param about, Text about of the venue
        // @param telephoneNumber, The telephone number of the venue of the venue
        // @param website of the venue
     */
    public void openDetailsActivity(int image, String name, String address, String about, String telephoneNumber, String website) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        // source is the string to check where it is coming from

        intent.putExtra(EXTRA_IMAGE, image);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_ADDRESS, address);
        intent.putExtra(EXTRA_ABOUT, about);
        intent.putExtra(EXTRA_TELEPHONE, telephoneNumber);
        intent.putExtra(EXTRA_WEBSITE, website);
        startActivity(intent);
    }
}