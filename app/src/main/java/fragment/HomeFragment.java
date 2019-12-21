package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;
import java.util.List;

import e.wolfsoft1.todo_app.R;


public class HomeFragment extends Fragment {
    Spinner sp_car_name1;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home_fragment, container, false);


        CircularProgressBar circularProgressBar = (CircularProgressBar) view.findViewById(R.id.circle_progress);
        circularProgressBar.setColor(ContextCompat.getColor(getContext(), R.color.progressBarColor));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.progresscolor));
        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(70, animationDuration);

        sp_car_name1 = view.findViewById(R.id.sp_car_name1);
        //        sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);
//
        List<String> list = new ArrayList<String>();
        list.add("Weekly ");
        list.add("Monthly ");
        list.add("Yearly");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner, R.id.spinner_text, list);
        sp_car_name1.setAdapter(dataAdapter);

        return view;
    }
}

