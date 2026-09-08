package com.customize.contacts.behavior;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.i;

/* compiled from: DoNothingBehavior.kt */
/* loaded from: classes3.dex */
public final class DoNothingBehavior extends CoordinatorLayout.Behavior<AppBarLayout> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoNothingBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
    }
}
