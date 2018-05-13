package com.aura.popescu.tcb;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Locale myLocale;
    String currentLanguage = "ro", currentLang;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLanguage = getIntent().getStringExtra(currentLang);

        spinner = findViewById(R.id.spinner1);

        List<String> list = new ArrayList<String>();
        //list.add(String.valueOf(getDrawable(R.drawable.flag_ro)));
        //list.add(String.valueOf(getDrawable(R.drawable.flag_us))) ;
        list.add("Lang");
        list.add("Romanian");
        list.add("English");


        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.about:
                        Toast.makeText(MainActivity.this, R.string.despre_noi, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, About.class));
                        break;
                    case R.id.candy:
                        Toast.makeText(MainActivity.this, R.string.proiectele_noastre, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Projects.class));
                        break;
                    case R.id.voluntar:
                        Toast.makeText(MainActivity.this, R.string.devino_voluntar, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, BeVolunteer.class));
                        break;
                    case R.id.doneaza:
                        Toast.makeText(MainActivity.this, R.string.doneazahomepage, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Donate.class));
                        break;
                    case R.id.chat:
                        Toast.makeText(MainActivity.this, R.string.chat, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ChatWithUs.class));
                        break;
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, R.string.contact, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Contact.class));
                    default:
                        return true;
                }
                return true;
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        setLocale("ro");
                        //getDrawable(R.drawable.flag_ro);
                        break;
                    case 2:
                        setLocale("en");
                        //getDrawable(R.drawable.flag_us);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, MainActivity.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            Toast.makeText(MainActivity.this, "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);


    }

}

