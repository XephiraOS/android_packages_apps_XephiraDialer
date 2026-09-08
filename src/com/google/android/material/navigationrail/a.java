package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import com.google.android.material.navigation.c;
import e4.C0979e;
import e4.i;

/* compiled from: NavigationRailItemView.java */
/* loaded from: classes3.dex */
public final class a extends c {
    public a(Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.c
    public int getItemDefaultMarginResId() {
        return C0979e.f30730D0;
    }

    @Override // com.google.android.material.navigation.c
    public int getItemLayoutResId() {
        return i.f30946z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i11)));
        }
    }
}
