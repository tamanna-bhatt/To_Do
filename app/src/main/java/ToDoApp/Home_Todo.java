package ToDoApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

import DataLayer.TodoDatabase;
import adapter.MainRecyclerAdapter;
import az.plainpie.PieView;
import itemtouchhelperextension.ItemTouchHelperExtension;
import model.WorklistModel;
import util.ItemTouchHelperCallback;
import util.UpdateID;

public class Home_Todo extends AppCompatActivity implements UpdateID {

    PieView pieView;

    FloatingActionButton add;
    FrameLayout frameButton;
    CircularProgressBar circularProgressBar;
    TextView isAlive;
    TextView isDone;
    TextView efficiency;
    private  MainRecyclerAdapter mAdapter;
    public ItemTouchHelperExtension mItemTouchHelper;
    public ItemTouchHelperExtension.Callback mCallback;
    private RecyclerView recyclerView;
    private ArrayList<WorklistModel> worklistModelArrayList;
    private TodoDatabase todoDatabase = new TodoDatabase(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__todo);

        add = (FloatingActionButton)findViewById(R.id.add);
        frameButton =(FrameLayout)findViewById(R.id.frameButton);
        efficiency =(TextView)findViewById(R.id.efficiency);

        efficiency.setText(String.valueOf(getEfeciency()) + " % \n" + "Efficiency" );
        //todoDatabase.onUpgrade(todoDatabase.getWritableDatabase(),1,2);
        frameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home_Todo.this , Today_task_todo.class);
                startActivity(i);

            }
        });

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
        circularProgressBar.setProgressWithAnimation(getEfeciency(), animationDuration); // Default duration = 1500ms
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



//



        recyclerView = findViewById(R.id.recycler1);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Home_Todo.this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MainRecyclerAdapter(this);

        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        mAdapter.setItemTouchHelperExtension(mItemTouchHelper);
        setMainAdapter();
        isAlive = (TextView) findViewById(R.id.isAlive);
        isAlive.setText(String.valueOf(this.getisLive(todoDatabase)));
        isDone = (TextView) findViewById(R.id.isDone);
        isDone.setText(String.valueOf(this.getisDone(todoDatabase)));


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

    private void setMainAdapter() {
            ArrayList<WorklistModel> worklistModelArrayList1 = new ArrayList<>();
            try {
                Intent intent = getIntent();
                String actvityName = intent.getStringExtra("activityName");
                String time = intent.getStringExtra("time");
                String date = intent.getStringExtra("date");
                String activityType = intent.getStringExtra("activityType");
                String activityDesc = intent.getStringExtra("activityDesc");
                if(actvityName != null) {
                    WorklistModel wm = new WorklistModel(false,actvityName,time,activityType,activityDesc,date,0,true);
                    todoDatabase.addValues(wm);
                    wm.id = todoDatabase.getId();
                    worklistModelArrayList1 = todoDatabase.getAllDailyActivities();
                }
                else
                {
                    worklistModelArrayList1 = todoDatabase.getAllDailyActivities();
                }
                mAdapter.updateData(worklistModelArrayList1);
                if(worklistModelArrayList1.size() > 0)
                    recyclerView.setAdapter(mAdapter);
            }
            catch(Exception io)
            {
                io.printStackTrace();
            }

    }

    private int getisLive(TodoDatabase td)
    {
        return td.getCountofisLive();
    }

    private int getisDone(TodoDatabase td)
    {
        return td.getCountofisDone();
    }

    @Override
    public void updateDoneCount(int no)
    {
        isDone.setText(String.valueOf(no));
        efficiency.setText(String.valueOf(getEfeciency())+" % \n"+"Efficiency");
    }
    @Override
    public void updateisLiveCount(int no)
    {
        isAlive.setText(String.valueOf(no));
        efficiency.setText(String.valueOf(getEfeciency())+" % \n"+"Efficiency");
    }

    public int getEfeciency(){

        if(getisLive(todoDatabase)+getisDone(todoDatabase) != 0) {
            double val = (double) getisDone(todoDatabase) / (double) (getisLive(todoDatabase) + getisDone(todoDatabase));
            return (int) (val * 100);
        }
        return 0;
    }
}