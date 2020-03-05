package ToDoApp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import adapter.TabtodaytasktodoAdapter;

public class Today_task_todo extends AppCompatActivity {


    ViewPager viewPager1;
    TabLayout tabLayout1;
    TabtodaytasktodoAdapter adapter;
    Calendar calendar;
    int month_int;
    String month,day,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_task_todo);
        calendar = Calendar.getInstance();
        day = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)) ;
        Date date1=new Date(System.currentTimeMillis());
        Log.e("date1",date1.toString());

        month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
        year =Integer.toString(calendar.get(Calendar.YEAR));
        month_int= calendar.get(Calendar.MONTH);

        tabLayout1 = findViewById(R.id.tablayout1);

        viewPager1 = findViewById(R.id.viewpager1);

//        setCustomFontAndStyle(tabLayout1, 0);
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);


        tabLayout1.addTab(tabLayout1.newTab().setText("Today"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Tomorrow"));
        tabLayout1.addTab(tabLayout1.newTab().setText(String.valueOf(NextDay(date1,2))));
        tabLayout1.addTab(tabLayout1.newTab().setText(String.valueOf(NextDay(date1,3))));
        tabLayout1.addTab(tabLayout1.newTab().setText(String.valueOf(NextDay(date1,4))));





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
        viewPager1.setOffscreenPageLimit(4);
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Today_task_todo.this,Home_Todo.class);
        startActivity(intent);
    }


    public String NextDay(Date date , Integer no)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, no); //minus number would decrement the days
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
       String month1 = cal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
        return (day + " " + month1);

    }


    /*private String showDate(int year, int day,int month) {

        StringBuilder sb = new StringBuilder();
        return (sb.append(month_int).append("/")
                .append(day).append("/").append(year)).toString();
    }*/
    }


