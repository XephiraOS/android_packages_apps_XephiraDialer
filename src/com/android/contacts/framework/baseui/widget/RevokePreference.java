package com.android.contacts.framework.baseui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: RevokePreference.kt */
/* loaded from: classes.dex */
public final class RevokePreference extends RedDotPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokePreference(Context context) {
        super(context);
        kotlin.jvm.internal.i.f(context, "context");
    }

    @Override // com.android.contacts.framework.baseui.widget.RedDotPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l holder) {
        kotlin.jvm.internal.i.f(holder, "holder");
        super.onBindViewHolder(holder);
        TextView textView = (TextView) holder.itemView.findViewById(N0.i.f1948z);
        if (textView != null) {
            kotlin.jvm.internal.i.e(textView, "findViewById<TextView>(R….red_dot_preference_text)");
            textView.setTextColor(textView.getContext().getColorStateList(N0.e.f1864m));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokePreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokePreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
    }
}
