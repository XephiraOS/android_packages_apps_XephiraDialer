package com.android.contacts.framework.baseui.highlight;

import W0.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUIPreferenceCategory;
import kotlin.jvm.internal.i;

/* compiled from: HighlightPreferenceCategory.kt */
/* loaded from: classes.dex */
public final class HighlightPreferenceCategory extends COUIPreferenceCategory {

    /* renamed from: a, reason: collision with root package name */
    public c f15815a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15816b;

    public HighlightPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory, androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        c cVar;
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        if (view != null && this.f15815a == null) {
            this.f15815a = new c(view);
        }
        if (this.f15816b && (cVar = this.f15815a) != null) {
            cVar.i();
        }
        this.f15816b = false;
    }
}
