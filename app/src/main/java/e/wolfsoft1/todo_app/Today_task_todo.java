package e.wolfsoft1.todo_app;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import adapter.TabtodaytasktodoAdapter;

public class Today_task_todo extends AppCompatActivity {


    ViewPager viewPager1;
    TabLayout tabLayout1;
    TabtodaytasktodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_task_todo);



        tabLayout1 = findViewById(R.id.tablayout1);

        viewPager1 = findViewById(R.id.viewpager1);

//        setCustomFontAndStyle(tabLayout1, 0);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout1.addTab(tabLayout1.newTab().setText("Today"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Tommorow"));
        tabLayout1.addTab(tabLayout1.newTab().setText("15"));
        tabLayout1.addTab(tabLayout1.newTab().setText("16"));
        tabLayout1.addTab(tabLayout1.newTab().setText("17"));
        tabLayout1.addTab(tabLayout1.newTab().setText("18"));
        tabLayout1.addTab(tabLayout1.newTab().setText("19"));
        tabLayout1.addTab(tabLayout1.newTab().setText("20"));
        tabLayout1.addTab(tabLayout1.newTab().setText("21"));



//        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
//        ViewGroup vg = (ViewGroup) tabLayout1.getChildAt(0);
//        int tabsCount = vg.getChildCount();
//        for (int j = 0; j < tabsCount; j++) {
//            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
//            int tabChildsCount = vgTab.getChildCount();
//            for (int i = 0; i < tabChildsCount; i++) {
//                View tabViewChild = vgTab.getChildAt(i);
//                if (tabViewChild instanceof TextView) {
//                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
//                }
//            }
//        }

        adapter = new TabtodaytasktodoAdapter(getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);
        viewPager1.setOffscreenPageLimit(3);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
    }


