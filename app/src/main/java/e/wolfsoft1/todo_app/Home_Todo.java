package e.wolfsoft1.todo_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;
import java.util.List;

import adapter.MainRecyclerAdapter;
import az.plainpie.PieView;
import itemtouchhelperextension.ItemTouchHelperExtension;
import model.WorklistModel;
import util.ItemTouchHelperCallback;

import static java.security.AccessController.getContext;

public class Home_Todo extends AppCompatActivity {

    PieView pieView;
    Spinner sp_car_name1;
    FloatingActionButton add;
    CircularProgressBar circularProgressBar;
    private MainRecyclerAdapter mAdapter;
    public ItemTouchHelperExtension mItemTouchHelper;
    public ItemTouchHelperExtension.Callback mCallback;
    private RecyclerView recyclerView;
    private ArrayList<WorklistModel> worklistModelArrayList;

    String txtfishing[]={"Go fishing with Stephen","Meet according with design team..",
            "Go fishing with Stephen"};

    String time[]={"9:00am","9:00am","9:00am"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__todo);
        add = (FloatingActionButton)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home_Todo.this , Add_Task_Todo.class);
                startActivity(i);

            }
        });



        //        PieView pieView = (PieView) findViewById(R.id.circle_progress);
//        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.white));
//        pieView.setInnerText("70%\nEfficancy");
//
//        pieView.setPieInnerPadding(20);
//
//        // Update the visibility of the widget text
//        pieView.setInnerTextVisibility(View.VISIBLE);

// Change the text of the widget
//        pieView.setInnerText("A");
//
// Change the text size of the widget
//        pieView.setPercentageTextSize(15);


        CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.circle_progress);
        circularProgressBar.setColor(ContextCompat.getColor(this, R.color.progressBarColor));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(this, R.color.progresscolor));
//        circularProgressBar.setProgressBarWidth(getResources().getDimension(R.dimen.progressBarWidth));
//        circularProgressBar.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.backgroundProgressBarWidth));
        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(70, animationDuration); // Default duration = 1500ms
//
//        PieView animatedPie = (PieView) findViewById(R.id.animated_pie_view_1);
//
//        PieAngleAnimation animation = new PieAngleAnimation(animatedPie);
//        animation.setDuration(5000); //This is the duration of the animation in millis
//        animatedPie.startAnimation(animation);

//        PieView pieView1 = (PieView) findViewById(R.id.pieView);
//
//// Change the color fill of the bar representing the current percentage
//        pieView.setPercentageBackgroundColor(getResources().getColor(R.color.customColor1));
//
//// Change the color fill of the background of the widget, by default is transparent
//        pieView.setMainBackgroundColor(getResources().getColor(R.color.customColor5));
//
//// Change the color of the text of the widget
//        pieView.setTextColor(getResources().getColor(R.color.customColor12));


        sp_car_name1 = findViewById(R.id.sp_car_name1);
//        sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);
//
        List<String> list = new ArrayList<String>();
        list.add("Weekly ");
        list.add("Monthly ");
        list.add("Yearly");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Home_Todo.this, R.layout.spinner, R.id.spinner_text, list);
        sp_car_name1.setAdapter(dataAdapter);

        recyclerView = findViewById(R.id.recycler1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home_Todo.this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MainRecyclerAdapter(Home_Todo.this);

        recyclerView.setAdapter(mAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext()));
        mAdapter.updateData(createTestDatas());
        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        mAdapter.setItemTouchHelperExtension(mItemTouchHelper);
        worklistModelArrayList = new ArrayList<>();




        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                worklistModelArrayList.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);



    }

    private List<WorklistModel> createTestDatas() {
        List<WorklistModel> worklistModelArrayList = new ArrayList<>();
        for (int i = 0; i < txtfishing.length; i++) {
            WorklistModel testModel;

            testModel = new WorklistModel(i, txtfishing[i], time[i]);
            worklistModelArrayList.add(testModel);

        }
        return worklistModelArrayList;
    }

}
