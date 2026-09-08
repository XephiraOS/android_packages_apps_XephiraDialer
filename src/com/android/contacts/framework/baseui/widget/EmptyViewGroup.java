package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.oplus.foundation.util.display.DisplayUtil;

/* compiled from: EmptyViewGroup.kt */
/* loaded from: classes.dex */
public final class EmptyViewGroup extends LinearLayout {

    /* renamed from: n, reason: collision with root package name */
    public static final a f16011n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Boolean f16012a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f16013b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16014c;

    /* renamed from: d, reason: collision with root package name */
    public int f16015d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16016e;

    /* renamed from: f, reason: collision with root package name */
    public int f16017f;

    /* renamed from: g, reason: collision with root package name */
    public int f16018g;

    /* renamed from: h, reason: collision with root package name */
    public int f16019h;

    /* renamed from: i, reason: collision with root package name */
    public int f16020i;

    /* renamed from: j, reason: collision with root package name */
    public int f16021j;

    /* renamed from: k, reason: collision with root package name */
    public View f16022k;

    /* renamed from: l, reason: collision with root package name */
    public int f16023l;

    /* renamed from: m, reason: collision with root package name */
    public int f16024m;

    /* compiled from: EmptyViewGroup.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
        this.f16012a = Boolean.TRUE;
        this.f16013b = Boolean.FALSE;
        this.f16014c = true;
        this.f16016e = true;
        e(attributeSet);
        f(context);
    }

    public static final void g(View it, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(it, "$it");
        it.setLayoutParams(layoutParams);
        it.setVisibility(8);
    }

    public static final void h(View it, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(it, "$it");
        it.setLayoutParams(layoutParams);
        it.setVisibility(0);
    }

    public static final void i(View it, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.i.f(it, "$it");
        it.setLayoutParams(layoutParams);
        it.setVisibility(0);
    }

    public final int d(int i10) {
        return (int) ((i10 / getResources().getDisplayMetrics().density) * 3.0f);
    }

    public final void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, N0.m.f2249s2);
        kotlin.jvm.internal.i.e(obtainStyledAttributes, "context.obtainStyledAttr…styleable.EmptyViewGroup)");
        this.f16012a = Boolean.valueOf(obtainStyledAttributes.getBoolean(N0.m.f2267v2, true));
        this.f16013b = Boolean.valueOf(obtainStyledAttributes.getBoolean(N0.m.f2273w2, false));
        this.f16014c = obtainStyledAttributes.getBoolean(N0.m.f2279x2, true);
        this.f16020i = obtainStyledAttributes.getDimensionPixelSize(N0.m.f2261u2, 0);
        this.f16021j = obtainStyledAttributes.getDimensionPixelSize(N0.m.f2255t2, 0);
        this.f16015d = obtainStyledAttributes.getInt(N0.m.f2285y2, 0);
        obtainStyledAttributes.recycle();
    }

    public final void f(Context context) {
        this.f16017f = getResources().getDimensionPixelSize(N0.f.f1867C);
        this.f16018g = getResources().getDimensionPixelSize(N0.f.f1894t);
        this.f16019h = DisplayUtil.g(context);
    }

    public final void j(int i10) {
        if (this.f16021j != i10) {
            this.f16021j = i10;
            this.f16016e = true;
            requestLayout();
        }
    }

    public final void k(int i10) {
        if (this.f16020i != i10) {
            this.f16020i = i10;
            this.f16016e = true;
            requestLayout();
        }
    }

    public final void l(boolean z10) {
        if (!kotlin.jvm.internal.i.b(this.f16012a, Boolean.valueOf(z10))) {
            this.f16012a = Boolean.valueOf(z10);
            this.f16016e = true;
            requestLayout();
        }
    }

    public final void m(boolean z10) {
        if (!kotlin.jvm.internal.i.b(this.f16013b, Boolean.valueOf(z10))) {
            this.f16013b = Boolean.valueOf(z10);
            this.f16016e = true;
            requestLayout();
        }
    }

    public final void n(int i10) {
        if (this.f16015d != i10) {
            this.f16015d = i10;
            this.f16016e = true;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f16022k = getChildAt(0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        double d10;
        int height;
        super.onLayout(z10, i10, i11, i12, i13);
        if (getHeight() > 0 && (getParent() instanceof ViewGroup)) {
            ViewParent parent = getParent();
            kotlin.jvm.internal.i.d(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            int height2 = ((ViewGroup) parent).getHeight();
            Boolean bool = this.f16012a;
            Boolean bool2 = Boolean.TRUE;
            if (kotlin.jvm.internal.i.b(bool, bool2)) {
                i14 = this.f16018g;
            } else {
                i14 = 0;
            }
            if (kotlin.jvm.internal.i.b(this.f16013b, bool2)) {
                i14 += this.f16019h;
            }
            int i15 = i14 + this.f16020i;
            int i16 = this.f16015d;
            if (i16 == 1) {
                height = this.f16017f;
            } else {
                if (i16 == 2) {
                    d10 = 0.44d;
                } else {
                    d10 = 0.45d;
                }
                height = (int) ((((height2 - i15) - this.f16021j) * d10) - (getHeight() / 2));
            }
            int i17 = height + i15;
            if (H7.a.b()) {
                H7.b.b("EmptyViewGroup", "height=" + getHeight() + " extraMargin=" + i15 + " fixMarginValue=" + this.f16017f + "  toolbarHeight=" + this.f16018g + " topMargin=" + i17 + " realEmptyViewHeight=" + height2 + "  statusbarHeight=" + this.f16019h + "  additionalTopMargin=" + this.f16020i + "  additionalBottomMargin=" + this.f16021j);
            }
            ViewParent parent2 = getParent();
            kotlin.jvm.internal.i.d(parent2, "null cannot be cast to non-null type android.view.ViewGroup");
            int width = ((ViewGroup) parent2).getWidth();
            int i18 = (height2 - i15) - this.f16021j;
            if (i18 != this.f16023l || width != this.f16024m) {
                if (i18 <= d(getResources().getDimensionPixelSize(N0.f.f1879e))) {
                    final View view = this.f16022k;
                    if (view != null) {
                        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.height = 0;
                        post(new Runnable() { // from class: com.android.contacts.framework.baseui.widget.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmptyViewGroup.g(view, layoutParams);
                            }
                        });
                    }
                } else if (i18 >= d(getResources().getDimensionPixelSize(N0.f.f1882h)) && width >= d(getResources().getDimensionPixelSize(N0.f.f1881g))) {
                    final View view2 = this.f16022k;
                    if (view2 != null) {
                        final ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                        layoutParams2.width = getResources().getDimensionPixelSize(N0.f.f1865A);
                        layoutParams2.height = getResources().getDimensionPixelSize(N0.f.f1900z);
                        post(new Runnable() { // from class: com.android.contacts.framework.baseui.widget.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmptyViewGroup.i(view2, layoutParams2);
                            }
                        });
                    }
                } else {
                    final View view3 = this.f16022k;
                    if (view3 != null) {
                        final ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                        layoutParams3.width = (int) (getResources().getDimensionPixelSize(N0.f.f1865A) * 0.6d);
                        layoutParams3.height = (int) (getResources().getDimensionPixelSize(N0.f.f1900z) * 0.6d);
                        post(new Runnable() { // from class: com.android.contacts.framework.baseui.widget.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                EmptyViewGroup.h(view3, layoutParams3);
                            }
                        });
                    }
                }
                this.f16023l = i18;
                this.f16024m = width;
            }
            if ((this.f16016e || getTop() == 0) && i17 > 0) {
                this.f16016e = false;
                layout(getLeft(), i17, getRight(), getHeight() + i17);
            }
        }
    }
}
