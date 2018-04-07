package com.rahulkumar.soccerinfo.utilty;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by rahulkumar on 4/5/18.
 */

public class DynamicImage extends android.support.v7.widget.AppCompatImageView {
    private float mAspectRatio = 1.5f;

    public DynamicImage(Context context) {
        super(context);
    }

    public DynamicImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (measuredWidth / mAspectRatio));
    }
}

