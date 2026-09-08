package com.android.contacts.framework.baseui.behavior;

import H7.a;
import N0.f;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.framework.baseui.behavior.SmallTabBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.i;

/* compiled from: SmallTabBehavior.kt */
/* loaded from: classes.dex */
public final class SmallTabBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f15738a;

    /* renamed from: b, reason: collision with root package name */
    public int f15739b;

    /* renamed from: c, reason: collision with root package name */
    public View f15740c;

    /* renamed from: d, reason: collision with root package name */
    public View f15741d;

    /* renamed from: e, reason: collision with root package name */
    public View f15742e;

    /* renamed from: f, reason: collision with root package name */
    public int f15743f;

    /* renamed from: g, reason: collision with root package name */
    public int f15744g;

    /* renamed from: h, reason: collision with root package name */
    public int f15745h;

    /* renamed from: i, reason: collision with root package name */
    public int f15746i;

    /* renamed from: j, reason: collision with root package name */
    public int f15747j;

    /* renamed from: k, reason: collision with root package name */
    public int f15748k;

    /* renamed from: l, reason: collision with root package name */
    public int f15749l;

    /* renamed from: m, reason: collision with root package name */
    public int f15750m;

    /* renamed from: n, reason: collision with root package name */
    public float f15751n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15752o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f15753p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmallTabBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f15738a = new int[2];
        this.f15752o = true;
        Resources resources = context.getResources();
        this.f15743f = resources.getDimensionPixelOffset(f.f1886l) * 2;
        this.f15746i = resources.getDimensionPixelOffset(f.f1895u);
        this.f15749l = resources.getDimensionPixelOffset(f.f1888n);
        this.f15750m = resources.getDimensionPixelOffset(f.f1889o);
    }

    public static final void b(SmallTabBehavior this$0, View view, int i10, int i11, int i12, int i13) {
        i.f(this$0, "this$0");
        this$0.onListScroll();
    }

    private final void onListScroll() {
        View view;
        int i10;
        if (!this.f15752o || (view = this.f15741d) == null) {
            return;
        }
        this.f15742e = null;
        int i11 = 0;
        if (view instanceof ViewGroup) {
            i.d(view, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int childCount = viewGroup.getChildCount();
                int i12 = 0;
                while (true) {
                    if (i12 >= childCount) {
                        break;
                    }
                    if (viewGroup.getChildAt(i12).getVisibility() == 0) {
                        this.f15742e = viewGroup.getChildAt(i12);
                        break;
                    }
                    i12++;
                }
            }
        }
        if (this.f15742e == null) {
            this.f15742e = this.f15741d;
        }
        View view2 = this.f15742e;
        if (view2 != null) {
            view2.getLocationOnScreen(this.f15738a);
        }
        View view3 = this.f15740c;
        if (view3 == null) {
            return;
        }
        int i13 = this.f15738a[1];
        if (i13 < this.f15745h) {
            i10 = this.f15746i;
        } else {
            int i14 = this.f15744g;
            if (i13 > i14) {
                i10 = 0;
            } else {
                i10 = i14 - i13;
            }
        }
        if (this.f15751n <= 1.0f) {
            float abs = Math.abs(i10) / this.f15746i;
            this.f15751n = abs;
            view3.setAlpha(abs);
        }
        if (i13 < this.f15747j) {
            i11 = this.f15749l;
        } else {
            int i15 = this.f15748k;
            if (i13 <= i15) {
                i11 = i15 - i13;
            }
        }
        float abs2 = Math.abs(i11) / this.f15749l;
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        layoutParams.width = (int) (this.f15739b + (this.f15743f * abs2));
        view3.setLayoutParams(layoutParams);
    }

    public final void c(boolean z10) {
        this.f15753p = z10;
    }

    public final void d(boolean z10) {
        this.f15752o = z10;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        onListScroll();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        if (a.b()) {
            Log.i("SmallTabBehavior", "absListView =" + absListView + " " + i10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View directTargetChild, View target, int i10, int i11) {
        int g10;
        i.f(coordinatorLayout, "coordinatorLayout");
        i.f(child, "child");
        i.f(directTargetChild, "directTargetChild");
        i.f(target, "target");
        if ((i10 & 2) != 0 && coordinatorLayout.getHeight() - directTargetChild.getHeight() <= child.getHeight()) {
            this.f15741d = target;
            if (this.f15744g <= 0) {
                if (this.f15753p) {
                    g10 = child.getMeasuredHeight();
                } else {
                    int measuredHeight = child.getMeasuredHeight();
                    Context context = target.getContext();
                    i.e(context, "target.context");
                    g10 = measuredHeight + DisplayUtil.g(context);
                }
                this.f15744g = g10;
                View findViewById = child.findViewById(N0.i.f1936n);
                this.f15740c = findViewById;
                this.f15739b = findViewById != null ? findViewById.getWidth() : 0;
                int i12 = this.f15744g;
                this.f15745h = i12 - this.f15746i;
                int i13 = i12 - this.f15750m;
                this.f15748k = i13;
                this.f15747j = i13 - this.f15749l;
            }
            target.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: P0.f
                @Override // android.view.View.OnScrollChangeListener
                public final void onScrollChange(View view, int i14, int i15, int i16, int i17) {
                    SmallTabBehavior.b(SmallTabBehavior.this, view, i14, i15, i16, i17);
                }
            });
        }
        return false;
    }
}
