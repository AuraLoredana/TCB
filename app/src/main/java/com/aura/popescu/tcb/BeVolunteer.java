package com.aura.popescu.tcb;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class BeVolunteer extends AppCompatActivity {
    private ImageView mImage1;
    private int mImageHeight1;

    private static void centerViewVertically(View view) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                v.setTranslationY(-v.getHeight() / 2);
                v.removeOnLayoutChangeListener(this);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_volunteer);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mImage1 = findViewById(R.id.image1);
        mImageHeight1 = mImage1.getLayoutParams().height;

        ((TrackingScrollViewVol) findViewById(R.id.scroller)).setOnScrollChangedListener(
                new TrackingScrollViewVol.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged(TrackingScrollViewVol source, int l, int t, int oldl, int oldt) {
                        handleScroll(source, t);
                    }
                }
        );

        Button btnvoladulti = findViewById(R.id.btnvoladulti);
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

        Button btnvolminori = findViewById(R.id.btnvolminori);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void handleScroll(TrackingScrollViewVol source, int top) {
        int scrolledImageHeight = Math.min(mImageHeight1, Math.max(0, top));

        ViewGroup.MarginLayoutParams imageParams = (ViewGroup.MarginLayoutParams) mImage1.getLayoutParams();
        int newImageHeight = mImageHeight1 - scrolledImageHeight;
        if (imageParams.height != newImageHeight) {
            // Transfer image height to margin top
            imageParams.height = newImageHeight;
            imageParams.topMargin = scrolledImageHeight;

            // Invalidate view
            mImage1.setLayoutParams(imageParams);
        }
    }

}

