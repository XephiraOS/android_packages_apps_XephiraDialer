package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;
import o3.InterfaceC1399c;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class b implements RequestCoordinator, InterfaceC1399c {

    /* renamed from: a, reason: collision with root package name */
    public final RequestCoordinator f19779a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f19780b;

    /* renamed from: c, reason: collision with root package name */
    public volatile InterfaceC1399c f19781c;

    /* renamed from: d, reason: collision with root package name */
    public volatile InterfaceC1399c f19782d;

    /* renamed from: e, reason: collision with root package name */
    public RequestCoordinator.RequestState f19783e;

    /* renamed from: f, reason: collision with root package name */
    public RequestCoordinator.RequestState f19784f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19785g;

    public b(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f19783e = requestState;
        this.f19784f = requestState;
        this.f19780b = obj;
        this.f19779a = requestCoordinator;
    }

    private boolean a() {
        RequestCoordinator requestCoordinator = this.f19779a;
        if (requestCoordinator != null && !requestCoordinator.i(this)) {
            return false;
        }
        return true;
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f19779a;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f19779a;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, o3.InterfaceC1399c
    public boolean b() {
        boolean z10;
        synchronized (this.f19780b) {
            try {
                if (!this.f19782d.b() && !this.f19781c.b()) {
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
        synchronized (this.f19780b) {
            try {
                if (l() && interfaceC1399c.equals(this.f19781c) && !b()) {
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
        synchronized (this.f19780b) {
            this.f19785g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f19783e = requestState;
            this.f19784f = requestState;
            this.f19782d.clear();
            this.f19781c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(InterfaceC1399c interfaceC1399c) {
        synchronized (this.f19780b) {
            try {
                if (!interfaceC1399c.equals(this.f19781c)) {
                    this.f19784f = RequestCoordinator.RequestState.FAILED;
                    return;
                }
                this.f19783e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator requestCoordinator = this.f19779a;
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
        boolean z10;
        synchronized (this.f19780b) {
            try {
                if (!m() || (!interfaceC1399c.equals(this.f19781c) && this.f19783e == RequestCoordinator.RequestState.SUCCESS)) {
                    z10 = false;
                }
                z10 = true;
            } finally {
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean f() {
        boolean z10;
        synchronized (this.f19780b) {
            if (this.f19783e == RequestCoordinator.RequestState.CLEARED) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean g(InterfaceC1399c interfaceC1399c) {
        if (!(interfaceC1399c instanceof b)) {
            return false;
        }
        b bVar = (b) interfaceC1399c;
        if (this.f19781c == null) {
            if (bVar.f19781c != null) {
                return false;
            }
        } else if (!this.f19781c.g(bVar.f19781c)) {
            return false;
        }
        if (this.f19782d == null) {
            if (bVar.f19782d != null) {
                return false;
            }
        } else if (!this.f19782d.g(bVar.f19782d)) {
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
        synchronized (this.f19780b) {
            try {
                RequestCoordinator requestCoordinator = this.f19779a;
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
        synchronized (this.f19780b) {
            try {
                this.f19785g = true;
                try {
                    if (this.f19783e != RequestCoordinator.RequestState.SUCCESS) {
                        RequestCoordinator.RequestState requestState = this.f19784f;
                        RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState != requestState2) {
                            this.f19784f = requestState2;
                            this.f19782d.h();
                        }
                    }
                    if (this.f19785g) {
                        RequestCoordinator.RequestState requestState3 = this.f19783e;
                        RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                        if (requestState3 != requestState4) {
                            this.f19783e = requestState4;
                            this.f19781c.h();
                        }
                    }
                    this.f19785g = false;
                } catch (Throwable th) {
                    this.f19785g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(InterfaceC1399c interfaceC1399c) {
        boolean z10;
        synchronized (this.f19780b) {
            try {
                if (a() && interfaceC1399c.equals(this.f19781c) && this.f19783e != RequestCoordinator.RequestState.PAUSED) {
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
        synchronized (this.f19780b) {
            if (this.f19783e == RequestCoordinator.RequestState.RUNNING) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // o3.InterfaceC1399c
    public boolean j() {
        boolean z10;
        synchronized (this.f19780b) {
            if (this.f19783e == RequestCoordinator.RequestState.SUCCESS) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void k(InterfaceC1399c interfaceC1399c) {
        synchronized (this.f19780b) {
            try {
                if (interfaceC1399c.equals(this.f19782d)) {
                    this.f19784f = RequestCoordinator.RequestState.SUCCESS;
                    return;
                }
                this.f19783e = RequestCoordinator.RequestState.SUCCESS;
                RequestCoordinator requestCoordinator = this.f19779a;
                if (requestCoordinator != null) {
                    requestCoordinator.k(this);
                }
                if (!this.f19784f.b()) {
                    this.f19782d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(InterfaceC1399c interfaceC1399c, InterfaceC1399c interfaceC1399c2) {
        this.f19781c = interfaceC1399c;
        this.f19782d = interfaceC1399c2;
    }

    @Override // o3.InterfaceC1399c
    public void o() {
        synchronized (this.f19780b) {
            try {
                if (!this.f19784f.b()) {
                    this.f19784f = RequestCoordinator.RequestState.PAUSED;
                    this.f19782d.o();
                }
                if (!this.f19783e.b()) {
                    this.f19783e = RequestCoordinator.RequestState.PAUSED;
                    this.f19781c.o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
