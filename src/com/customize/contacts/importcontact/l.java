package com.customize.contacts.importcontact;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ImportListenerManager.java */
/* loaded from: classes3.dex */
public class l implements k {

    /* renamed from: a, reason: collision with root package name */
    public CopyOnWriteArrayList<k> f21443a;

    @Override // com.customize.contacts.importcontact.k
    public void a(String str, int i10) {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().a(str, i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void b(int i10) {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().b(i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void c(int i10) {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().c(i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void d() {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().d();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void e(int i10, int i11) {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().e(i10, i11);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void f(int i10) {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().f(i10);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    public void h(k kVar) {
        synchronized (this) {
            try {
                if (this.f21443a == null) {
                    this.f21443a = new CopyOnWriteArrayList<>();
                }
                if (this.f21443a.contains(kVar)) {
                    return;
                }
                this.f21443a.add(kVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.customize.contacts.importcontact.k
    public void onStart() {
        synchronized (this) {
            try {
                CopyOnWriteArrayList<k> copyOnWriteArrayList = this.f21443a;
                if (copyOnWriteArrayList != null) {
                    Iterator<k> it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        it.next().onStart();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
