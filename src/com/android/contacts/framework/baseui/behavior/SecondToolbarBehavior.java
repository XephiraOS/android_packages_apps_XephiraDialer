package com.android.contacts.framework.baseui.behavior;

import N0.f;
import N0.i;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f15720a;

    /* renamed from: b, reason: collision with root package name */
    public int f15721b;

    /* renamed from: c, reason: collision with root package name */
    public View f15722c;

    /* renamed from: d, reason: collision with root package name */
    public View f15723d;

    /* renamed from: e, reason: collision with root package name */
    public View f15724e;

    /* renamed from: f, reason: collision with root package name */
    public int f15725f;

    /* renamed from: g, reason: collision with root package name */
    public int f15726g;

    /* renamed from: h, reason: collision with root package name */
    public int f15727h;

    /* renamed from: i, reason: collision with root package name */
    public int f15728i;

    /* renamed from: j, reason: collision with root package name */
    public int f15729j;

    /* renamed from: k, reason: collision with root package name */
    public int f15730k;

    /* renamed from: l, reason: collision with root package name */
    public int f15731l;

    /* renamed from: m, reason: collision with root package name */
    public float f15732m;

    /* renamed from: n, reason: collision with root package name */
    public Resources f15733n;

    /* renamed from: o, reason: collision with root package name */
    public Context f15734o;

    /* renamed from: p, reason: collision with root package name */
    public int f15735p;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SecondToolbarBehavior.this.onListScroll();
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnScrollChangeListener {
        public b() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            SecondToolbarBehavior.this.onListScroll();
        }
    }

    public SecondToolbarBehavior() {
        this.f15720a = new int[2];
    }

    private int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return context.getResources().getDimensionPixelOffset(f.f1884j);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.f15733n = resources;
        this.f15725f = resources.getDimensionPixelOffset(f.f1886l) * 2;
        this.f15728i = this.f15733n.getDimensionPixelOffset(f.f1895u);
        this.f15731l = this.f15733n.getDimensionPixelOffset(f.f1888n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        int i10;
        View view = this.f15723d;
        if (view == null) {
            return;
        }
        this.f15724e = null;
        int i11 = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i12 = 0;
                while (true) {
                    if (i12 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i12).getVisibility() == 0) {
                        this.f15724e = viewGroup.getChildAt(i12);
                        break;
                    }
                    i12++;
                }
            }
        }
        if (this.f15724e == null) {
            this.f15724e = this.f15723d;
        }
        this.f15724e.getLocationInWindow(this.f15720a);
        int i13 = this.f15720a[1];
        if (i13 < this.f15727h) {
            i10 = this.f15728i;
        } else {
            int i14 = this.f15726g;
            if (i13 > i14) {
                i10 = 0;
            } else {
                i10 = i14 - i13;
            }
        }
        if (this.f15732m <= 1.0f) {
            float abs = Math.abs(i10) / this.f15728i;
            this.f15732m = abs;
            this.f15722c.setAlpha(abs);
        }
        if (i13 < this.f15729j) {
            i11 = this.f15731l;
        } else {
            int i15 = this.f15730k;
            if (i13 <= i15) {
                i11 = i15 - i13;
            }
        }
        ViewGroup.LayoutParams layoutParams = this.f15722c.getLayoutParams();
        layoutParams.width = (int) (this.f15721b + (this.f15725f * (Math.abs(i11) / this.f15731l)));
        this.f15722c.setLayoutParams(layoutParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i10) {
        if (this.f15735p != appBarLayout.getMeasuredWidth()) {
            int measuredWidth = appBarLayout.getMeasuredWidth();
            this.f15735p = measuredWidth;
            this.f15721b = measuredWidth - this.f15725f;
            View view = this.f15723d;
            if (view != null) {
                view.post(new a());
            }
        }
        return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) appBarLayout, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if ((i10 & 2) == 0 || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight()) {
            return false;
        }
        if (this.f15726g <= 0) {
            this.f15726g = appBarLayout.getMeasuredHeight() + b(this.f15734o);
            this.f15723d = view2;
            View findViewById = appBarLayout.findViewById(i.f1936n);
            this.f15722c = findViewById;
            this.f15721b = findViewById.getWidth();
            int i12 = this.f15726g;
            this.f15727h = i12 - this.f15728i;
            int dimensionPixelOffset = i12 - this.f15733n.getDimensionPixelOffset(f.f1889o);
            this.f15730k = dimensionPixelOffset;
            this.f15729j = dimensionPixelOffset - this.f15731l;
        }
        view2.setOnScrollChangeListener(new b());
        return false;
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15720a = new int[2];
        init(context);
        this.f15734o = context;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
