package com.oplus.utils;

import android.view.View;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.oplus.widget.SelectItemLayout;

/* compiled from: ViewUtils.kt */
/* loaded from: classes3.dex */
public final class Z {

    /* renamed from: a, reason: collision with root package name */
    public static final Z f29118a = new Z();

    public static final void a(View view, boolean z10) {
        if (view instanceof SelectItemLayout) {
            ((SelectItemLayout) view).setChecked(z10);
        } else if (view instanceof COUICardListSelectedItemLayout) {
            ((COUICardListSelectedItemLayout) view).setIsSelected(z10);
        }
    }
}
