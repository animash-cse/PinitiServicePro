package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.HistoryBookingFragment;
import fragment.OnGoingBookingFragment;

public class CategoryPagerAdapterBooking extends FragmentPagerAdapter {

    int mNoOfTabs;

    public CategoryPagerAdapterBooking(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                OnGoingBookingFragment tab1 = new OnGoingBookingFragment();
                return tab1;
            case 1:
                HistoryBookingFragment tab2 = new HistoryBookingFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;

    }
}

