package com.customize.contacts.widget;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.android.contacts.widget.PinnedHeaderListView;

/* compiled from: DefaultContactListView.kt */
/* loaded from: classes3.dex */
public final class DefaultContactListView extends PinnedHeaderListView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        super.onSaveInstanceState();
        return null;
    }
}
