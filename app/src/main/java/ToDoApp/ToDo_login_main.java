package ToDoApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ToDo_login_main extends AppCompatActivity {

    TextView txtCreateOne , btnLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_login_main);

        txtCreateOne = (TextView)findViewById(R.id.txtCreateOne);
        btnLogin =(TextView)findViewById(R.id.btnLogin);

        txtCreateOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(ToDo_login_main.this ,Signup_Todo.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ToDo_login_main.this,Home_Todo.class);
                startActivity(intent);
            }
        });


    }
}
