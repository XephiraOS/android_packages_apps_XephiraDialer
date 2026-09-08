package com.oplus.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.oplus.blacklistapp.k;
import com.oplus.blacklistapp.o;
import kotlin.jvm.internal.i;

/* compiled from: SelectItemLayout.kt */
/* loaded from: classes4.dex */
public final class SelectItemLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f29318a;

    public SelectItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(o.f27297B);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f29318a) {
            int[] drawableState = super.onCreateDrawableState(i10 + 1);
            View.mergeDrawableStates(drawableState, new int[]{k.f27270a});
            i.e(drawableState, "drawableState");
            return drawableState;
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i10);
        i.e(onCreateDrawableState, "super.onCreateDrawableState(extraSpace)");
        return onCreateDrawableState;
    }

    public final void setChecked(boolean z10) {
        if (this.f29318a != z10) {
            this.f29318a = z10;
            refreshDrawableState();
        }
    }
}
