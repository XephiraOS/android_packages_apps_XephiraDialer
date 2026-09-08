package com.bumptech.glide.manager;

import android.util.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import o3.InterfaceC1399c;
import s3.C1541l;

/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC1399c> f19711a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final Set<InterfaceC1399c> f19712b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public boolean f19713c;

    public boolean a(InterfaceC1399c interfaceC1399c) {
        boolean z10 = true;
        if (interfaceC1399c == null) {
            return true;
        }
        boolean remove = this.f19711a.remove(interfaceC1399c);
        if (!this.f19712b.remove(interfaceC1399c) && !remove) {
            z10 = false;
        }
        if (z10) {
            interfaceC1399c.clear();
        }
        return z10;
    }

    public void b() {
        Iterator it = C1541l.j(this.f19711a).iterator();
        while (it.hasNext()) {
            a((InterfaceC1399c) it.next());
        }
        this.f19712b.clear();
    }

    public void c() {
        this.f19713c = true;
        for (InterfaceC1399c interfaceC1399c : C1541l.j(this.f19711a)) {
            if (interfaceC1399c.isRunning() || interfaceC1399c.j()) {
                interfaceC1399c.clear();
                this.f19712b.add(interfaceC1399c);
            }
        }
    }

    public void d() {
        this.f19713c = true;
        for (InterfaceC1399c interfaceC1399c : C1541l.j(this.f19711a)) {
            if (interfaceC1399c.isRunning()) {
                interfaceC1399c.o();
                this.f19712b.add(interfaceC1399c);
            }
        }
    }

    public void e() {
        for (InterfaceC1399c interfaceC1399c : C1541l.j(this.f19711a)) {
            if (!interfaceC1399c.j() && !interfaceC1399c.f()) {
                interfaceC1399c.clear();
                if (!this.f19713c) {
                    interfaceC1399c.h();
                } else {
                    this.f19712b.add(interfaceC1399c);
                }
            }
        }
    }

    public void f() {
        this.f19713c = false;
        for (InterfaceC1399c interfaceC1399c : C1541l.j(this.f19711a)) {
            if (!interfaceC1399c.j() && !interfaceC1399c.isRunning()) {
                interfaceC1399c.h();
            }
        }
        this.f19712b.clear();
    }

    public void g(InterfaceC1399c interfaceC1399c) {
        this.f19711a.add(interfaceC1399c);
        if (!this.f19713c) {
            interfaceC1399c.h();
            return;
        }
        interfaceC1399c.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f19712b.add(interfaceC1399c);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f19711a.size() + ", isPaused=" + this.f19713c + "}";
    }
}
