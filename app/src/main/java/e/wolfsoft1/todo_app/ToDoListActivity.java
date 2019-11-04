package e.wolfsoft1.todo_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.ToDo_ListRecycleAdapter;
import model.KwikListModelClass;

public class ToDoListActivity extends AppCompatActivity {


    private ArrayList<KwikListModelClass> kwikListModelClasses;
    private RecyclerView recyclerView;
    private ToDo_ListRecycleAdapter bAdapter;

    private String txt[]={"1.login_todo","2.signup_todo","3.home_todo","4.add task_todo",
    "5.todays task_todo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ToDoListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        kwikListModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            KwikListModelClass beanClassForRecyclerView_contacts = new KwikListModelClass(txt[i]);
            kwikListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new ToDo_ListRecycleAdapter(ToDoListActivity.this,kwikListModelClasses);
        recyclerView.setAdapter(bAdapter);


    }
}
