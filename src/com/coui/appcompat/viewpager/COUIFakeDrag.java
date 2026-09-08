package com.coui.appcompat.viewpager;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class COUIFakeDrag {
    private int mActualDraggedDistance;
    private final COUIScrollEventAdapter mCOUIScrollEventAdapter;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private VelocityTracker mVelocityTracker;
    private final COUIViewPager2 mViewPager;

    public COUIFakeDrag(COUIViewPager2 cOUIViewPager2, COUIScrollEventAdapter cOUIScrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = cOUIViewPager2;
        this.mCOUIScrollEventAdapter = cOUIScrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long j10, int i10, float f10, float f11) {
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, j10, i10, f10, f11, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
            this.mMaximumVelocity = ViewConfiguration.get(this.mViewPager.getContext()).getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
    }

    public boolean beginFakeDrag() {
        if (this.mCOUIScrollEventAdapter.isDragging()) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = 0;
        this.mFakeDragBeginTime = SystemClock.uptimeMillis();
        beginFakeVelocityTracker();
        this.mCOUIScrollEventAdapter.notifyBeginFakeDrag();
        if (!this.mCOUIScrollEventAdapter.isIdle()) {
            this.mRecyclerView.stopScroll();
        }
        addFakeMotionEvent(this.mFakeDragBeginTime, 0, 0.0f, 0.0f);
        return true;
    }

    public boolean endFakeDrag() {
        if (!this.mCOUIScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        this.mCOUIScrollEventAdapter.notifyEndFakeDrag();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        if (!this.mRecyclerView.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            this.mViewPager.snapToPageOpen();
            return true;
        }
        return true;
    }

    public boolean fakeDragBy(float f10) {
        boolean z10;
        int i10;
        float f11;
        int i11 = 0;
        if (!this.mCOUIScrollEventAdapter.isFakeDragging()) {
            return false;
        }
        float f12 = this.mRequestedDragDistance - f10;
        this.mRequestedDragDistance = f12;
        int round = Math.round(f12 - this.mActualDraggedDistance);
        this.mActualDraggedDistance += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.mViewPager.getOrientation() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i10 = round;
        } else {
            i10 = 0;
        }
        if (!z10) {
            i11 = round;
        }
        float f13 = 0.0f;
        if (z10) {
            f11 = this.mRequestedDragDistance;
        } else {
            f11 = 0.0f;
        }
        if (!z10) {
            f13 = this.mRequestedDragDistance;
        }
        float f14 = f13;
        this.mRecyclerView.scrollBy(i10, i11);
        addFakeMotionEvent(uptimeMillis, 2, f11, f14);
        return true;
    }

    public boolean isFakeDragging() {
        return this.mCOUIScrollEventAdapter.isFakeDragging();
    }
}
