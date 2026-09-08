package com.customize.contacts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;

/* compiled from: HtmlRecyclerView.kt */
/* loaded from: classes3.dex */
public final class HtmlRecyclerView extends COUIPercentWidthRecyclerView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HtmlRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (H7.a.b()) {
            H7.b.i("HtmlRecyclerView", "requestChildFocus do nothing ");
        }
    }
}
