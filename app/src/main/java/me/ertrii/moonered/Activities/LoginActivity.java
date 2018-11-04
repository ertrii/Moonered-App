package me.ertrii.moonered.Activities;

import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import me.ertrii.moonered.R;

public class LoginActivity extends AppCompatActivity {

    TextView txtUser, txtPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //sessions
        SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", "erick");
        editor.putString("password", "123456");
        editor.commit();//create commit.

        //UI
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPassword);


        btnLogin = findViewById(R.id.btnSession);

        //Events
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUser.getText().toString();
                String pass = txtPass.getText().toString();

                SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                if(user.equals(preferences.getString("username", "x")) && pass.equals(preferences.getString("password", "x"))){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText (LoginActivity.this, "Error username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
