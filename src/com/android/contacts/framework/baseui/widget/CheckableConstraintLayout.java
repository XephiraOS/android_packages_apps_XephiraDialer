package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: CheckableConstraintLayout.kt */
/* loaded from: classes.dex */
public final class CheckableConstraintLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15998a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckableConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f15998a) {
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
        if (z10 != this.f15998a) {
            this.f15998a = z10;
        }
        refreshDrawableState();
    }

    public /* synthetic */ CheckableConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, kotlin.jvm.internal.f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckableConstraintLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        setForceDarkAllowed(false);
    }
}
