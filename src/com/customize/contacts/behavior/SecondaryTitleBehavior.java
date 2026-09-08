package com.customize.contacts.behavior;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.contacts.framework.baseui.behavior.BaseTitleBehavior;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.behavior.SecondaryTitleBehavior;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;

/* compiled from: SecondaryTitleBehavior.kt */
/* loaded from: classes3.dex */
public final class SecondaryTitleBehavior extends CoordinatorLayout.Behavior<AppBarLayout> implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f20832a;

    /* renamed from: b, reason: collision with root package name */
    public View f20833b;

    /* renamed from: c, reason: collision with root package name */
    public COUIToolbar f20834c;

    /* renamed from: d, reason: collision with root package name */
    public ListView f20835d;

    /* renamed from: e, reason: collision with root package name */
    public View f20836e;

    /* renamed from: f, reason: collision with root package name */
    public int f20837f;

    /* renamed from: g, reason: collision with root package name */
    public int f20838g;

    /* renamed from: h, reason: collision with root package name */
    public int f20839h;

    /* renamed from: i, reason: collision with root package name */
    public int f20840i;

    /* renamed from: j, reason: collision with root package name */
    public int f20841j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f20842k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout.LayoutParams f20843l;

    /* renamed from: m, reason: collision with root package name */
    public BaseTitleBehavior.b f20844m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SecondaryTitleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f20842k = new int[2];
        Resources resources = context.getResources();
        this.f20832a = context;
        this.f20840i = context.getResources().getDimensionPixelOffset(R.dimen.common_margin);
        this.f20838g = resources.getDimensionPixelOffset(R.dimen.line_width_range_count_height);
        this.f20837f = resources.getDimensionPixelOffset(R.dimen.line_alpha_range_change_offset);
        this.f20839h = resources.getDimensionPixelSize(R.dimen.divider_height);
    }

    private final float b(float f10) {
        float f11 = f10 / this.f20837f;
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
        float f11 = (f10 - this.f20837f) / this.f20838g;
        float f12 = 1.0f;
        if (f11 <= 1.0f) {
            f12 = 0.0f;
            if (f11 >= 0.0f) {
                return f11;
            }
        }
        return f12;
    }

    public static final void d(SecondaryTitleBehavior this$0, View view, int i10, int i11, int i12, int i13) {
        i.f(this$0, "this$0");
        this$0.onListScroll();
    }

    private final void e(float f10) {
        float b10 = b(f10);
        float c10 = c(f10);
        View view = this.f20836e;
        if (view != null) {
            LinearLayout.LayoutParams layoutParams = this.f20843l;
            if (layoutParams != null) {
                int i10 = this.f20840i;
                float f11 = 1 - c10;
                layoutParams.setMargins((int) (i10 * f11), layoutParams.topMargin, (int) (i10 * f11), layoutParams.bottomMargin);
            }
            view.setLayoutParams(this.f20843l);
            view.setAlpha(b10);
        }
    }

    private final void onListScroll() {
        int i10;
        View childAt;
        View view = null;
        this.f20833b = null;
        ListView listView = this.f20835d;
        if (listView != null && listView.getChildCount() > 0) {
            ListView listView2 = this.f20835d;
            int i11 = 0;
            if (listView2 != null) {
                i10 = listView2.getChildCount();
            } else {
                i10 = 0;
            }
            while (true) {
                if (i11 >= i10) {
                    break;
                }
                ListView listView3 = this.f20835d;
                if (listView3 != null && (childAt = listView3.getChildAt(i11)) != null && childAt.getVisibility() == 0) {
                    ListView listView4 = this.f20835d;
                    if (listView4 != null) {
                        view = listView4.getChildAt(i11);
                    }
                    this.f20833b = view;
                } else {
                    i11++;
                }
            }
        }
        if (this.f20833b == null) {
            this.f20833b = this.f20835d;
        }
        View view2 = this.f20833b;
        if (view2 != null) {
            view2.getLocationInWindow(this.f20842k);
        }
        e(this.f20841j - this.f20842k[1]);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        i.f(absListView, "absListView");
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView listView, int i10) {
        i.f(listView, "listView");
        BaseTitleBehavior.b bVar = this.f20844m;
        if (bVar == null) {
            i.q("mListScrollListener");
            bVar = null;
        }
        bVar.A(listView, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int i10, int i11) {
        i.f(parent, "parent");
        i.f(child, "child");
        i.f(directTargetChild, "directTargetChild");
        i.f(target, "target");
        boolean z10 = target instanceof ListView;
        this.f20835d = z10 ? (ListView) target : null;
        if (this.f20834c != null) {
            return false;
        }
        this.f20834c = (COUIToolbar) child.findViewById(R.id.toolbar);
        View findViewById = child.findViewById(R.id.bottom_divider_line);
        this.f20836e = findViewById;
        Object layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        this.f20843l = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        this.f20841j = child.getMeasuredHeight() - this.f20839h;
        target.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: D3.b
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i12, int i13, int i14, int i15) {
                SecondaryTitleBehavior.d(SecondaryTitleBehavior.this, view, i12, i13, i14, i15);
            }
        });
        if (!z10) {
            return false;
        }
        ((ListView) target).setOnScrollListener(this);
        return false;
    }
}
