package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import fragment.Today;


/**
 * Created by wolfsoft3 on 24/7/18.
 */

public class TabtodaytasktodoAdapter extends FragmentStatePagerAdapter {
    int numoftabs;

    public TabtodaytasktodoAdapter(FragmentManager fm, int  mnumoftabs ) {
        super(fm);
        this.numoftabs = mnumoftabs;
        Log.i("mnumoftabs",String.valueOf(mnumoftabs));
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: {
                Bundle pos = new Bundle();
                pos.putInt("position", 0);
                Today tab1 = new Today();
                tab1.setArguments(pos);
                return tab1;
            }

            case 1:{
                Bundle pos = new Bundle();
                pos.putInt("position",1);
                Today tab1 = new Today();
                tab1.setArguments(pos);
                return tab1;

            }


            case 2: {
                Bundle pos = new Bundle();
                pos.putInt("position",2);
                Log.i("fragPosition","2");
                Today tab1 = new Today();
                tab1.setArguments(pos);
                return tab1;
            }
            case 3:{
                Bundle pos = new Bundle();
                pos.putInt("position",3);
                Today tab1 = new Today();
                tab1.setArguments(pos);
                return tab1;

            }


            case 4:{
                Bundle pos = new Bundle();
                pos.putInt("position",4);
                Today tab1 = new Today();
                tab1.setArguments(pos);
                return tab1;

            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
            return numoftabs;
    }
}
