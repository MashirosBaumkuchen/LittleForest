package com.jascal.clare.behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.jascal.clare.R;

public class HeaderImageBehavior extends CoordinatorLayout.Behavior {

    private float distanceY;

    public HeaderImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeadBehavior);
        distanceY = a.getDimensionPixelOffset(R.styleable.HeadBehavior_openHeight,dip2px(context,250))//750
        -a.getDimension(R.styleable.HeadBehavior_closeHeight,dip2px(context,56));//168
        a.recycle();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float p = Math.abs(dependency.getY())*1f/distanceY;
        child.setScaleX(1- p/2);
        child.setScaleY(1- p/2);
        child.setTranslationX(-child.getLeft()*p);
        return true;
    }

    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}