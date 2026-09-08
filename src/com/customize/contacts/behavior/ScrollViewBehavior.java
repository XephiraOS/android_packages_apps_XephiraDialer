package com.customize.contacts.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.behavior.ScrollViewBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import kotlin.jvm.internal.i;

/* compiled from: ScrollViewBehavior.kt */
/* loaded from: classes3.dex */
public final class ScrollViewBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f20818a;

    /* renamed from: b, reason: collision with root package name */
    public View f20819b;

    /* renamed from: c, reason: collision with root package name */
    public COUIToolbar f20820c;

    /* renamed from: d, reason: collision with root package name */
    public ScrollView f20821d;

    /* renamed from: e, reason: collision with root package name */
    public View f20822e;

    /* renamed from: f, reason: collision with root package name */
    public int f20823f;

    /* renamed from: g, reason: collision with root package name */
    public int f20824g;

    /* renamed from: h, reason: collision with root package name */
    public int f20825h;

    /* renamed from: i, reason: collision with root package name */
    public int f20826i;

    /* renamed from: j, reason: collision with root package name */
    public int f20827j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f20828k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f20829l;

    /* renamed from: m, reason: collision with root package name */
    public AppBarLayout.LayoutParams f20830m;

    /* renamed from: n, reason: collision with root package name */
    public int f20831n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f20828k = new int[2];
        this.f20829l = new int[2];
        Resources resources = context.getResources();
        this.f20818a = context;
        this.f20826i = context.getResources().getDimensionPixelOffset(R.dimen.common_margin);
        this.f20824g = resources.getDimensionPixelOffset(R.dimen.line_width_range_count_height);
        this.f20823f = resources.getDimensionPixelOffset(R.dimen.line_alpha_range_change_offset);
        this.f20825h = resources.getDimensionPixelSize(R.dimen.divider_height);
        this.f20831n = DisplayUtil.g(context);
    }

    private final float b(float f10) {
        float f11 = f10 / this.f20823f;
        float f12 = 1.0f;
        if (f11 <= 1.0f) {
            f12 = 0.0f;
            if (f11 >= 0.0f) {
                return f11;
            }
        }
        return f12;
    }

    private final float c(float f10) {
        int i10 = this.f20824g;
        float f11 = (f10 - i10) / i10;
        float f12 = 1.0f;
        if (f11 <= 1.0f) {
            f12 = 0.0f;
            if (f11 >= 0.0f) {
                return f11;
            }
        }
        return f12;
    }

    public static final void d(ScrollViewBehavior this$0, View view, int i10, int i11, int i12, int i13) {
        i.f(this$0, "this$0");
        this$0.onListScroll();
    }

    private final void onListScroll() {
        int i10;
        int i11;
        View rootView;
        int i12;
        View childAt;
        View view = null;
        this.f20819b = null;
        ScrollView scrollView = this.f20821d;
        if (scrollView != null && scrollView.getChildCount() > 0) {
            ScrollView scrollView2 = this.f20821d;
            int i13 = 0;
            if (scrollView2 != null) {
                i12 = scrollView2.getChildCount();
            } else {
                i12 = 0;
            }
            while (true) {
                if (i13 >= i12) {
                    break;
                }
                ScrollView scrollView3 = this.f20821d;
                if (scrollView3 != null && (childAt = scrollView3.getChildAt(i13)) != null && childAt.getVisibility() == 0) {
                    ScrollView scrollView4 = this.f20821d;
                    if (scrollView4 != null) {
                        view = scrollView4.getChildAt(i13);
                    }
                    this.f20819b = view;
                } else {
                    i13++;
                }
            }
        }
        if (this.f20819b == null) {
            this.f20819b = this.f20821d;
        }
        View view2 = this.f20819b;
        if (view2 != null) {
            view2.getLocationInWindow(this.f20828k);
        }
        ScrollView scrollView5 = this.f20821d;
        if (scrollView5 != null && (rootView = scrollView5.getRootView()) != null) {
            rootView.getLocationOnScreen(this.f20829l);
        }
        if (this.f20829l[1] > 0) {
            i10 = this.f20827j;
            i11 = this.f20828k[1] + this.f20831n;
        } else {
            i10 = this.f20827j;
            i11 = this.f20828k[1];
        }
        e(i10 - i11);
    }

    public final void e(float f10) {
        float b10 = b(f10);
        float c10 = c(f10);
        View view = this.f20822e;
        if (view != null) {
            AppBarLayout.LayoutParams layoutParams = this.f20830m;
            if (layoutParams != null) {
                int i10 = (int) (this.f20826i * (1 - c10));
                layoutParams.setMarginStart(i10);
                layoutParams.setMarginEnd(i10);
            }
            view.setLayoutParams(this.f20830m);
            view.setAlpha(b10);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        i.f(absListView, "absListView");
        onListScroll();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
        i.f(absListView, "absListView");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int i10, int i11) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(directTargetChild, "directTargetChild");
        i.f(target, "target");
        this.f20821d = target instanceof ScrollView ? (ScrollView) target : null;
        if (this.f20820c == null) {
            this.f20820c = (COUIToolbar) child.findViewById(R.id.toolbar);
            View findViewById = child.findViewById(R.id.divider_line);
            this.f20822e = findViewById;
            Object layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
            this.f20830m = layoutParams instanceof AppBarLayout.LayoutParams ? (AppBarLayout.LayoutParams) layoutParams : null;
            this.f20827j = (child.getMeasuredHeight() - this.f20825h) + this.f20818a.getResources().getDimensionPixelOffset(R.dimen.list_padding_top);
        }
        target.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: D3.a
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i12, int i13, int i14, int i15) {
                ScrollViewBehavior.d(ScrollViewBehavior.this, view, i12, i13, i14, i15);
            }
        });
        return false;
    }
}
