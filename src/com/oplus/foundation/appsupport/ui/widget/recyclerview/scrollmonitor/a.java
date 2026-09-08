package com.oplus.foundation.appsupport.ui.widget.recyclerview.scrollmonitor;

/* compiled from: ScrollState.kt */
/* loaded from: classes3.dex */
public class a implements com.oplus.foundation.appsupport.ui.statemonitor.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f28265a;

    public a(boolean z10) {
        this.f28265a = z10;
    }

    @Override // com.oplus.foundation.appsupport.ui.statemonitor.a
    public boolean a() {
        return b();
    }

    public boolean b() {
        return this.f28265a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a) && b() == ((a) obj).b()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Boolean.hashCode(b());
    }
}
