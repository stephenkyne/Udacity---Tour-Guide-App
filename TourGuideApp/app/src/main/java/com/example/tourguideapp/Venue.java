package com.example.tourguideapp;

public class Venue {

    // Name of the Venue /
    private int theName;

    // Address of the location, minus the venue name
    private int theAddress;

    // A short descriptions of the venue
    private int theAbout;

    //telephone number of the venue, assume in nation daily.
    // re, no international call prefix
    // telephone numbers are created and NOT real
    private int theTelephoneNumber;

    // Website of the venue or social media of venue
    private int theWebsiteAddress;

    // Image of venue, the outside or inside
    private int theImage;

    public Venue(int name, int address, int about, int telephoneNumber, int websiteAddress,
                 int image){
        theName = name;
        theAddress = address;
        theAbout = about;
        theTelephoneNumber = telephoneNumber;
        theWebsiteAddress = websiteAddress;
        theImage = image;
    }

    // gets the name of the venue
    public int getName() {
        return theName;
    }

    //gets the address minus the name of venue.
    public int getAddress() {return theAddress;}

    // gets the about text / descriptions of the venue
    public int getTheAbout() {return theAbout;}

    // gets the telephone number of venue
    public int getTelephoneNumber() {return theTelephoneNumber;}

    // gets the website of the venue
    public int getWebsiteAddress() {return theWebsiteAddress;}

    // gets the image of the venue
    public int getTheImage(){
        return theImage;
    }

}