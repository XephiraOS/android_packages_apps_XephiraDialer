package com.bumptech.glide.manager;

import androidx.lifecycle.InterfaceC0491n;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import s3.C1541l;

/* loaded from: classes.dex */
final class LifecycleLifecycle implements j, InterfaceC0491n {

    /* renamed from: a, reason: collision with root package name */
    public final Set<k> f19689a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Lifecycle f19690b;

    public LifecycleLifecycle(Lifecycle lifecycle) {
        this.f19690b = lifecycle;
        lifecycle.a(this);
    }

    @Override // com.bumptech.glide.manager.j
    public void a(k kVar) {
        this.f19689a.add(kVar);
        if (this.f19690b.b() == Lifecycle.State.DESTROYED) {
            kVar.b();
        } else if (this.f19690b.b().b(Lifecycle.State.STARTED)) {
            kVar.onStart();
        } else {
            kVar.e();
        }
    }

    @Override // com.bumptech.glide.manager.j
    public void b(k kVar) {
        this.f19689a.remove(kVar);
    }

    @x(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(InterfaceC0492o interfaceC0492o) {
        Iterator it = C1541l.j(this.f19689a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).b();
        }
        interfaceC0492o.getLifecycle().d(this);
    }

    @x(Lifecycle.Event.ON_START)
    public void onStart(InterfaceC0492o interfaceC0492o) {
        Iterator it = C1541l.j(this.f19689a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).onStart();
        }
    }

    @x(Lifecycle.Event.ON_STOP)
    public void onStop(InterfaceC0492o interfaceC0492o) {
        Iterator it = C1541l.j(this.f19689a).iterator();
        while (it.hasNext()) {
            ((k) it.next()).e();
        }
    }
}
