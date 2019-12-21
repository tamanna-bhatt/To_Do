package e.wolfsoft1.todo_app;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;
import java.util.List;

import az.plainpie.PieView;

public class Home_Todo extends AppCompatActivity {

    PieView pieView;
    Spinner sp_car_name1;
    CircularProgressBar circularProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__todo);

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


    }
}
