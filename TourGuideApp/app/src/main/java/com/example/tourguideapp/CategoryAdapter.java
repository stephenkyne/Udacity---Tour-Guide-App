package com.example.tourguideapp;

import android.content.Context;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link } objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            // opens the Museum Fragment
            return new MuseumFragment();
        } else if (position == 1) {
            // opens the Food Fragment
            return new FoodFragment();
        } else if (position == 2) {
            // opens the Drinks Fragment
            return new DrinkFragment();
        } else {
            // Default, opens the Hotel Fragment
            return new HotelFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       //Name of the tabs stored in strings in string.xml file
        if (position == 0) {
            return mContext.getString(R.string.tab_museum);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_food);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_drink);
        } else {
            return mContext.getString(R.string.tab_hotel);
        }
    }
}