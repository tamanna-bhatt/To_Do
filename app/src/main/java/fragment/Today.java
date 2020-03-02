package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import DataLayer.TodoDatabase;
import adapter.TabtodaytasktodoAdapter;
import adapter.TodaytaskAdapter;
import e.wolfsoft1.todo_app.R;
import model.TodotodaytaskModel;
import model.WorklistModel;

public class Today extends Fragment{

    int position = 0;


   // Integer[] todoimg = {R.drawable.todaytaskorange_ract,R.drawable.todaytaskblue_ract,R.drawable.todaytaskorange_ract,R.drawable.todaytaskpurple_ract};
   // int[] radio = {R.drawable.todaytaskorange_ract,R.drawable.todaytaskblue_ract,R.drawable.todaytaskorange_ract,R.drawable.todaytaskpurple_ract};
  // Integer[] todoimg2 = {R.drawable.ic_circle_orange,R.drawable.ic_circle_blue,R.drawable.ic_circle_orange,R.drawable.ic_circle_purple};


    private TodaytaskAdapter homepageAdapter;
    private RecyclerView recyclerview;
    private ArrayList<WorklistModel> todotodaytaskModelArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_recyclerview_todaytask, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        position = this.getArguments().getInt("position");
        String date = showDate(position);
        Log.i("date: ",date);
        TodoDatabase todoDatabase = new TodoDatabase(getActivity());
        todotodaytaskModelArrayList = todoDatabase.getdayActivities(date);
        Log.i("Fragment: " + String.valueOf(position),String.valueOf(position));

        /*for (int i = 0; i < todotext.length; i++) {
            TodotodaytaskModel view1 = new TodotodaytaskModel(todotext[i], todotext2[i], todotextt3[i], todotext4[i],todotext5[i],todoimg[i],todoimg2[i]);
            todotodaytaskModelArrayList.add(view1);
        }
        */
        homepageAdapter = new TodaytaskAdapter(getActivity(), todotodaytaskModelArrayList);
        recyclerview.setAdapter(homepageAdapter);

        return view;
    }

    public String showDate(int position) {
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,position); //minus number would decrement the days
        String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String month = String.valueOf(cal.get(Calendar.MONTH)+1);
        String year  = String.valueOf(cal.get(Calendar.YEAR));
        Log.i("showDate: ",month);
        return (month + "/" + day +"/"+year);
    }
}
