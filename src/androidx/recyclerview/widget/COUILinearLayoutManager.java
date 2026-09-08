package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class COUILinearLayoutManager extends LinearLayoutManager {
    public COUILinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i10, int i11) {
        super.scrollToPositionWithOffset(i10, i11 - this.mRecyclerView.getPaddingTop());
    }

    public COUILinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
