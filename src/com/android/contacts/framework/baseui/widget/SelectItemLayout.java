package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* compiled from: SelectItemLayout.kt */
/* loaded from: classes.dex */
public final class SelectItemLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16121a;

    public SelectItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(N0.g.f1916p);
        setForceDarkAllowed(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f16121a) {
            int[] drawableState = super.onCreateDrawableState(i10 + 1);
            View.mergeDrawableStates(drawableState, new int[]{N0.c.f1849j});
            kotlin.jvm.internal.i.e(drawableState, "drawableState");
            return drawableState;
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i10);
        kotlin.jvm.internal.i.e(onCreateDrawableState, "super.onCreateDrawableState(extraSpace)");
        return onCreateDrawableState;
    }

    public final void setChecked(boolean z10) {
        if (this.f16121a != z10) {
            this.f16121a = z10;
            refreshDrawableState();
        }
    }
}
