package com.oplus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes4.dex */
public class BlacklistViewPager extends RtlViewPager {

    /* renamed from: d, reason: collision with root package name */
    public boolean f29219d;

    public BlacklistViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29219d = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f29219d) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f29219d) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCanScrolling(boolean z10) {
        this.f29219d = z10;
    }
}
