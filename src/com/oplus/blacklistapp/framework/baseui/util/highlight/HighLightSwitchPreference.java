package com.oplus.blacklistapp.framework.baseui.util.highlight;

import E6.c;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.coui.appcompat.preference.COUISwitchPreference;

/* compiled from: HighLightSwitchPreference.kt */
/* loaded from: classes3.dex */
public final class HighLightSwitchPreference extends COUISwitchPreference {

    /* renamed from: a, reason: collision with root package name */
    public c f27256a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f27257b;

    public HighLightSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(boolean z10) {
        this.f27257b = z10;
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        c cVar;
        View view;
        super.onBindViewHolder(lVar);
        if (lVar != null && (view = lVar.itemView) != null && this.f27256a == null) {
            this.f27256a = new c(view);
        }
        if (this.f27257b && (cVar = this.f27256a) != null) {
            cVar.i();
        }
        this.f27257b = false;
    }
}
