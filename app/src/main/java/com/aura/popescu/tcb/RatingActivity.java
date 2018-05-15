package com.aura.popescu.tcb;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {
    private RatingBar rBar;
    private TextView tView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rBar = findViewById(R.id.ratingBar1);
        tView = findViewById(R.id.textview1);
        btn = findViewById(R.id.btnGet);
        btn.setOnClickListener(new View.OnClickListener() {
            boolean visible;

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                int noofstars = rBar.getNumStars();
                float getrating = rBar.getRating();
                tView.setText("Rating: " + getrating + "/" + noofstars);
            }

        });
    }
}