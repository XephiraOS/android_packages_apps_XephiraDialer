package com.bumptech.glide.manager;

import android.content.Context;
import com.bumptech.glide.manager.b;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19691a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f19692b;

    public d(Context context, b.a aVar) {
        this.f19691a = context.getApplicationContext();
        this.f19692b = aVar;
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
        k();
    }

    public final void j() {
        q.a(this.f19691a).d(this.f19692b);
    }

    public final void k() {
        q.a(this.f19691a).e(this.f19692b);
    }

    @Override // com.bumptech.glide.manager.k
    public void onStart() {
        j();
    }

    @Override // com.bumptech.glide.manager.k
    public void b() {
    }
}
