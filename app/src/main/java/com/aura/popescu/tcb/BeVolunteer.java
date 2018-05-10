package com.aura.popescu.tcb;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeVolunteer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_volunteer);

        Button btnvoladulti = (Button)findViewById(R.id.btnvoladulti);
        btnvoladulti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://taxiulcubomboane.ro/wp-content/uploads/2017/12/TcB-Pachet-Voluntari-Adulti.zip";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        Button btnvolminori = (Button)findViewById(R.id.btnvolminori);
        btnvolminori.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String url = "https://taxiulcubomboane.ro/wp-content/uploads/2017/12/TcB-Pachet-Voluntari-Minori.zip";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
