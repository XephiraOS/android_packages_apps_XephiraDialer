package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import kotlin.Result;

/* compiled from: MainPercentWidthLayout.kt */
/* loaded from: classes.dex */
public final class MainPercentWidthLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f16082a;

    /* renamed from: b, reason: collision with root package name */
    public int f16083b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16084c;

    /* renamed from: d, reason: collision with root package name */
    public int f16085d;

    /* renamed from: e, reason: collision with root package name */
    public int f16086e;

    /* renamed from: f, reason: collision with root package name */
    public int f16087f;

    /* renamed from: g, reason: collision with root package name */
    public int f16088g;

    /* renamed from: h, reason: collision with root package name */
    public int f16089h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainPercentWidthLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
        this.f16083b = 0;
        a(attributeSet);
    }

    public final void a(AttributeSet attributeSet) {
        Context context = getContext();
        if (context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, X8.o.f5433v3);
            kotlin.jvm.internal.i.e(obtainStyledAttributes, "context.obtainStyledAttr…IPercentWidthFrameLayout)");
            this.f16082a = obtainStyledAttributes.getResourceId(X8.o.f5441w3, 0);
            this.f16087f = obtainStyledAttributes.getInteger(X8.o.f5465z3, 0);
            this.f16084c = obtainStyledAttributes.getBoolean(X8.o.f5059A3, true);
            this.f16083b = obtainStyledAttributes.getInt(X8.o.f5067B3, 0);
            this.f16089h = obtainStyledAttributes.getInteger(X8.o.f5377o3, 0);
            this.f16085d = getPaddingStart();
            this.f16086e = getPaddingEnd();
            obtainStyledAttributes.recycle();
        }
    }

    public final int getMMode() {
        return this.f16083b;
    }

    public final int getMPercentWidthResourceId() {
        return this.f16082a;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            super.onLayout(z10, i10, i11, i12, i13);
            if (this.f16084c && getChildCount() == 1) {
                View childAt = getChildAt(0);
                kotlin.jvm.internal.i.e(childAt, "getChildAt(0)");
                int left = childAt.getLeft();
                int i14 = this.f16088g;
                if (left != i14) {
                    childAt.layout(i14, childAt.getTop(), this.f16088g + childAt.getWidth(), childAt.getBottom());
                }
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        View view;
        super.onMeasure(i10, i11);
        int i12 = 0;
        if (getChildCount() == 1) {
            view = getChildAt(0);
        } else {
            view = null;
        }
        if (view == null) {
            return;
        }
        this.f16088g = 0;
        if (this.f16084c) {
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            if (this.f16082a > 0) {
                i12 = getResources().getInteger(this.f16082a);
            }
            if (i12 > 0 && rect.width() > 0 && View.MeasureSpec.getSize(i10) <= rect.width()) {
                int width = (rect.width() - ((int) COUIResponsiveUtils.calculateWidth(rect.width(), i12, this.f16087f, this.f16089h, getContext()))) / 2;
                this.f16088g = width;
                view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - width) - width, 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
        }
    }

    public final void setMMode(int i10) {
        this.f16083b = i10;
    }

    public final void setMPercentWidthResourceId(int i10) {
        this.f16082a = i10;
    }

    public final void setPercentIndentEnabled(boolean z10) {
        this.f16084c = z10;
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MainPercentWidthLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
