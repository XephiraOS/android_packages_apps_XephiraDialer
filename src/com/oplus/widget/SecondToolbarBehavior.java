package com.oplus.widget;

import C6.f;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.blacklistapp.p;

/* loaded from: classes4.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public View f29297a;

    /* renamed from: b, reason: collision with root package name */
    public View f29298b;

    /* renamed from: c, reason: collision with root package name */
    public View f29299c;

    /* renamed from: d, reason: collision with root package name */
    public int f29300d;

    /* renamed from: e, reason: collision with root package name */
    public int f29301e;

    /* renamed from: f, reason: collision with root package name */
    public int f29302f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f29303g;

    /* renamed from: h, reason: collision with root package name */
    public int f29304h;

    /* renamed from: i, reason: collision with root package name */
    public ViewGroup.LayoutParams f29305i;

    /* renamed from: j, reason: collision with root package name */
    public int f29306j;

    /* renamed from: k, reason: collision with root package name */
    public int f29307k;

    /* renamed from: l, reason: collision with root package name */
    public int f29308l;

    /* renamed from: m, reason: collision with root package name */
    public int f29309m;

    /* renamed from: n, reason: collision with root package name */
    public int f29310n;

    /* renamed from: o, reason: collision with root package name */
    public int f29311o;

    /* renamed from: p, reason: collision with root package name */
    public int f29312p;

    /* renamed from: q, reason: collision with root package name */
    public float f29313q;

    /* renamed from: r, reason: collision with root package name */
    public float f29314r;

    /* renamed from: x, reason: collision with root package name */
    public Resources f29315x;

    /* renamed from: y, reason: collision with root package name */
    public int f29316y;

    /* loaded from: classes4.dex */
    public class a implements View.OnScrollChangeListener {
        public a() {
        }

        @Override // android.view.View.OnScrollChangeListener
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            SecondToolbarBehavior.this.onListScroll();
        }
    }

    public SecondToolbarBehavior() {
        this.f29303g = new int[2];
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.f29315x = resources;
        this.f29306j = resources.getDimensionPixelOffset(f.f388b) * 2;
        this.f29309m = this.f29315x.getDimensionPixelOffset(f.f391e);
        this.f29312p = this.f29315x.getDimensionPixelOffset(f.f389c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.f29299c = null;
        View view = this.f29298b;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i10 = 0;
                while (true) {
                    if (i10 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i10).getVisibility() == 0) {
                        this.f29299c = viewGroup.getChildAt(i10);
                        break;
                    }
                    i10++;
                }
            }
        }
        if (this.f29299c == null) {
            this.f29299c = this.f29298b;
        }
        this.f29299c.getLocationOnScreen(this.f29303g);
        int i11 = this.f29303g[1];
        this.f29300d = i11;
        this.f29301e = 0;
        if (i11 < this.f29308l) {
            this.f29301e = this.f29309m;
        } else {
            int i12 = this.f29307k;
            if (i11 > i12) {
                this.f29301e = 0;
            } else {
                this.f29301e = i12 - i11;
            }
        }
        this.f29302f = this.f29301e;
        if (this.f29313q <= 1.0f) {
            float abs = Math.abs(r0) / this.f29309m;
            this.f29313q = abs;
            this.f29297a.setAlpha(abs);
        }
        int i13 = this.f29300d;
        if (i13 < this.f29310n) {
            this.f29301e = this.f29312p;
        } else {
            int i14 = this.f29311o;
            if (i13 > i14) {
                this.f29301e = 0;
            } else {
                this.f29301e = i14 - i13;
            }
        }
        this.f29302f = this.f29301e;
        float abs2 = Math.abs(r0) / this.f29312p;
        this.f29314r = abs2;
        ViewGroup.LayoutParams layoutParams = this.f29305i;
        layoutParams.width = (int) (this.f29316y + (this.f29306j * abs2));
        this.f29297a.setLayoutParams(layoutParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        onListScroll();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i10, int i11) {
        if ((i10 & 2) == 0 || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight()) {
            return false;
        }
        if (this.f29307k <= 0) {
            this.f29307k = appBarLayout.getMeasuredHeight();
            this.f29298b = view2;
            View findViewById = appBarLayout.findViewById(p.f27386f);
            this.f29297a = findViewById;
            this.f29316y = findViewById.getWidth();
            this.f29305i = this.f29297a.getLayoutParams();
            this.f29304h = appBarLayout.getMeasuredWidth();
            int i12 = this.f29307k;
            this.f29308l = i12 - this.f29309m;
            int dimensionPixelOffset = i12 - this.f29315x.getDimensionPixelOffset(f.f390d);
            this.f29311o = dimensionPixelOffset;
            this.f29310n = dimensionPixelOffset - this.f29312p;
        }
        view2.setOnScrollChangeListener(new a());
        return false;
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f29303g = new int[2];
        init(context);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
