package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* compiled from: SelectedCardView.kt */
/* loaded from: classes.dex */
public class SelectedCardView extends COUICardListSelectedItemLayout {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16122a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16123b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectedCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectedCardView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedCardView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        this.f16122a = true;
        this.f16123b = true;
        COUICardListHelper.setItemCardBackground(this, 4);
    }
}
