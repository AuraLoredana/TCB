package com.aura.popescu.tcb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by POPESCU on 5/14/2018.
 */


public class TrackingScrollView extends ScrollView {
    private OnScrollChangedListener mOnScrollChangedListener;

    public TrackingScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrackingScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        mOnScrollChangedListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (mOnScrollChangedListener != null) {
            mOnScrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
        }
    }

    public interface OnScrollChangedListener {
        void onScrollChanged(TrackingScrollView source, int l, int t, int oldl, int oldt);
    }
}