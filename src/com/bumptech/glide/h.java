package com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import o3.AbstractC1397a;
import o3.C1401e;
import o3.InterfaceC1399c;
import o3.InterfaceC1400d;
import p3.InterfaceC1438h;
import s3.C1534e;
import s3.C1540k;
import s3.C1541l;

/* compiled from: RequestBuilder.java */
/* loaded from: classes.dex */
public class h<TranscodeType> extends AbstractC1397a<h<TranscodeType>> implements Cloneable {

    /* renamed from: T, reason: collision with root package name */
    public static final C1401e f19344T = new C1401e().f(Z2.c.f5872c).V(Priority.LOW).c0(true);

    /* renamed from: F, reason: collision with root package name */
    public final Context f19345F;

    /* renamed from: G, reason: collision with root package name */
    public final i f19346G;

    /* renamed from: H, reason: collision with root package name */
    public final Class<TranscodeType> f19347H;

    /* renamed from: I, reason: collision with root package name */
    public final b f19348I;

    /* renamed from: J, reason: collision with root package name */
    public final d f19349J;

    /* renamed from: K, reason: collision with root package name */
    public j<?, ? super TranscodeType> f19350K;

    /* renamed from: L, reason: collision with root package name */
    public Object f19351L;

    /* renamed from: M, reason: collision with root package name */
    public List<InterfaceC1400d<TranscodeType>> f19352M;

    /* renamed from: N, reason: collision with root package name */
    public h<TranscodeType> f19353N;

    /* renamed from: O, reason: collision with root package name */
    public h<TranscodeType> f19354O;

    /* renamed from: P, reason: collision with root package name */
    public Float f19355P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f19356Q = true;

    /* renamed from: R, reason: collision with root package name */
    public boolean f19357R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f19358S;

    /* compiled from: RequestBuilder.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19359a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19360b;

        static {
            int[] iArr = new int[Priority.values().length];
            f19360b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19360b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19360b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19360b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f19359a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19359a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f19359a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f19359a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f19359a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f19359a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f19359a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f19359a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public h(b bVar, i iVar, Class<TranscodeType> cls, Context context) {
        this.f19348I = bVar;
        this.f19346G = iVar;
        this.f19347H = cls;
        this.f19345F = context;
        this.f19350K = iVar.q(cls);
        this.f19349J = bVar.i();
        p0(iVar.o());
        a(iVar.p());
    }

    @Override // o3.AbstractC1397a
    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (!super.equals(hVar) || !Objects.equals(this.f19347H, hVar.f19347H) || !this.f19350K.equals(hVar.f19350K) || !Objects.equals(this.f19351L, hVar.f19351L) || !Objects.equals(this.f19352M, hVar.f19352M) || !Objects.equals(this.f19353N, hVar.f19353N) || !Objects.equals(this.f19354O, hVar.f19354O) || !Objects.equals(this.f19355P, hVar.f19355P) || this.f19356Q != hVar.f19356Q || this.f19357R != hVar.f19357R) {
            return false;
        }
        return true;
    }

    @Override // o3.AbstractC1397a
    public int hashCode() {
        return C1541l.p(this.f19357R, C1541l.p(this.f19356Q, C1541l.o(this.f19355P, C1541l.o(this.f19354O, C1541l.o(this.f19353N, C1541l.o(this.f19352M, C1541l.o(this.f19351L, C1541l.o(this.f19350K, C1541l.o(this.f19347H, super.hashCode())))))))));
    }

    public h<TranscodeType> i0(InterfaceC1400d<TranscodeType> interfaceC1400d) {
        if (B()) {
            return clone().i0(interfaceC1400d);
        }
        if (interfaceC1400d != null) {
            if (this.f19352M == null) {
                this.f19352M = new ArrayList();
            }
            this.f19352M.add(interfaceC1400d);
        }
        return Y();
    }

    @Override // o3.AbstractC1397a
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> a(AbstractC1397a<?> abstractC1397a) {
        C1540k.d(abstractC1397a);
        return (h) super.a(abstractC1397a);
    }

    public final InterfaceC1399c k0(InterfaceC1438h<TranscodeType> interfaceC1438h, InterfaceC1400d<TranscodeType> interfaceC1400d, AbstractC1397a<?> abstractC1397a, Executor executor) {
        return l0(new Object(), interfaceC1438h, interfaceC1400d, null, this.f19350K, abstractC1397a.t(), abstractC1397a.q(), abstractC1397a.p(), abstractC1397a, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InterfaceC1399c l0(Object obj, InterfaceC1438h<TranscodeType> interfaceC1438h, InterfaceC1400d<TranscodeType> interfaceC1400d, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, AbstractC1397a<?> abstractC1397a, Executor executor) {
        com.bumptech.glide.request.a aVar;
        RequestCoordinator requestCoordinator2;
        if (this.f19354O != null) {
            requestCoordinator2 = new com.bumptech.glide.request.a(obj, requestCoordinator);
            aVar = requestCoordinator2;
        } else {
            aVar = 0;
            requestCoordinator2 = requestCoordinator;
        }
        InterfaceC1399c m02 = m0(obj, interfaceC1438h, interfaceC1400d, requestCoordinator2, jVar, priority, i10, i11, abstractC1397a, executor);
        if (aVar == 0) {
            return m02;
        }
        int q10 = this.f19354O.q();
        int p10 = this.f19354O.p();
        if (C1541l.t(i10, i11) && !this.f19354O.L()) {
            q10 = abstractC1397a.q();
            p10 = abstractC1397a.p();
        }
        h<TranscodeType> hVar = this.f19354O;
        aVar.p(m02, hVar.l0(obj, interfaceC1438h, interfaceC1400d, aVar, hVar.f19350K, hVar.t(), q10, p10, this.f19354O, executor));
        return aVar;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [o3.a] */
    public final InterfaceC1399c m0(Object obj, InterfaceC1438h<TranscodeType> interfaceC1438h, InterfaceC1400d<TranscodeType> interfaceC1400d, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, AbstractC1397a<?> abstractC1397a, Executor executor) {
        j<?, ? super TranscodeType> jVar2;
        Priority o02;
        h<TranscodeType> hVar = this.f19353N;
        if (hVar != null) {
            if (!this.f19358S) {
                j<?, ? super TranscodeType> jVar3 = hVar.f19350K;
                if (hVar.f19356Q) {
                    jVar2 = jVar;
                } else {
                    jVar2 = jVar3;
                }
                if (hVar.E()) {
                    o02 = this.f19353N.t();
                } else {
                    o02 = o0(priority);
                }
                Priority priority2 = o02;
                int q10 = this.f19353N.q();
                int p10 = this.f19353N.p();
                if (C1541l.t(i10, i11) && !this.f19353N.L()) {
                    q10 = abstractC1397a.q();
                    p10 = abstractC1397a.p();
                }
                com.bumptech.glide.request.b bVar = new com.bumptech.glide.request.b(obj, requestCoordinator);
                InterfaceC1399c y02 = y0(obj, interfaceC1438h, interfaceC1400d, abstractC1397a, bVar, jVar, priority, i10, i11, executor);
                this.f19358S = true;
                h<TranscodeType> hVar2 = this.f19353N;
                InterfaceC1399c l02 = hVar2.l0(obj, interfaceC1438h, interfaceC1400d, bVar, jVar2, priority2, q10, p10, hVar2, executor);
                this.f19358S = false;
                bVar.n(y02, l02);
                return bVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.f19355P != null) {
            com.bumptech.glide.request.b bVar2 = new com.bumptech.glide.request.b(obj, requestCoordinator);
            bVar2.n(y0(obj, interfaceC1438h, interfaceC1400d, abstractC1397a, bVar2, jVar, priority, i10, i11, executor), y0(obj, interfaceC1438h, interfaceC1400d, abstractC1397a.clone().b0(this.f19355P.floatValue()), bVar2, jVar, o0(priority), i10, i11, executor));
            return bVar2;
        }
        return y0(obj, interfaceC1438h, interfaceC1400d, abstractC1397a, requestCoordinator, jVar, priority, i10, i11, executor);
    }

    @Override // o3.AbstractC1397a
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public h<TranscodeType> clone() {
        h<TranscodeType> hVar = (h) super.clone();
        hVar.f19350K = (j<?, ? super TranscodeType>) hVar.f19350K.clone();
        if (hVar.f19352M != null) {
            hVar.f19352M = new ArrayList(hVar.f19352M);
        }
        h<TranscodeType> hVar2 = hVar.f19353N;
        if (hVar2 != null) {
            hVar.f19353N = hVar2.clone();
        }
        h<TranscodeType> hVar3 = hVar.f19354O;
        if (hVar3 != null) {
            hVar.f19354O = hVar3.clone();
        }
        return hVar;
    }

    public final Priority o0(Priority priority) {
        int i10 = a.f19360b[priority.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3 && i10 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + t());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    public final void p0(List<InterfaceC1400d<Object>> list) {
        Iterator<InterfaceC1400d<Object>> it = list.iterator();
        while (it.hasNext()) {
            i0((InterfaceC1400d) it.next());
        }
    }

    public <Y extends InterfaceC1438h<TranscodeType>> Y q0(Y y10) {
        return (Y) r0(y10, null, C1534e.b());
    }

    public <Y extends InterfaceC1438h<TranscodeType>> Y r0(Y y10, InterfaceC1400d<TranscodeType> interfaceC1400d, Executor executor) {
        return (Y) s0(y10, interfaceC1400d, this, executor);
    }

    public final <Y extends InterfaceC1438h<TranscodeType>> Y s0(Y y10, InterfaceC1400d<TranscodeType> interfaceC1400d, AbstractC1397a<?> abstractC1397a, Executor executor) {
        C1540k.d(y10);
        if (this.f19357R) {
            InterfaceC1399c k02 = k0(y10, interfaceC1400d, abstractC1397a, executor);
            InterfaceC1399c request = y10.getRequest();
            if (k02.g(request) && !u0(abstractC1397a, request)) {
                if (!((InterfaceC1399c) C1540k.d(request)).isRunning()) {
                    request.h();
                }
                return y10;
            }
            this.f19346G.m(y10);
            y10.f(k02);
            this.f19346G.x(y10, k02);
            return y10;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public p3.i<ImageView, TranscodeType> t0(ImageView imageView) {
        h<TranscodeType> hVar;
        C1541l.a();
        C1540k.d(imageView);
        if (!K() && I() && imageView.getScaleType() != null) {
            switch (a.f19359a[imageView.getScaleType().ordinal()]) {
                case 1:
                    hVar = clone().N();
                    break;
                case 2:
                    hVar = clone().O();
                    break;
                case 3:
                case 4:
                case 5:
                    hVar = clone().P();
                    break;
                case 6:
                    hVar = clone().O();
                    break;
            }
            return (p3.i) s0(this.f19349J.a(imageView, this.f19347H), null, hVar, C1534e.b());
        }
        hVar = this;
        return (p3.i) s0(this.f19349J.a(imageView, this.f19347H), null, hVar, C1534e.b());
    }

    public final boolean u0(AbstractC1397a<?> abstractC1397a, InterfaceC1399c interfaceC1399c) {
        if (!abstractC1397a.D() && interfaceC1399c.j()) {
            return true;
        }
        return false;
    }

    public h<TranscodeType> v0(Object obj) {
        return x0(obj);
    }

    public h<TranscodeType> w0(String str) {
        return x0(str);
    }

    public final h<TranscodeType> x0(Object obj) {
        if (B()) {
            return clone().x0(obj);
        }
        this.f19351L = obj;
        this.f19357R = true;
        return Y();
    }

    public final InterfaceC1399c y0(Object obj, InterfaceC1438h<TranscodeType> interfaceC1438h, InterfaceC1400d<TranscodeType> interfaceC1400d, AbstractC1397a<?> abstractC1397a, RequestCoordinator requestCoordinator, j<?, ? super TranscodeType> jVar, Priority priority, int i10, int i11, Executor executor) {
        Context context = this.f19345F;
        d dVar = this.f19349J;
        return SingleRequest.z(context, dVar, obj, this.f19351L, this.f19347H, abstractC1397a, i10, i11, priority, interfaceC1438h, interfaceC1400d, this.f19352M, requestCoordinator, dVar.f(), jVar.b(), executor);
    }
}
