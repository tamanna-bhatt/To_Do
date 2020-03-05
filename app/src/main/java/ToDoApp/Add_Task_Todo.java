package ToDoApp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Add_Task_Todo extends AppCompatActivity {

    DatePicker datePicker;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    Button btnScheduleTask;
    TextView date , time;
    RadioGroup activityType;
    RadioButton activitySelected;
    int day,month,year,currentHour,currentMinute;
    EditText edtActivityinfo , activityDesc;
    String amPm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task__todo);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        btnScheduleTask = (Button)findViewById(R.id.btnScheduleTask);
        edtActivityinfo =(EditText)findViewById(R.id.edtActivityinfo);
        date =(TextView) findViewById(R.id.date);
        time =(TextView) findViewById(R.id.time);
        activityType=(RadioGroup)findViewById(R.id.activityType);
        activityDesc=(EditText)findViewById(R.id.activityDesc);

        calendar = Calendar.getInstance();
        year =calendar.get(Calendar.YEAR);
        month= calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        showDate(year, day,month+1);
        time.setText(Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + Integer.toString(calendar.get(Calendar.MINUTE))  + amPm(calendar.get(Calendar.HOUR_OF_DAY)));


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                timePickerDialog = new TimePickerDialog(Add_Task_Todo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        time.setText(String.format("%02d:%02d", hourOfDay, minutes) +  amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();


            }
        });


        btnScheduleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (activityType.getCheckedRadioButtonId() == -1)
                {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Add_Task_Todo.this);
                    alertDialog.setTitle("Alert !");
                    alertDialog.setMessage("Please Select Activity Type ");

                    alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });
                    AlertDialog dialog = alertDialog.create();
                    dialog.show();

                }
                else
                {
                    int selectedId=activityType.getCheckedRadioButtonId();
                    activitySelected=(RadioButton)findViewById(selectedId);
                    //Toast.makeText(Add_Task_Todo.this,activitySelected.getText(),Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Add_Task_Todo.this ,Home_Todo.class);
                    i.putExtra("activityName",edtActivityinfo.getText().toString());
                    i.putExtra("time",time.getText().toString());
                    i.putExtra("date",date.getText().toString());
                    i.putExtra("activityType",activitySelected.getText().toString());
                    i.putExtra("activityDesc",activityDesc.getText().toString());
                    startActivity(i);// one of the radio buttons is checked
                }




            }
        });

    }
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), " ",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg3,arg2+1 );
                }
            };
    private void showDate(int year, int day,int month) {
        date.setText(new StringBuilder().append(month).append("/")
                .append(day).append("/").append(year));
    }
    private String amPm( int currentHour){
        if (currentHour >= 12) {
            amPm = "PM";
        } else {
            amPm = "AM";
        }
        return amPm;


    }
}
