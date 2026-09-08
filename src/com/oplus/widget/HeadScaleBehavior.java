package com.oplus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes4.dex */
public class HeadScaleBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public int f29276a;

    /* renamed from: b, reason: collision with root package name */
    public int f29277b;

    /* renamed from: c, reason: collision with root package name */
    public AppBarLayout f29278c;

    /* renamed from: d, reason: collision with root package name */
    public View f29279d;

    /* renamed from: e, reason: collision with root package name */
    public View f29280e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29281f;

    /* loaded from: classes4.dex */
    public class a implements View.OnScrollChangeListener {
        public a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            if (HeadScaleBehavior.this.f29281f) {
                HeadScaleBehavior.this.onListScroll();
            }
        }
    }

    public HeadScaleBehavior() {
        this.f29277b = 0;
        this.f29281f = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.f29279d = null;
        View view = this.f29280e;
        int i10 = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i11 = 0;
                while (true) {
                    if (i11 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i11).getVisibility() == 0) {
                        this.f29279d = viewGroup.getChildAt(i11);
                        break;
                    }
                    i11++;
                }
            }
        }
        if (this.f29279d == null) {
            this.f29279d = this.f29280e;
        }
        int[] iArr = new int[2];
        this.f29279d.getLocationOnScreen(iArr);
        int i12 = iArr[1];
        if (i12 < 0) {
            i10 = this.f29277b;
        } else {
            int i13 = this.f29277b;
            if (i12 <= i13) {
                i10 = i13 - i12;
            }
        }
        if (this.f29276a == i10) {
            return;
        }
        this.f29276a = i10;
        Math.abs(i10);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        if (!this.f29281f) {
            return;
        }
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if ((i10 & 2) == 0 || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight() || this.f29277b > 0) {
            return false;
        }
        this.f29277b = appBarLayout.getMeasuredHeight();
        this.f29278c = appBarLayout;
        this.f29280e = view2;
        view2.setOnScrollChangeListener(new a());
        return false;
    }

    public HeadScaleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29277b = 0;
        this.f29281f = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
