package com.oplus.contacts.list.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.appbar.COUICollapsableAppBarLayout;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: ContactsMainListCollapsableAppBarLayout.kt */
/* loaded from: classes3.dex */
public final class ContactsMainListCollapsableAppBarLayout extends COUICollapsableAppBarLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContactsMainListCollapsableAppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    public final void c() {
        this.mScrollDyByScroll = 0;
    }

    public /* synthetic */ ContactsMainListCollapsableAppBarLayout(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListCollapsableAppBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
    }
}
