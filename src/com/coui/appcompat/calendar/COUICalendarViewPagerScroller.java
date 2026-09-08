package com.coui.appcompat.calendar;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.coui.appcompat.animation.COUIMoveEaseInterpolator;

/* loaded from: classes.dex */
public class COUICalendarViewPagerScroller extends Scroller {
    private static final Interpolator ANIM_INTERPOLATOR = new COUIMoveEaseInterpolator();
    private int mDuration;

    public COUICalendarViewPagerScroller(Context context) {
        this(context, ANIM_INTERPOLATOR);
    }

    public int getmDuration() {
        return this.mDuration;
    }

    public void setmDuration(int i10) {
        this.mDuration = i10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }

    public COUICalendarViewPagerScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = 300;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, this.mDuration);
    }
}
