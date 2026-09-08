package com.oplus.systembarlib;

import android.app.Activity;
import androidx.core.view.X;

/* compiled from: ActivitySystemBarStyle.kt */
/* loaded from: classes3.dex */
public class i extends b {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f29010a;

    public i(Activity activity) {
        kotlin.jvm.internal.i.f(activity, "activity");
        this.f29010a = activity;
    }

    @Override // com.oplus.systembarlib.b
    public void a() {
        e eVar = (e) this.f29010a;
        eVar.b0();
        eVar.v(!l.f29015a.a(this.f29010a));
        eVar.h0(this.f29010a.getColor(n.f29016a));
    }

    @Override // com.oplus.systembarlib.b
    public void b(X windowInsets) {
        kotlin.jvm.internal.i.f(windowInsets, "windowInsets");
        e eVar = (e) this.f29010a;
        if (!eVar.B()) {
            eVar.h0(0);
        }
    }
}
