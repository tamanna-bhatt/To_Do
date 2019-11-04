package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.Today;


/**
 * Created by wolfsoft3 on 24/7/18.
 */

public class TabtodaytasktodoAdapter extends FragmentStatePagerAdapter {
    int numoftabs;

    public TabtodaytasktodoAdapter(FragmentManager fm, int  mnumoftabs ) {
        super(fm);
        this.numoftabs = mnumoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Today tab1 = new Today();
                return tab1;

            case 1:
                Today tab2 = new Today();
                return tab2;

            case 2:
                Today tab3 = new Today();
                return tab3;
            case 3:
                Today tab7 = new Today();
                return tab7;

            case 4:
                Today tab4 = new Today();
                return tab4;
            case 5:
                Today tab5 = new Today();
                return tab5;

            case 6:
                Today tab6 = new Today();
                return tab6;

            case 7:
                Today tab9 = new Today();
                return tab9;

            case 8:
                Today tab8 = new Today();
                return tab8;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
            return numoftabs;
    }
}
