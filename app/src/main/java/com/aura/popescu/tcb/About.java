package com.aura.popescu.tcb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class About extends AppCompatActivity {
    private ImageView mImage;
    private int mImageHeight;

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
        setContentView(R.layout.activity_about);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mImage = findViewById(R.id.image);
        mImageHeight = mImage.getLayoutParams().height;

        ((TrackingScrollView) findViewById(R.id.scroller)).setOnScrollChangedListener(
                new TrackingScrollView.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged(TrackingScrollView source, int l, int t, int oldl, int oldt) {
                        handleScroll(source, t);
                    }
                }
        );

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
    private void handleScroll(TrackingScrollView source, int top) {
        int scrolledImageHeight = Math.min(mImageHeight, Math.max(0, top));

        ViewGroup.MarginLayoutParams imageParams = (ViewGroup.MarginLayoutParams) mImage.getLayoutParams();
        int newImageHeight = mImageHeight - scrolledImageHeight;
        if (imageParams.height != newImageHeight) {
            // Transfer image height to margin top
            imageParams.height = newImageHeight;
            imageParams.topMargin = scrolledImageHeight;

            // Invalidate view
            mImage.setLayoutParams(imageParams);
        }
    }

}