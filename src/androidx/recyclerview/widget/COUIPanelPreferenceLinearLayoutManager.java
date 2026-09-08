package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class COUIPanelPreferenceLinearLayoutManager extends LinearLayoutManager {
    public COUIPanelPreferenceLinearLayoutManager(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return super.computeVerticalScrollOffset(yVar) + this.mRecyclerView.getScrollY();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return super.computeVerticalScrollRange(yVar) + this.mRecyclerView.getScrollY();
    }

    public COUIPanelPreferenceLinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
