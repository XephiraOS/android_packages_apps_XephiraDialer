package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import o3.InterfaceC1399c;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class a implements RequestCoordinator, InterfaceC1399c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19773a;

    /* renamed from: b, reason: collision with root package name */
    public final RequestCoordinator f19774b;

    /* renamed from: c, reason: collision with root package name */
    public volatile InterfaceC1399c f19775c;

    /* renamed from: d, reason: collision with root package name */
    public volatile InterfaceC1399c f19776d;

    /* renamed from: e, reason: collision with root package name */
    public RequestCoordinator.RequestState f19777e;

    /* renamed from: f, reason: collision with root package name */
    public RequestCoordinator.RequestState f19778f;

    public a(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f19777e = requestState;
        this.f19778f = requestState;
        this.f19773a = obj;
        this.f19774b = requestCoordinator;
    }

    public final boolean a(InterfaceC1399c interfaceC1399c) {
        RequestCoordinator.RequestState requestState;
        RequestCoordinator.RequestState requestState2 = this.f19777e;
        RequestCoordinator.RequestState requestState3 = RequestCoordinator.RequestState.FAILED;
        if (requestState2 != requestState3) {
            return interfaceC1399c.equals(this.f19775c);
        }
        if (interfaceC1399c.equals(this.f19776d) && ((requestState = this.f19778f) == RequestCoordinator.RequestState.SUCCESS || requestState == requestState3)) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, o3.InterfaceC1399c
    public boolean b() {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                if (!this.f19775c.b() && !this.f19776d.b()) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(InterfaceC1399c interfaceC1399c) {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                if (m() && a(interfaceC1399c)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public void clear() {
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
                this.f19777e = requestState;
                this.f19775c.clear();
                if (this.f19778f != requestState) {
                    this.f19778f = requestState;
                    this.f19776d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(InterfaceC1399c interfaceC1399c) {
        synchronized (this.f19773a) {
            try {
                if (!interfaceC1399c.equals(this.f19776d)) {
                    this.f19777e = RequestCoordinator.RequestState.FAILED;
                    RequestCoordinator.RequestState requestState = this.f19778f;
                    RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                    if (requestState != requestState2) {
                        this.f19778f = requestState2;
                        this.f19776d.h();
                    }
                    return;
                }
                this.f19778f = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f19774b;
                if (requestCoordinator != null) {
                    requestCoordinator.d(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean e(InterfaceC1399c interfaceC1399c) {
        boolean n10;
        synchronized (this.f19773a) {
            n10 = n();
        }
        return n10;
    }

    @Override // o3.InterfaceC1399c
    public boolean f() {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = this.f19777e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
                if (requestState == requestState2 && this.f19778f == requestState2) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean g(InterfaceC1399c interfaceC1399c) {
        if (!(interfaceC1399c instanceof a)) {
            return false;
        }
        a aVar = (a) interfaceC1399c;
        if (!this.f19775c.g(aVar.f19775c) || !this.f19776d.g(aVar.f19776d)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.RequestCoordinator] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        ?? r22;
        synchronized (this.f19773a) {
            try {
                RequestCoordinator requestCoordinator = this.f19774b;
                this = this;
                if (requestCoordinator != null) {
                    r22 = requestCoordinator.getRoot();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return r22;
    }

    @Override // o3.InterfaceC1399c
    public void h() {
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = this.f19777e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f19777e = requestState2;
                    this.f19775c.h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(InterfaceC1399c interfaceC1399c) {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                if (l() && interfaceC1399c.equals(this.f19775c)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean isRunning() {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = this.f19777e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2 && this.f19778f != requestState2) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean j() {
        boolean z10;
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = this.f19777e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
                if (requestState != requestState2 && this.f19778f != requestState2) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void k(InterfaceC1399c interfaceC1399c) {
        synchronized (this.f19773a) {
            try {
                if (interfaceC1399c.equals(this.f19775c)) {
                    this.f19777e = RequestCoordinator.RequestState.SUCCESS;
                } else if (interfaceC1399c.equals(this.f19776d)) {
                    this.f19778f = RequestCoordinator.RequestState.SUCCESS;
                }
                RequestCoordinator requestCoordinator = this.f19774b;
                if (requestCoordinator != null) {
                    requestCoordinator.k(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean l() {
        RequestCoordinator requestCoordinator = this.f19774b;
        if (requestCoordinator != null && !requestCoordinator.i(this)) {
            return false;
        }
        return true;
    }

    public final boolean m() {
        RequestCoordinator requestCoordinator = this.f19774b;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    public final boolean n() {
        RequestCoordinator requestCoordinator = this.f19774b;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    @Override // o3.InterfaceC1399c
    public void o() {
        synchronized (this.f19773a) {
            try {
                RequestCoordinator.RequestState requestState = this.f19777e;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState == requestState2) {
                    this.f19777e = RequestCoordinator.RequestState.PAUSED;
                    this.f19775c.o();
                }
                if (this.f19778f == requestState2) {
                    this.f19778f = RequestCoordinator.RequestState.PAUSED;
                    this.f19776d.o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void p(InterfaceC1399c interfaceC1399c, InterfaceC1399c interfaceC1399c2) {
        this.f19775c = interfaceC1399c;
        this.f19776d = interfaceC1399c2;
    }
}
