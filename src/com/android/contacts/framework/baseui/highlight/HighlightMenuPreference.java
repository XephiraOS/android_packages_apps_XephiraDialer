package com.android.contacts.framework.baseui.highlight;

import W0.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUIMenuPreference;
import kotlin.jvm.internal.i;

/* compiled from: HighlightMenuPreference.kt */
/* loaded from: classes.dex */
public final class HighlightMenuPreference extends COUIMenuPreference {

    /* renamed from: a, reason: collision with root package name */
    public c f15813a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15814b;

    public HighlightMenuPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.preference.COUIMenuPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        c cVar;
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        if (view != null && this.f15813a == null) {
            this.f15813a = new c(view);
        }
        if (this.f15814b && (cVar = this.f15813a) != null) {
            cVar.i();
        }
        this.f15814b = false;
    }
}
