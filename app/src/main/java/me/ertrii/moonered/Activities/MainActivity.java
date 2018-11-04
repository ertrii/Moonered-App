package me.ertrii.moonered.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import me.ertrii.moonered.R;

public class MainActivity extends AppCompatActivity {

    Button btnSession;
    TextView txtNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSession =  findViewById(R.id.btnSession);
        txtNotice = findViewById(R.id.txtNotice);

        btnSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNotice.setText("This is a notice");
            }
        });
    }
}
