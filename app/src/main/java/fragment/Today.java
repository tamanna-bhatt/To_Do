package fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapter.TabtodaytasktodoAdapter;
import adapter.TodaytaskAdapter;
import e.wolfsoft1.todo_app.R;
import model.TodotodaytaskModel;

public class Today extends Fragment{

    String[] todotext = {"9.30 AM","1.00 PM","4.30 PM","7.00 AM"};
    String[] todotext2 = {"Project meeting","Doctor appointment","Give project update to client","Continue with online course"};
    String[] todotextt3 = {"9.30 — 10.30 AM","1.00 — 1.30 PM","4.30 — 4.45 PM","7.00 — 8.30 PM"};
    String[] todotext4 = {"Mauris non tempor quam, et lacinia sapien. Mauris accumsan eros eget libero posuere vulputate. Etiam elit elit, elementum sed varius at…","Mauris non tempor quam, et lacinia sapien. Mauris accumsan eros.","Mauris non tempor quam, et lacinia sapien. ","Mauris non tempor quam, et lacinia sapien. Mauris accumsan eros eget libero posuere vulputate."};
    String[] todotext5 = {"Work","Health","Work","Personal"};

    Integer[] todoimg = {R.drawable.todaytaskorange_ract,R.drawable.todaytaskblue_ract,R.drawable.todaytaskorange_ract,R.drawable.todaytaskpurple_ract};
   // int[] radio = {R.drawable.todaytaskorange_ract,R.drawable.todaytaskblue_ract,R.drawable.todaytaskorange_ract,R.drawable.todaytaskpurple_ract};
   Integer[] todoimg2 = {R.drawable.ic_circle_orange,R.drawable.ic_circle_blue,R.drawable.ic_circle_orange,R.drawable.ic_circle_purple};


    private TodaytaskAdapter homepageAdapter;
    private RecyclerView recyclerview;
    private ArrayList<TodotodaytaskModel> todotodaytaskModelArrayList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.todo_recyclerview_todaytask, container, false);

        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        todotodaytaskModelArrayList = new ArrayList<>();


        for (int i = 0; i < todotext.length; i++) {
            TodotodaytaskModel view1 = new TodotodaytaskModel(todotext[i], todotext2[i], todotextt3[i], todotext4[i],todotext5[i],todoimg[i],todoimg2[i]);
            todotodaytaskModelArrayList.add(view1);
        }
        homepageAdapter = new TodaytaskAdapter(getActivity(), todotodaytaskModelArrayList);
        recyclerview.setAdapter(homepageAdapter);

        return view;
    }
}
