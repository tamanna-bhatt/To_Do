package e.wolfsoft1.todo_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import model.WorklistModel;

public class Add_Task_Todo extends AppCompatActivity {
    Button btnScheduleTask;
    EditText edtActivityinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task__todo);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        btnScheduleTask = (Button)findViewById(R.id.btnScheduleTask);
        edtActivityinfo =(EditText)findViewById(R.id.edtActivityinfo);

        btnScheduleTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Add_Task_Todo.this ,Home_Todo.class);
                i.putExtra("a",edtActivityinfo.getText().toString());
                i.putExtra("t","xyz");
                startActivity(i);
            }
        });

    }
}
