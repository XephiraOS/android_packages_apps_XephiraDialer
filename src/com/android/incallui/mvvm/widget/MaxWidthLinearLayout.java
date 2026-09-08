package com.android.incallui.mvvm.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.android.incallui.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: MaxWidthLinearLayout.kt */
/* loaded from: classes.dex */
public final class MaxWidthLinearLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public int f18722a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxWidthLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public final int getMMaxWidth() {
        return this.f18722a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int i12 = this.f18722a;
        if (i12 >= 0 && i12 < size) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, View.MeasureSpec.getMode(i10)), i11);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    public final void setMMaxWidth(int i10) {
        this.f18722a = i10;
    }

    public /* synthetic */ MaxWidthLinearLayout(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxWidthLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f18722a = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthLinearLayout);
        this.f18722a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaxWidthLinearLayout_maxWidth, Integer.MAX_VALUE);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void getMMaxWidth$annotations() {
    }
}
