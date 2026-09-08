package com.android.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class HeadScaleBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public int f18212a;

    /* renamed from: b, reason: collision with root package name */
    public int f18213b;

    /* renamed from: c, reason: collision with root package name */
    public AppBarLayout f18214c;

    /* renamed from: d, reason: collision with root package name */
    public View f18215d;

    /* renamed from: e, reason: collision with root package name */
    public View f18216e;

    /* renamed from: f, reason: collision with root package name */
    public int f18217f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f18218g;

    /* loaded from: classes.dex */
    public class a implements View.OnScrollChangeListener {
        public a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            HeadScaleBehavior.this.onListScroll();
        }
    }

    public HeadScaleBehavior() {
        this.f18213b = 0;
        this.f18218g = new int[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.f18215d = null;
        View view = this.f18216e;
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
                        this.f18215d = viewGroup.getChildAt(i11);
                        break;
                    }
                    i11++;
                }
            }
        }
        if (this.f18215d == null) {
            this.f18215d = this.f18216e;
        }
        this.f18215d.getLocationOnScreen(this.f18218g);
        int i12 = this.f18218g[1];
        int i13 = this.f18217f;
        if (i12 < i13) {
            i10 = this.f18213b;
        } else {
            int i14 = this.f18213b;
            if (i12 <= i14 + i13) {
                i10 = (i13 + i14) - i12;
            }
        }
        if (this.f18212a == i10) {
            return;
        }
        this.f18212a = i10;
        Math.abs(i10);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
        int[] iArr = new int[2];
        appBarLayout.getLocationOnScreen(iArr);
        int i11 = iArr[1];
        if (this.f18217f != i11) {
            this.f18217f = i11;
            if (this.f18216e != null) {
                onListScroll();
            }
        }
        return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if ((i10 & 2) == 0 || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight() || this.f18213b > 0) {
            return false;
        }
        this.f18213b = appBarLayout.getMeasuredHeight();
        int[] iArr = new int[2];
        appBarLayout.getLocationOnScreen(iArr);
        this.f18217f = iArr[1];
        this.f18214c = appBarLayout;
        this.f18216e = view2;
        view2.setOnScrollChangeListener(new a());
        return false;
    }

    public HeadScaleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18213b = 0;
        this.f18218g = new int[2];
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
