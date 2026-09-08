package com.android.contacts.framework.baseui.highlight;

import W0.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUIJumpPreference;
import kotlin.jvm.internal.i;

/* compiled from: HighlightJumpPreference.kt */
/* loaded from: classes.dex */
public final class HighlightJumpPreference extends COUIJumpPreference {

    /* renamed from: a, reason: collision with root package name */
    public c f15811a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15812b;

    public HighlightJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(boolean z10) {
        this.f15812b = z10;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        c cVar;
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        if (view != null && this.f15811a == null) {
            this.f15811a = new c(view);
        }
        if (this.f15812b && (cVar = this.f15811a) != null) {
            cVar.i();
        }
        this.f15812b = false;
    }
}
