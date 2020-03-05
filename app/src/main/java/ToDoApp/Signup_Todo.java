package ToDoApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup_Todo extends AppCompatActivity {
    TextView txtLogin , btnSignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__todo);

        txtLogin = (TextView)findViewById(R.id.txtLogin);
        btnSignup =(TextView)findViewById(R.id.btnSignup);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Signup_Todo.this,ToDo_login_main.class);
                startActivity(i);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Signup_Todo.this,Home_Todo.class);
                startActivity(i);
            }
        });
    }
}
