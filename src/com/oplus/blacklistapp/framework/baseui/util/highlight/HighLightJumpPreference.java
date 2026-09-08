package com.oplus.blacklistapp.framework.baseui.util.highlight;

import E6.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUIJumpPreference;

/* compiled from: HighLightJumpPreference.kt */
/* loaded from: classes3.dex */
public final class HighLightJumpPreference extends COUIJumpPreference {

    /* renamed from: a, reason: collision with root package name */
    public c f27252a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f27253b;

    public HighLightJumpPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(boolean z10) {
        this.f27253b = z10;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        c cVar;
        View view;
        super.onBindViewHolder(lVar);
        if (lVar != null && (view = lVar.itemView) != null && this.f27252a == null) {
            this.f27252a = new c(view);
        }
        if (this.f27253b && (cVar = this.f27252a) != null) {
            cVar.i();
        }
        this.f27253b = false;
    }
}
