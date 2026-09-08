package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import p3.InterfaceC1438h;
import s3.C1541l;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class r implements k {

    /* renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC1438h<?>> f19728a = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.k
    public void b() {
        Iterator it = C1541l.j(this.f19728a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1438h) it.next()).b();
        }
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
        Iterator it = C1541l.j(this.f19728a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1438h) it.next()).e();
        }
    }

    public void j() {
        this.f19728a.clear();
    }

    public List<InterfaceC1438h<?>> k() {
        return C1541l.j(this.f19728a);
    }

    public void l(InterfaceC1438h<?> interfaceC1438h) {
        this.f19728a.add(interfaceC1438h);
    }

    public void m(InterfaceC1438h<?> interfaceC1438h) {
        this.f19728a.remove(interfaceC1438h);
    }

    @Override // com.bumptech.glide.manager.k
    public void onStart() {
        Iterator it = C1541l.j(this.f19728a).iterator();
        while (it.hasNext()) {
            ((InterfaceC1438h) it.next()).onStart();
        }
    }
}
