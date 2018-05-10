package com.aura.popescu.tcb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.about:
                        Toast.makeText(MainActivity.this, "About us", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, About.class));
                        break;
                    case R.id.candy:
                        Toast.makeText(MainActivity.this, "Our projects", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Projects.class));
                        break;
                    case R.id.voluntar:
                        Toast.makeText(MainActivity.this, "Become a volunteer", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, BeVolunteer.class));
                        break;
                    case R.id.doneaza:
                        Toast.makeText(MainActivity.this, "Donate", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Donate.class));
                        break;
                    case R.id.chat:
                        Toast.makeText(MainActivity.this, "Chat", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ChatWithUs.class));
                        break;
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Contact.class));
                    default:
                        return true;
                }
                return true;
            }
        });


    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}

