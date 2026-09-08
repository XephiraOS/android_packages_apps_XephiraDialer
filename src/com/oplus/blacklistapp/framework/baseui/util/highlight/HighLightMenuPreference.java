package com.oplus.blacklistapp.framework.baseui.util.highlight;

import E6.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUIMenuPreference;

/* compiled from: HighLightMenuPreference.kt */
/* loaded from: classes3.dex */
public final class HighLightMenuPreference extends COUIMenuPreference {

    /* renamed from: a, reason: collision with root package name */
    public c f27254a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f27255b;

    public HighLightMenuPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(boolean z10) {
        this.f27255b = z10;
    }

    @Override // com.coui.appcompat.preference.COUIMenuPreference, com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        c cVar;
        View view;
        super.onBindViewHolder(lVar);
        if (lVar != null && (view = lVar.itemView) != null && this.f27254a == null) {
            this.f27254a = new c(view);
        }
        if (this.f27255b && (cVar = this.f27254a) != null) {
            cVar.i();
        }
        this.f27255b = false;
    }
}
