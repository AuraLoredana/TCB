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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Locale myLocale;
    String currentLanguage = "ro", currentLang;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = new TextView(MainActivity.this);

        currentLanguage = getIntent().getStringExtra(currentLang);

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
                        break;
                    case R.id.rate:
                        Toast.makeText(MainActivity.this, R.string.rate_us, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, RatingActivity.class));
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, R.string.share, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, ShareActivity.class));
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
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
        });*/
    }


    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.select:

                return true;
            case R.id.us:
                setLocale("en");
                Locale locale = new Locale("en");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in English !", Toast.LENGTH_LONG).show();
                break;
            case R.id.rom:
                setLocale("ro");
                Locale locale1 = new Locale("ro");
                Locale.setDefault(locale1);
                Configuration config1 = new Configuration();
                config1.locale = locale1;
                getBaseContext().getResources().updateConfiguration(config1, getBaseContext().getResources().getDisplayMetrics());
                Toast.makeText(this, "Locale in Romanian !", Toast.LENGTH_LONG).show();
            default:
                // Do nothing.
        }

        return true;


    }


}

