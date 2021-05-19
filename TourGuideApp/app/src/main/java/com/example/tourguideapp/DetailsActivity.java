package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Venue image is displayed here
        ImageView imageImageView = findViewById(R.id.details_image);
        // Venue name is displayed here
        TextView nameTextView = findViewById(R.id.details_name_text_view);
        // Venue address is displayed here
        TextView addressTextView = findViewById(R.id.details_address_text_view);
        // Venue about is displayed here
        TextView aboutTextView = findViewById(R.id.details_about_text_view);
        // Telephone number as Text is displayed here
        TextView telephoneTextView = findViewById(R.id.sub_text_telephone_text_view);
        // Website as Text is displayed here
        TextView websiteTextView = findViewById(R.id.sub_text_webite_text_view);
        // Address, again, with a copy incon and method is displayed here
        TextView subTextAddressTextView = findViewById(R.id.sub_text_address_text_view);

        /*
            // Copy Icon ImageViews
         */
        // Used to copy the telephone number only
        ImageView copyTelephoneImageView = findViewById(R.id.copy_telephone_image);
        // Used to copy the Address only
        ImageView copyAddressImageView = findViewById(R.id.copy_address_image);
        // Used to copy the website only
        ImageView copyWebsiteImageView = findViewById(R.id.copy_website_image);

        /*
         * Define Layouts where Icons and Text are displayed.
         * Clicked on Icons or Text are treated as one.
         */
        View callLayOut = findViewById(R.id.details_call_layout);

        /*
         * Define share where Icons and Text are displayed.
         * Clicked on Icons or Text are treated as one.
         */
        View shareLayOut = findViewById(R.id.details_share_layout);

        // Layout, holds Website / Public icon
        // used to open the Venue website on click
        View websitesLayOut = findViewById(R.id.details_website_layout);

        // Layout, holds directions / direction icon
        // used to open the Maps with directions
        View directionsLayOut = findViewById(R.id.details_directions_layout);

        Intent intent = getIntent();
        // Ints in the Array are already converted into Strings
        // Gets the name of the Venue
        String name = intent.getStringExtra(MuseumFragment.EXTRA_NAME);
        // Gets the name of the Venue
        String address = intent.getStringExtra(MuseumFragment.EXTRA_ADDRESS);
        // Gets the image of the Venue as a int ID resource.
        int image = intent.getIntExtra(MuseumFragment.EXTRA_IMAGE, 0);
        // Gets the about text of the Venue
        String about = intent.getStringExtra(MuseumFragment.EXTRA_ABOUT);
        // Gets the telephone number of the Venue
        String telephoneNumber = intent.getStringExtra(MuseumFragment.EXTRA_TELEPHONE);
        // Gets the website address of the Venue
        String website = intent.getStringExtra(MuseumFragment.EXTRA_WEBSITE);

        /*
            // The Intents are displayed
         */
        // @param name of the Venue
        nameTextView.setText(name);
        // @param address of the Venue
        addressTextView.setText(address);
        // @param address of the Venue
        // This is the address posted again, but with a copy icon and method.
        subTextAddressTextView.setText(address);
        // @param image of the Venue
        imageImageView.setImageResource(image);
        // @param about of the Venue
        aboutTextView.setText(about);
        // @param telephoneNumber of the Venue
        telephoneTextView.setText(telephoneNumber);
        // @param website of the Venue
        websiteTextView.setText(website);

         /*
            // On click Listener for call / call icon
            // @param telephone, the telephone number of of the venue
            // calls an intent and requests to use call app.
         */
        callLayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gets the URL to open the google map apps for directions
                String tel = getString(R.string.label_tel);
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(tel,
                        telephoneNumber, null));
                startActivity(intent);
            }
        });
        /*
            // On click Listener for share / share icon
            // @param name, the name of the venue
            // param address, the website of the venue
            // @param website, the website of the venue
            // calls an intent and requests to open a browser.
         */
        shareLayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = name;
                message += ". " + address;
                message += ". " + website;
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        /*
            // On click Listener for Website / public icon
            // @param website, the website of the venue being displayed
            // calls an intent and requests to open a browser.
         */
        websitesLayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(website));
                startActivity(intent);
                //Toast.makeText(DetailsActivity.this, website, Toast.LENGTH_SHORT).show();
            }
        });

         /*
            // On click Listener for directions / direction icon
            // @param address, the address of the venue being displayed
            // @param name, name of the venue
            // calls an intent and requests to map.
         */
        directionsLayOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // name, ", " and adress added togather
                // passed to the intent
                String mapLocation = name + ", " + address;
                // Gets the URL to open the google map apps for directions
                String googleMapsUrl = getString(R.string.google_maps_url);
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(googleMapsUrl + mapLocation));
                startActivity(intent);

            }
        });

        /*
            // On click Listener for copy icon for
            // @param telephone, the telephone number of the venue
            // Toast used to inform the user of the event.
         */
        copyTelephoneImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // Gets the string, "Telephone Number" (En), made into the label
                String labelTelephone = getString(R.string.label_telephone);
                ClipData clip = ClipData.newPlainText(labelTelephone, telephoneNumber);
                clipboard.setPrimaryClip(clip);
                // Gets the string, "Copied" (En) to be made into a toast message
                String copied = getString(R.string.copied);
                Toast.makeText(DetailsActivity.this, copied + ", \""
                        + telephoneNumber + "\"", Toast.LENGTH_SHORT).show();

            }
        });

        /*
            // On click Listener for copy icon for
            // @param address, the address number of the venue
            // Toast used to inform the user of the event.
         */
        copyAddressImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // Gets the string, "Venue Address" (En), made into the label
                String labelAddress = getString(R.string.label_address);
                ClipData clip = ClipData.newPlainText(labelAddress, address);
                clipboard.setPrimaryClip(clip);
                // Gets the string, "Copied" (En) to be made into a toast message
                String copied = getString(R.string.copied);
                Toast.makeText(DetailsActivity.this, copied + ", \"" + address
                        + "\"", Toast.LENGTH_SHORT).show();

            }
        });

        /*
            // On click Listener for copy icon for
            // @param website, the website address of the venue
            // Toast used to inform the user of the event.
         */
        copyWebsiteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // Gets the string, "Website Address" (En), made into the label
                String labelWebsite = getString(R.string.label_website);
                ClipData clip = ClipData.newPlainText(labelWebsite, website);
                clipboard.setPrimaryClip(clip);
                // Gets the string, "Copied" (En) to be made into a toast message
                String copied = getString(R.string.copied);
                Toast.makeText(DetailsActivity.this, copied + ", \"" + website
                        + "\"", Toast.LENGTH_SHORT).show();

            }
        });

    }
}