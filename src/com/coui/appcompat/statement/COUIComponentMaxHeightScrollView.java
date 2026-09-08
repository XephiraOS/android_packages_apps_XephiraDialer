package com.coui.appcompat.statement;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: COUIComponentMaxHeightScrollView.kt */
/* loaded from: classes.dex */
public final class COUIComponentMaxHeightScrollView extends COUIMaxHeightScrollView {
    private boolean isProtocolFixed;

    public /* synthetic */ COUIComponentMaxHeightScrollView(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.f fVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public final boolean isProtocolFixed() {
        return this.isProtocolFixed;
    }

    @Override // com.coui.appcompat.statement.COUIMaxHeightScrollView, com.coui.appcompat.scrollview.COUIScrollView, android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int e10;
        if (getMaxHeight() > 0) {
            e10 = B9.i.e(getMaxHeight(), View.MeasureSpec.getSize(i11));
            i11 = View.MeasureSpec.makeMeasureSpec(e10, Integer.MIN_VALUE);
        }
        if (this.isProtocolFixed && getChildCount() > 0) {
            int i12 = 0;
            measureChild(getChildAt(0), i10, i11);
            if (getChildAt(0).getMeasuredHeight() > View.MeasureSpec.getSize(i11) - getPaddingTop()) {
                i12 = getContext().getResources().getDimensionPixelOffset(Z8.c.f6024j);
            }
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i12);
        }
        super.onMeasure(i10, i11);
    }

    public final void setProtocolFixed(boolean z10) {
        this.isProtocolFixed = z10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIComponentMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
