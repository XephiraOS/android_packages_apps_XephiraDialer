package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.C1268n;
import kotlinx.coroutines.C1272p;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.Q0;
import kotlinx.coroutines.internal.A;
import kotlinx.coroutines.internal.AbstractC1254e;
import kotlinx.coroutines.internal.B;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.C1253d;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import m9.q;
import p9.C1467a;
import p9.C1472f;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public class BufferedChannel<E> implements kotlinx.coroutines.channels.a<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34368d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34369e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34370f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f34371g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34372h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34373i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34374j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34375k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34376l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* renamed from: a, reason: collision with root package name */
    public final int f34377a;

    /* renamed from: b, reason: collision with root package name */
    public final v9.l<E, q> f34378b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c, reason: collision with root package name */
    public final v9.q<F9.b<?>, Object, Object, v9.l<Throwable, q>> f34379c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* compiled from: BufferedChannel.kt */
    /* loaded from: classes4.dex */
    public final class a implements c<E>, Q0 {

        /* renamed from: a, reason: collision with root package name */
        public Object f34380a;

        /* renamed from: b, reason: collision with root package name */
        public C1268n<? super Boolean> f34381b;

        public a() {
            C c10;
            c10 = BufferedChannelKt.f34400p;
            this.f34380a = c10;
        }

        @Override // kotlinx.coroutines.channels.c
        public Object a(kotlin.coroutines.c<? super Boolean> cVar) {
            f<E> fVar;
            C c10;
            C c11;
            C c12;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            f<E> fVar2 = (f) BufferedChannel.f34373i.get(bufferedChannel);
            while (!bufferedChannel.Q()) {
                long andIncrement = BufferedChannel.f34369e.getAndIncrement(bufferedChannel);
                int i10 = BufferedChannelKt.f34386b;
                long j10 = andIncrement / i10;
                int i11 = (int) (andIncrement % i10);
                if (fVar2.f34541c != j10) {
                    f<E> C10 = bufferedChannel.C(j10, fVar2);
                    if (C10 == null) {
                        continue;
                    } else {
                        fVar = C10;
                    }
                } else {
                    fVar = fVar2;
                }
                Object t02 = bufferedChannel.t0(fVar, i11, andIncrement, null);
                c10 = BufferedChannelKt.f34397m;
                if (t02 != c10) {
                    c11 = BufferedChannelKt.f34399o;
                    if (t02 != c11) {
                        c12 = BufferedChannelKt.f34398n;
                        if (t02 == c12) {
                            return f(fVar, i11, andIncrement, cVar);
                        }
                        fVar.b();
                        this.f34380a = t02;
                        return C1467a.a(true);
                    }
                    if (andIncrement < bufferedChannel.J()) {
                        fVar.b();
                    }
                    fVar2 = fVar;
                } else {
                    throw new IllegalStateException("unreachable".toString());
                }
            }
            return C1467a.a(g());
        }

        @Override // kotlinx.coroutines.Q0
        public void c(z<?> zVar, int i10) {
            C1268n<? super Boolean> c1268n = this.f34381b;
            if (c1268n != null) {
                c1268n.c(zVar, i10);
            }
        }

        public final Object f(f<E> fVar, int i10, long j10, kotlin.coroutines.c<? super Boolean> cVar) {
            kotlin.coroutines.c b10;
            C c10;
            C c11;
            Boolean a10;
            C c12;
            C c13;
            C c14;
            Object c15;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
            C1268n b11 = C1272p.b(b10);
            try {
                this.f34381b = b11;
                Object t02 = bufferedChannel.t0(fVar, i10, j10, this);
                c10 = BufferedChannelKt.f34397m;
                if (t02 == c10) {
                    bufferedChannel.g0(this, fVar, i10);
                } else {
                    c11 = BufferedChannelKt.f34399o;
                    v9.l<Throwable, q> lVar = null;
                    if (t02 == c11) {
                        if (j10 < bufferedChannel.J()) {
                            fVar.b();
                        }
                        f fVar2 = (f) BufferedChannel.f34373i.get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.Q()) {
                                h();
                                break;
                            }
                            long andIncrement = BufferedChannel.f34369e.getAndIncrement(bufferedChannel);
                            int i11 = BufferedChannelKt.f34386b;
                            long j11 = andIncrement / i11;
                            int i12 = (int) (andIncrement % i11);
                            if (fVar2.f34541c != j11) {
                                f C10 = bufferedChannel.C(j11, fVar2);
                                if (C10 != null) {
                                    fVar2 = C10;
                                }
                            }
                            Object t03 = bufferedChannel.t0(fVar2, i12, andIncrement, this);
                            c12 = BufferedChannelKt.f34397m;
                            if (t03 == c12) {
                                bufferedChannel.g0(this, fVar2, i12);
                                break;
                            }
                            c13 = BufferedChannelKt.f34399o;
                            if (t03 != c13) {
                                c14 = BufferedChannelKt.f34398n;
                                if (t03 != c14) {
                                    fVar2.b();
                                    this.f34380a = t03;
                                    this.f34381b = null;
                                    a10 = C1467a.a(true);
                                    v9.l<E, q> lVar2 = bufferedChannel.f34378b;
                                    if (lVar2 != null) {
                                        lVar = OnUndeliveredElementKt.a(lVar2, t03, b11.getContext());
                                    }
                                } else {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                            } else if (andIncrement < bufferedChannel.J()) {
                                fVar2.b();
                            }
                        }
                    } else {
                        fVar.b();
                        this.f34380a = t02;
                        this.f34381b = null;
                        a10 = C1467a.a(true);
                        v9.l<E, q> lVar3 = bufferedChannel.f34378b;
                        if (lVar3 != null) {
                            lVar = OnUndeliveredElementKt.a(lVar3, t02, b11.getContext());
                        }
                    }
                    b11.b(a10, lVar);
                }
                Object x10 = b11.x();
                c15 = kotlin.coroutines.intrinsics.b.c();
                if (x10 == c15) {
                    C1472f.c(cVar);
                }
                return x10;
            } catch (Throwable th) {
                b11.J();
                throw th;
            }
        }

        public final boolean g() {
            this.f34380a = BufferedChannelKt.z();
            Throwable F10 = BufferedChannel.this.F();
            if (F10 == null) {
                return false;
            }
            throw B.a(F10);
        }

        public final void h() {
            C1268n<? super Boolean> c1268n = this.f34381b;
            kotlin.jvm.internal.i.c(c1268n);
            this.f34381b = null;
            this.f34380a = BufferedChannelKt.z();
            Throwable F10 = BufferedChannel.this.F();
            if (F10 == null) {
                Result.a aVar = Result.f34166a;
                c1268n.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.f34166a;
                c1268n.resumeWith(Result.b(kotlin.b.a(F10)));
            }
        }

        public final boolean i(E e10) {
            boolean B10;
            C1268n<? super Boolean> c1268n = this.f34381b;
            kotlin.jvm.internal.i.c(c1268n);
            v9.l<Throwable, q> lVar = null;
            this.f34381b = null;
            this.f34380a = e10;
            Boolean bool = Boolean.TRUE;
            v9.l<E, q> lVar2 = BufferedChannel.this.f34378b;
            if (lVar2 != null) {
                lVar = OnUndeliveredElementKt.a(lVar2, e10, c1268n.getContext());
            }
            B10 = BufferedChannelKt.B(c1268n, bool, lVar);
            return B10;
        }

        public final void j() {
            C1268n<? super Boolean> c1268n = this.f34381b;
            kotlin.jvm.internal.i.c(c1268n);
            this.f34381b = null;
            this.f34380a = BufferedChannelKt.z();
            Throwable F10 = BufferedChannel.this.F();
            if (F10 == null) {
                Result.a aVar = Result.f34166a;
                c1268n.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.a aVar2 = Result.f34166a;
                c1268n.resumeWith(Result.b(kotlin.b.a(F10)));
            }
        }

        @Override // kotlinx.coroutines.channels.c
        public E next() {
            C c10;
            C c11;
            E e10 = (E) this.f34380a;
            c10 = BufferedChannelKt.f34400p;
            if (e10 != c10) {
                c11 = BufferedChannelKt.f34400p;
                this.f34380a = c11;
                if (e10 != BufferedChannelKt.z()) {
                    return e10;
                }
                throw B.a(BufferedChannel.this.G());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }
    }

    /* compiled from: BufferedChannel.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Q0 {

        /* renamed from: a, reason: collision with root package name */
        public final InterfaceC1266m<Boolean> f34383a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C1268n<Boolean> f34384b;

        public final InterfaceC1266m<Boolean> a() {
            return this.f34383a;
        }

        @Override // kotlinx.coroutines.Q0
        public void c(z<?> zVar, int i10) {
            this.f34384b.c(zVar, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [v9.l<E, m9.q>, v9.l<? super E, m9.q>] */
    public BufferedChannel(int i10, v9.l<? super E, q> lVar) {
        long A10;
        v9.q qVar;
        C c10;
        this.f34377a = i10;
        this.f34378b = lVar;
        if (i10 >= 0) {
            A10 = BufferedChannelKt.A(i10);
            this.bufferEnd = A10;
            this.completedExpandBuffersAndPauseFlag = E();
            f fVar = new f(0L, null, this, 3);
            this.sendSegment = fVar;
            this.receiveSegment = fVar;
            if (V()) {
                fVar = BufferedChannelKt.f34385a;
                kotlin.jvm.internal.i.d(fVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = fVar;
            if (lVar != 0) {
                qVar = new v9.q<F9.b<?>, Object, Object, v9.l<? super Throwable, ? extends q>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1
                    final /* synthetic */ BufferedChannel<E> this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                        this.this$0 = this;
                    }

                    @Override // v9.q
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public final v9.l<Throwable, q> d(final F9.b<?> bVar, Object obj, final Object obj2) {
                        final BufferedChannel<E> bufferedChannel = this.this$0;
                        return new v9.l<Throwable, q>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public final void b(Throwable th) {
                                if (obj2 != BufferedChannelKt.z()) {
                                    OnUndeliveredElementKt.b(bufferedChannel.f34378b, obj2, bVar.getContext());
                                }
                            }

                            @Override // v9.l
                            public /* bridge */ /* synthetic */ q invoke(Throwable th) {
                                b(th);
                                return q.f35511a;
                            }
                        };
                    }
                };
            } else {
                qVar = null;
            }
            this.f34379c = qVar;
            c10 = BufferedChannelKt.f34403s;
            this._closeCause = c10;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
    }

    public static /* synthetic */ void M(BufferedChannel bufferedChannel, long j10, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                j10 = 1;
            }
            bufferedChannel.L(j10);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    public static /* synthetic */ <E> Object m0(BufferedChannel<E> bufferedChannel, E e10, kotlin.coroutines.c<? super q> cVar) {
        Object c10;
        Object c11;
        Object c12;
        Object c13;
        f<E> fVar = (f) f34372h.get(bufferedChannel);
        while (true) {
            long andIncrement = f34368d.getAndIncrement(bufferedChannel);
            long j10 = 1152921504606846975L & andIncrement;
            boolean T10 = bufferedChannel.T(andIncrement);
            int i10 = BufferedChannelKt.f34386b;
            long j11 = j10 / i10;
            int i11 = (int) (j10 % i10);
            if (fVar.f34541c != j11) {
                f<E> D10 = bufferedChannel.D(j11, fVar);
                if (D10 == null) {
                    if (T10) {
                        Object c02 = bufferedChannel.c0(e10, cVar);
                        c13 = kotlin.coroutines.intrinsics.b.c();
                        if (c02 == c13) {
                            return c02;
                        }
                    }
                } else {
                    fVar = D10;
                }
            }
            int v02 = bufferedChannel.v0(fVar, i11, e10, j10, null, T10);
            if (v02 != 0) {
                if (v02 == 1) {
                    break;
                }
                if (v02 != 2) {
                    if (v02 != 3) {
                        if (v02 != 4) {
                            if (v02 == 5) {
                                fVar.b();
                            }
                        } else {
                            if (j10 < bufferedChannel.H()) {
                                fVar.b();
                            }
                            Object c03 = bufferedChannel.c0(e10, cVar);
                            c12 = kotlin.coroutines.intrinsics.b.c();
                            if (c03 == c12) {
                                return c03;
                            }
                        }
                    } else {
                        Object n02 = bufferedChannel.n0(fVar, i11, e10, j10, cVar);
                        c11 = kotlin.coroutines.intrinsics.b.c();
                        if (n02 == c11) {
                            return n02;
                        }
                    }
                } else if (T10) {
                    fVar.p();
                    Object c04 = bufferedChannel.c0(e10, cVar);
                    c10 = kotlin.coroutines.intrinsics.b.c();
                    if (c04 == c10) {
                        return c04;
                    }
                }
            } else {
                fVar.b();
                break;
            }
        }
        return q.f35511a;
    }

    public final void A() {
        if (V()) {
            return;
        }
        f<E> fVar = (f) f34374j.get(this);
        while (true) {
            long andIncrement = f34370f.getAndIncrement(this);
            int i10 = BufferedChannelKt.f34386b;
            long j10 = andIncrement / i10;
            if (J() <= andIncrement) {
                if (fVar.f34541c < j10 && fVar.e() != 0) {
                    a0(j10, fVar);
                }
                M(this, 0L, 1, null);
                return;
            }
            if (fVar.f34541c != j10) {
                f<E> B10 = B(j10, fVar, andIncrement);
                if (B10 == null) {
                    continue;
                } else {
                    fVar = B10;
                }
            }
            if (r0(fVar, (int) (andIncrement % i10), andIncrement)) {
                M(this, 0L, 1, null);
                return;
            }
            M(this, 0L, 1, null);
        }
    }

    public final f<E> B(long j10, f<E> fVar, long j11) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34374j;
        v9.p pVar = (v9.p) BufferedChannelKt.y();
        loop0: while (true) {
            c10 = C1253d.c(fVar, j10, pVar);
            if (!A.c(c10)) {
                z b10 = A.b(c10);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f34541c >= b10.f34541c) {
                        break loop0;
                    }
                    if (!b10.q()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(c10)) {
            y();
            a0(j10, fVar);
            M(this, 0L, 1, null);
            return null;
        }
        f<E> fVar2 = (f) A.b(c10);
        long j12 = fVar2.f34541c;
        if (j12 > j10) {
            int i10 = BufferedChannelKt.f34386b;
            if (f34370f.compareAndSet(this, j11 + 1, i10 * j12)) {
                L((fVar2.f34541c * i10) - j11);
                return null;
            }
            M(this, 0L, 1, null);
            return null;
        }
        return fVar2;
    }

    public final f<E> C(long j10, f<E> fVar) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34373i;
        v9.p pVar = (v9.p) BufferedChannelKt.y();
        loop0: while (true) {
            c10 = C1253d.c(fVar, j10, pVar);
            if (!A.c(c10)) {
                z b10 = A.b(c10);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f34541c >= b10.f34541c) {
                        break loop0;
                    }
                    if (!b10.q()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(c10)) {
            y();
            if (fVar.f34541c * BufferedChannelKt.f34386b >= J()) {
                return null;
            }
            fVar.b();
            return null;
        }
        f<E> fVar2 = (f) A.b(c10);
        if (!V() && j10 <= E() / BufferedChannelKt.f34386b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f34374j;
            while (true) {
                z zVar2 = (z) atomicReferenceFieldUpdater2.get(this);
                if (zVar2.f34541c >= fVar2.f34541c || !fVar2.q()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, zVar2, fVar2)) {
                    if (zVar2.m()) {
                        zVar2.k();
                    }
                } else if (fVar2.m()) {
                    fVar2.k();
                }
            }
        }
        long j11 = fVar2.f34541c;
        if (j11 > j10) {
            int i10 = BufferedChannelKt.f34386b;
            x0(j11 * i10);
            if (fVar2.f34541c * i10 >= J()) {
                return null;
            }
            fVar2.b();
            return null;
        }
        return fVar2;
    }

    public final f<E> D(long j10, f<E> fVar) {
        Object c10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34372h;
        v9.p pVar = (v9.p) BufferedChannelKt.y();
        loop0: while (true) {
            c10 = C1253d.c(fVar, j10, pVar);
            if (!A.c(c10)) {
                z b10 = A.b(c10);
                while (true) {
                    z zVar = (z) atomicReferenceFieldUpdater.get(this);
                    if (zVar.f34541c >= b10.f34541c) {
                        break loop0;
                    }
                    if (!b10.q()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, zVar, b10)) {
                        if (zVar.m()) {
                            zVar.k();
                        }
                    } else if (b10.m()) {
                        b10.k();
                    }
                }
            } else {
                break;
            }
        }
        if (A.c(c10)) {
            y();
            if (fVar.f34541c * BufferedChannelKt.f34386b >= H()) {
                return null;
            }
            fVar.b();
            return null;
        }
        f<E> fVar2 = (f) A.b(c10);
        long j11 = fVar2.f34541c;
        if (j11 > j10) {
            int i10 = BufferedChannelKt.f34386b;
            y0(j11 * i10);
            if (fVar2.f34541c * i10 >= H()) {
                return null;
            }
            fVar2.b();
            return null;
        }
        return fVar2;
    }

    public final long E() {
        return f34370f.get(this);
    }

    public final Throwable F() {
        return (Throwable) f34375k.get(this);
    }

    public final Throwable G() {
        Throwable F10 = F();
        if (F10 == null) {
            return new ClosedReceiveChannelException("Channel was closed");
        }
        return F10;
    }

    public final long H() {
        return f34369e.get(this);
    }

    public final Throwable I() {
        Throwable F10 = F();
        if (F10 == null) {
            return new ClosedSendChannelException("Channel was closed");
        }
        return F10;
    }

    public final long J() {
        return f34368d.get(this) & 1152921504606846975L;
    }

    public final boolean K() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34373i;
            f<E> fVar = (f) atomicReferenceFieldUpdater.get(this);
            long H10 = H();
            if (J() <= H10) {
                return false;
            }
            int i10 = BufferedChannelKt.f34386b;
            long j10 = H10 / i10;
            if (fVar.f34541c != j10 && (fVar = C(j10, fVar)) == null) {
                if (((f) atomicReferenceFieldUpdater.get(this)).f34541c < j10) {
                    return false;
                }
            } else {
                fVar.b();
                if (O(fVar, (int) (H10 % i10), H10)) {
                    return true;
                }
                f34369e.compareAndSet(this, H10, H10 + 1);
            }
        }
    }

    public final void L(long j10) {
        if ((f34371g.addAndGet(this, j10) & 4611686018427387904L) == 0) {
            return;
        }
        do {
        } while ((f34371g.get(this) & 4611686018427387904L) != 0);
    }

    public final void N() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34376l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? BufferedChannelKt.f34401q : BufferedChannelKt.f34402r));
        if (obj == null) {
            return;
        }
        ((v9.l) obj).invoke(F());
    }

    public final boolean O(f<E> fVar, int i10, long j10) {
        Object w10;
        C c10;
        C c11;
        C c12;
        C c13;
        C c14;
        C c15;
        C c16;
        do {
            w10 = fVar.w(i10);
            if (w10 != null) {
                c11 = BufferedChannelKt.f34389e;
                if (w10 != c11) {
                    if (w10 != BufferedChannelKt.f34388d) {
                        c12 = BufferedChannelKt.f34394j;
                        if (w10 != c12 && w10 != BufferedChannelKt.z()) {
                            c13 = BufferedChannelKt.f34393i;
                            if (w10 != c13) {
                                c14 = BufferedChannelKt.f34392h;
                                if (w10 != c14) {
                                    c15 = BufferedChannelKt.f34391g;
                                    if (w10 != c15) {
                                        c16 = BufferedChannelKt.f34390f;
                                        if (w10 == c16 || j10 != H()) {
                                            return false;
                                        }
                                        return true;
                                    }
                                    return true;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return true;
                }
            }
            c10 = BufferedChannelKt.f34392h;
        } while (!fVar.r(i10, w10, c10));
        A();
        return false;
    }

    public final boolean P(long j10, boolean z10) {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                w(j10 & 1152921504606846975L);
            } else {
                throw new IllegalStateException(("unexpected close status: " + i10).toString());
            }
        } else {
            x(j10 & 1152921504606846975L);
            if (z10 && K()) {
                return false;
            }
        }
        return true;
    }

    public boolean Q() {
        return R(f34368d.get(this));
    }

    public final boolean R(long j10) {
        return P(j10, true);
    }

    public boolean S() {
        return T(f34368d.get(this));
    }

    public final boolean T(long j10) {
        return P(j10, false);
    }

    public boolean U() {
        return false;
    }

    public final boolean V() {
        long E10 = E();
        if (E10 != 0 && E10 != Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.f) r8.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long W(kotlinx.coroutines.channels.f<E> r8) {
        /*
            r7 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f34541c
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.H()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.w(r0)
            if (r1 == 0) goto L2c
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.f34388d
            if (r1 != r2) goto L39
            return r3
        L2c:
            kotlinx.coroutines.internal.C r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r8.r(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.p()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            kotlinx.coroutines.internal.e r8 = r8.g()
            kotlinx.coroutines.channels.f r8 = (kotlinx.coroutines.channels.f) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.W(kotlinx.coroutines.channels.f):long");
    }

    public final void X() {
        long j10;
        long w10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34368d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) == 0) {
                w10 = BufferedChannelKt.w(1152921504606846975L & j10, 1);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, w10));
    }

    public final void Y() {
        long j10;
        long w10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34368d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            w10 = BufferedChannelKt.w(1152921504606846975L & j10, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, w10));
    }

    public final void Z() {
        long j10;
        long w10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34368d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                w10 = BufferedChannelKt.w(j10 & 1152921504606846975L, 2);
            } else if (i10 == 1) {
                w10 = BufferedChannelKt.w(j10 & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, w10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a0(long r5, kotlinx.coroutines.channels.f<E> r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f34541c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            kotlinx.coroutines.internal.e r0 = r7.e()
            kotlinx.coroutines.channels.f r0 = (kotlinx.coroutines.channels.f) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.h()
            if (r5 == 0) goto L22
            kotlinx.coroutines.internal.e r5 = r7.e()
            kotlinx.coroutines.channels.f r5 = (kotlinx.coroutines.channels.f) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.channels.BufferedChannel.f34374j
        L24:
            java.lang.Object r6 = r5.get(r4)
            kotlinx.coroutines.internal.z r6 = (kotlinx.coroutines.internal.z) r6
            long r0 = r6.f34541c
            long r2 = r7.f34541c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.q()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r4 = r6.m()
            if (r4 == 0) goto L49
            r6.k()
        L49:
            return
        L4a:
            boolean r6 = r7.m()
            if (r6 == 0) goto L24
            r7.k()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.a0(long, kotlinx.coroutines.channels.f):void");
    }

    public final Object c0(E e10, kotlin.coroutines.c<? super q> cVar) {
        kotlin.coroutines.c b10;
        Object c10;
        Object c11;
        UndeliveredElementException d10;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
        C1268n c1268n = new C1268n(b10, 1);
        c1268n.A();
        v9.l<E, q> lVar = this.f34378b;
        if (lVar != null && (d10 = OnUndeliveredElementKt.d(lVar, e10, null, 2, null)) != null) {
            m9.b.a(d10, I());
            Result.a aVar = Result.f34166a;
            c1268n.resumeWith(Result.b(kotlin.b.a(d10)));
        } else {
            Throwable I10 = I();
            Result.a aVar2 = Result.f34166a;
            c1268n.resumeWith(Result.b(kotlin.b.a(I10)));
        }
        Object x10 = c1268n.x();
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c10) {
            C1472f.c(cVar);
        }
        c11 = kotlin.coroutines.intrinsics.b.c();
        if (x10 == c11) {
            return x10;
        }
        return q.f35511a;
    }

    @Override // kotlinx.coroutines.channels.o
    public boolean d(Throwable th) {
        return v(th, false);
    }

    public final void d0(E e10, InterfaceC1266m<? super q> interfaceC1266m) {
        v9.l<E, q> lVar = this.f34378b;
        if (lVar != null) {
            OnUndeliveredElementKt.b(lVar, e10, interfaceC1266m.getContext());
        }
        Throwable I10 = I();
        Result.a aVar = Result.f34166a;
        interfaceC1266m.resumeWith(Result.b(kotlin.b.a(I10)));
    }

    @Override // kotlinx.coroutines.channels.n
    public final void e(CancellationException cancellationException) {
        s(cancellationException);
    }

    public final void g0(Q0 q02, f<E> fVar, int i10) {
        f0();
        q02.c(fVar, i10);
    }

    public final void h0(Q0 q02, f<E> fVar, int i10) {
        q02.c(fVar, i10 + BufferedChannelKt.f34386b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.f) r12.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i0(kotlinx.coroutines.channels.f<E> r12) {
        /*
            r11 = this;
            v9.l<E, m9.q> r0 = r11.f34378b
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.k.b(r1, r2, r1)
        L8:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.f34541c
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.w(r4)
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.f34388d
            if (r8 != r9) goto L48
            long r9 = r11.H()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L40:
            r12.s(r4)
            r12.p()
            goto Laf
        L48:
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof kotlinx.coroutines.Q0
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.p
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto Lbb
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.H()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.p
            if (r9 == 0) goto L80
            r9 = r8
            kotlinx.coroutines.channels.p r9 = (kotlinx.coroutines.channels.p) r9
            kotlinx.coroutines.Q0 r9 = r9.f34418a
            goto L83
        L80:
            r9 = r8
            kotlinx.coroutines.Q0 r9 = (kotlinx.coroutines.Q0) r9
        L83:
            kotlinx.coroutines.internal.C r10 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.v(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.c(r0, r5, r1)
        L97:
            java.lang.Object r3 = kotlinx.coroutines.internal.k.c(r3, r9)
            r12.s(r4)
            r12.p()
            goto Laf
        La2:
            kotlinx.coroutines.internal.C r9 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.p()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            kotlinx.coroutines.internal.e r12 = r12.g()
            kotlinx.coroutines.channels.f r12 = (kotlinx.coroutines.channels.f) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            kotlinx.coroutines.Q0 r3 = (kotlinx.coroutines.Q0) r3
            r11.k0(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.i.d(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Q0 r0 = (kotlinx.coroutines.Q0) r0
            r11.k0(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.i0(kotlinx.coroutines.channels.f):void");
    }

    @Override // kotlinx.coroutines.channels.n
    public c<E> iterator() {
        return new a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return kotlinx.coroutines.channels.e.f34409b.c(m9.q.f35511a);
     */
    @Override // kotlinx.coroutines.channels.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.f34368d
            long r0 = r0.get(r14)
            boolean r0 = r14.o0(r0)
            if (r0 == 0) goto L13
            kotlinx.coroutines.channels.e$b r14 = kotlinx.coroutines.channels.e.f34409b
            java.lang.Object r14 = r14.b()
            return r14
        L13:
            kotlinx.coroutines.internal.C r8 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = h()
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.f r0 = (kotlinx.coroutines.channels.f) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = l(r14, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f34386b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f34541c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L59
            kotlinx.coroutines.channels.f r1 = b(r14, r2, r0)
            if (r1 != 0) goto L57
            if (r11 == 0) goto L21
        L4b:
            kotlinx.coroutines.channels.e$b r15 = kotlinx.coroutines.channels.e.f34409b
            java.lang.Throwable r14 = r14.I()
            java.lang.Object r14 = r15.a(r14)
            goto Lbe
        L57:
            r13 = r1
            goto L5a
        L59:
            r13 = r0
        L5a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = q(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lba
            r1 = 1
            if (r0 == r1) goto Lb1
            r1 = 2
            if (r0 == r1) goto L94
            r1 = 3
            if (r0 == r1) goto L88
            r1 = 4
            if (r0 == r1) goto L7c
            r1 = 5
            if (r0 == r1) goto L77
            goto L7a
        L77:
            r13.b()
        L7a:
            r0 = r13
            goto L21
        L7c:
            long r0 = r14.H()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4b
            r13.b()
            goto L4b
        L88:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L94:
            if (r11 == 0) goto L9a
            r13.p()
            goto L4b
        L9a:
            boolean r15 = r8 instanceof kotlinx.coroutines.Q0
            if (r15 == 0) goto La1
            kotlinx.coroutines.Q0 r8 = (kotlinx.coroutines.Q0) r8
            goto La2
        La1:
            r8 = 0
        La2:
            if (r8 == 0) goto La7
            o(r14, r8, r13, r12)
        La7:
            r13.p()
            kotlinx.coroutines.channels.e$b r14 = kotlinx.coroutines.channels.e.f34409b
            java.lang.Object r14 = r14.b()
            goto Lbe
        Lb1:
            kotlinx.coroutines.channels.e$b r14 = kotlinx.coroutines.channels.e.f34409b
            m9.q r15 = m9.q.f35511a
            java.lang.Object r14 = r14.c(r15)
            goto Lbe
        Lba:
            r13.b()
            goto Lb1
        Lbe:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.j(java.lang.Object):java.lang.Object");
    }

    public final void j0(Q0 q02) {
        l0(q02, true);
    }

    @Override // kotlinx.coroutines.channels.o
    public Object k(E e10, kotlin.coroutines.c<? super q> cVar) {
        return m0(this, e10, cVar);
    }

    public final void k0(Q0 q02) {
        l0(q02, false);
    }

    public final void l0(Q0 q02, boolean z10) {
        Throwable I10;
        if (q02 instanceof b) {
            InterfaceC1266m<Boolean> a10 = ((b) q02).a();
            Result.a aVar = Result.f34166a;
            a10.resumeWith(Result.b(Boolean.FALSE));
            return;
        }
        if (q02 instanceof InterfaceC1266m) {
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) q02;
            Result.a aVar2 = Result.f34166a;
            if (z10) {
                I10 = G();
            } else {
                I10 = I();
            }
            cVar.resumeWith(Result.b(kotlin.b.a(I10)));
            return;
        }
        if (q02 instanceof m) {
            C1268n<e<? extends E>> c1268n = ((m) q02).f34417a;
            Result.a aVar3 = Result.f34166a;
            c1268n.resumeWith(Result.b(e.b(e.f34409b.a(F()))));
        } else if (q02 instanceof a) {
            ((a) q02).j();
        } else {
            if (q02 instanceof F9.b) {
                ((F9.b) q02).b(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + q02).toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n0(kotlinx.coroutines.channels.f<E> r21, int r22, E r23, long r24, kotlin.coroutines.c<? super m9.q> r26) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.n0(kotlinx.coroutines.channels.f, int, java.lang.Object, long, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean o0(long j10) {
        if (T(j10)) {
            return false;
        }
        return !r(j10 & 1152921504606846975L);
    }

    public final boolean p0(Object obj, E e10) {
        boolean B10;
        boolean B11;
        if (obj instanceof F9.b) {
            return ((F9.b) obj).b(this, e10);
        }
        v9.l<Throwable, q> lVar = null;
        if (obj instanceof m) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            m mVar = (m) obj;
            C1268n<e<? extends E>> c1268n = mVar.f34417a;
            e b10 = e.b(e.f34409b.c(e10));
            v9.l<E, q> lVar2 = this.f34378b;
            if (lVar2 != null) {
                lVar = OnUndeliveredElementKt.a(lVar2, e10, mVar.f34417a.getContext());
            }
            B11 = BufferedChannelKt.B(c1268n, b10, lVar);
            return B11;
        }
        if (obj instanceof a) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e10);
        }
        if (obj instanceof InterfaceC1266m) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC1266m interfaceC1266m = (InterfaceC1266m) obj;
            v9.l<E, q> lVar3 = this.f34378b;
            if (lVar3 != null) {
                lVar = OnUndeliveredElementKt.a(lVar3, e10, interfaceC1266m.getContext());
            }
            B10 = BufferedChannelKt.B(interfaceC1266m, e10, lVar);
            return B10;
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean q0(Object obj, f<E> fVar, int i10) {
        if (obj instanceof InterfaceC1266m) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((InterfaceC1266m) obj, q.f35511a, null, 2, null);
        }
        if (obj instanceof F9.b) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult h10 = ((F9.a) obj).h(this, q.f35511a);
            if (h10 == TrySelectDetailedResult.REREGISTER) {
                fVar.s(i10);
            }
            if (h10 == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        }
        if (obj instanceof b) {
            return BufferedChannelKt.C(((b) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final boolean r(long j10) {
        if (j10 >= E() && j10 >= H() + this.f34377a) {
            return false;
        }
        return true;
    }

    public final boolean r0(f<E> fVar, int i10, long j10) {
        C c10;
        C c11;
        Object w10 = fVar.w(i10);
        if ((w10 instanceof Q0) && j10 >= f34369e.get(this)) {
            c10 = BufferedChannelKt.f34391g;
            if (fVar.r(i10, w10, c10)) {
                if (!q0(w10, fVar, i10)) {
                    c11 = BufferedChannelKt.f34394j;
                    fVar.A(i10, c11);
                    fVar.x(i10, false);
                    return false;
                }
                fVar.A(i10, BufferedChannelKt.f34388d);
                return true;
            }
        }
        return s0(fVar, i10, j10);
    }

    public boolean s(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return v(th, true);
    }

    public final boolean s0(f<E> fVar, int i10, long j10) {
        C c10;
        C c11;
        C c12;
        C c13;
        C c14;
        C c15;
        C c16;
        C c17;
        while (true) {
            Object w10 = fVar.w(i10);
            if (!(w10 instanceof Q0)) {
                c12 = BufferedChannelKt.f34394j;
                if (w10 == c12) {
                    return false;
                }
                if (w10 == null) {
                    c13 = BufferedChannelKt.f34389e;
                    if (fVar.r(i10, w10, c13)) {
                        return true;
                    }
                } else if (w10 != BufferedChannelKt.f34388d) {
                    c14 = BufferedChannelKt.f34392h;
                    if (w10 == c14) {
                        break;
                    }
                    c15 = BufferedChannelKt.f34393i;
                    if (w10 == c15) {
                        break;
                    }
                    c16 = BufferedChannelKt.f34395k;
                    if (w10 != c16 && w10 != BufferedChannelKt.z()) {
                        c17 = BufferedChannelKt.f34390f;
                        if (w10 != c17) {
                            throw new IllegalStateException(("Unexpected cell state: " + w10).toString());
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            } else if (j10 >= f34369e.get(this)) {
                c10 = BufferedChannelKt.f34391g;
                if (fVar.r(i10, w10, c10)) {
                    if (!q0(w10, fVar, i10)) {
                        c11 = BufferedChannelKt.f34394j;
                        fVar.A(i10, c11);
                        fVar.x(i10, false);
                        return false;
                    }
                    fVar.A(i10, BufferedChannelKt.f34388d);
                    return true;
                }
            } else if (fVar.r(i10, w10, new p((Q0) w10))) {
                return true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(f<E> fVar, long j10) {
        C c10;
        Object b10 = kotlinx.coroutines.internal.k.b(null, 1, null);
        loop0: while (fVar != null) {
            for (int i10 = BufferedChannelKt.f34386b - 1; -1 < i10; i10--) {
                if ((fVar.f34541c * BufferedChannelKt.f34386b) + i10 < j10) {
                    break loop0;
                }
                while (true) {
                    Object w10 = fVar.w(i10);
                    if (w10 != null) {
                        c10 = BufferedChannelKt.f34389e;
                        if (w10 != c10) {
                            if (w10 instanceof p) {
                                if (fVar.r(i10, w10, BufferedChannelKt.z())) {
                                    b10 = kotlinx.coroutines.internal.k.c(b10, ((p) w10).f34418a);
                                    fVar.x(i10, true);
                                    break;
                                }
                            } else {
                                if (!(w10 instanceof Q0)) {
                                    break;
                                }
                                if (fVar.r(i10, w10, BufferedChannelKt.z())) {
                                    b10 = kotlinx.coroutines.internal.k.c(b10, w10);
                                    fVar.x(i10, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (fVar.r(i10, w10, BufferedChannelKt.z())) {
                        fVar.p();
                        break;
                    }
                }
            }
            fVar = (f) fVar.g();
        }
        if (b10 != null) {
            if (!(b10 instanceof ArrayList)) {
                j0((Q0) b10);
                return;
            }
            kotlin.jvm.internal.i.d(b10, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) b10;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                j0((Q0) arrayList.get(size));
            }
        }
    }

    public final Object t0(f<E> fVar, int i10, long j10, Object obj) {
        C c10;
        C c11;
        C c12;
        Object w10 = fVar.w(i10);
        if (w10 == null) {
            if (j10 >= (f34368d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    c12 = BufferedChannelKt.f34398n;
                    return c12;
                }
                if (fVar.r(i10, w10, obj)) {
                    A();
                    c11 = BufferedChannelKt.f34397m;
                    return c11;
                }
            }
        } else if (w10 == BufferedChannelKt.f34388d) {
            c10 = BufferedChannelKt.f34393i;
            if (fVar.r(i10, w10, c10)) {
                A();
                return fVar.y(i10);
            }
        }
        return u0(fVar, i10, j10, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01d5, code lost:
    
        r3 = (kotlinx.coroutines.channels.f) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01dc, code lost:
    
        if (r3 != null) goto L98;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final f<E> u() {
        Object obj = f34374j.get(this);
        f fVar = (f) f34372h.get(this);
        if (fVar.f34541c > ((f) obj).f34541c) {
            obj = fVar;
        }
        f fVar2 = (f) f34373i.get(this);
        if (fVar2.f34541c > ((f) obj).f34541c) {
            obj = fVar2;
        }
        return (f) C1253d.b((AbstractC1254e) obj);
    }

    public final Object u0(f<E> fVar, int i10, long j10, Object obj) {
        C c10;
        C c11;
        C c12;
        C c13;
        C c14;
        C c15;
        C c16;
        C c17;
        C c18;
        C c19;
        C c20;
        C c21;
        C c22;
        C c23;
        C c24;
        C c25;
        while (true) {
            Object w10 = fVar.w(i10);
            if (w10 != null) {
                c14 = BufferedChannelKt.f34389e;
                if (w10 != c14) {
                    if (w10 == BufferedChannelKt.f34388d) {
                        c15 = BufferedChannelKt.f34393i;
                        if (fVar.r(i10, w10, c15)) {
                            A();
                            return fVar.y(i10);
                        }
                    } else {
                        c16 = BufferedChannelKt.f34394j;
                        if (w10 == c16) {
                            c17 = BufferedChannelKt.f34399o;
                            return c17;
                        }
                        c18 = BufferedChannelKt.f34392h;
                        if (w10 == c18) {
                            c19 = BufferedChannelKt.f34399o;
                            return c19;
                        }
                        if (w10 != BufferedChannelKt.z()) {
                            c21 = BufferedChannelKt.f34391g;
                            if (w10 != c21) {
                                c22 = BufferedChannelKt.f34390f;
                                if (fVar.r(i10, w10, c22)) {
                                    boolean z10 = w10 instanceof p;
                                    if (z10) {
                                        w10 = ((p) w10).f34418a;
                                    }
                                    if (q0(w10, fVar, i10)) {
                                        c25 = BufferedChannelKt.f34393i;
                                        fVar.A(i10, c25);
                                        A();
                                        return fVar.y(i10);
                                    }
                                    c23 = BufferedChannelKt.f34394j;
                                    fVar.A(i10, c23);
                                    fVar.x(i10, false);
                                    if (z10) {
                                        A();
                                    }
                                    c24 = BufferedChannelKt.f34399o;
                                    return c24;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            A();
                            c20 = BufferedChannelKt.f34399o;
                            return c20;
                        }
                    }
                }
            }
            if (j10 < (f34368d.get(this) & 1152921504606846975L)) {
                c10 = BufferedChannelKt.f34392h;
                if (fVar.r(i10, w10, c10)) {
                    A();
                    c11 = BufferedChannelKt.f34399o;
                    return c11;
                }
            } else {
                if (obj == null) {
                    c12 = BufferedChannelKt.f34398n;
                    return c12;
                }
                if (fVar.r(i10, w10, obj)) {
                    A();
                    c13 = BufferedChannelKt.f34397m;
                    return c13;
                }
            }
        }
    }

    public boolean v(Throwable th, boolean z10) {
        C c10;
        if (z10) {
            X();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34375k;
        c10 = BufferedChannelKt.f34403s;
        boolean compareAndSet = atomicReferenceFieldUpdater.compareAndSet(this, c10, th);
        if (z10) {
            Y();
        } else {
            Z();
        }
        y();
        b0();
        if (compareAndSet) {
            N();
        }
        return compareAndSet;
    }

    public final int v0(f<E> fVar, int i10, E e10, long j10, Object obj, boolean z10) {
        C c10;
        C c11;
        C c12;
        fVar.B(i10, e10);
        if (z10) {
            return w0(fVar, i10, e10, j10, obj, z10);
        }
        Object w10 = fVar.w(i10);
        if (w10 == null) {
            if (r(j10)) {
                if (fVar.r(i10, null, BufferedChannelKt.f34388d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (fVar.r(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (w10 instanceof Q0) {
            fVar.s(i10);
            if (p0(w10, e10)) {
                c12 = BufferedChannelKt.f34393i;
                fVar.A(i10, c12);
                e0();
                return 0;
            }
            c10 = BufferedChannelKt.f34395k;
            Object t10 = fVar.t(i10, c10);
            c11 = BufferedChannelKt.f34395k;
            if (t10 != c11) {
                fVar.x(i10, true);
            }
            return 5;
        }
        return w0(fVar, i10, e10, j10, obj, z10);
    }

    public final void w(long j10) {
        i0(x(j10));
    }

    public final int w0(f<E> fVar, int i10, E e10, long j10, Object obj, boolean z10) {
        C c10;
        C c11;
        C c12;
        C c13;
        C c14;
        C c15;
        C c16;
        while (true) {
            Object w10 = fVar.w(i10);
            if (w10 != null) {
                c11 = BufferedChannelKt.f34389e;
                if (w10 != c11) {
                    c12 = BufferedChannelKt.f34395k;
                    if (w10 != c12) {
                        c13 = BufferedChannelKt.f34392h;
                        if (w10 == c13) {
                            fVar.s(i10);
                            return 5;
                        }
                        if (w10 == BufferedChannelKt.z()) {
                            fVar.s(i10);
                            y();
                            return 4;
                        }
                        fVar.s(i10);
                        if (w10 instanceof p) {
                            w10 = ((p) w10).f34418a;
                        }
                        if (p0(w10, e10)) {
                            c16 = BufferedChannelKt.f34393i;
                            fVar.A(i10, c16);
                            e0();
                            return 0;
                        }
                        c14 = BufferedChannelKt.f34395k;
                        Object t10 = fVar.t(i10, c14);
                        c15 = BufferedChannelKt.f34395k;
                        if (t10 != c15) {
                            fVar.x(i10, true);
                        }
                        return 5;
                    }
                    fVar.s(i10);
                    return 5;
                }
                if (fVar.r(i10, w10, BufferedChannelKt.f34388d)) {
                    return 1;
                }
            } else if (r(j10) && !z10) {
                if (fVar.r(i10, null, BufferedChannelKt.f34388d)) {
                    return 1;
                }
            } else if (z10) {
                c10 = BufferedChannelKt.f34394j;
                if (fVar.r(i10, null, c10)) {
                    fVar.x(i10, false);
                    return 4;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (fVar.r(i10, null, obj)) {
                    return 2;
                }
            }
        }
    }

    public final f<E> x(long j10) {
        f<E> u10 = u();
        if (U()) {
            long W10 = W(u10);
            if (W10 != -1) {
                z(W10);
            }
        }
        t(u10, j10);
        return u10;
    }

    public final void x0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34369e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
        } while (!f34369e.compareAndSet(this, j11, j10));
    }

    public final void y() {
        S();
    }

    public final void y0(long j10) {
        long j11;
        long w10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34368d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            long j12 = 1152921504606846975L & j11;
            if (j12 < j10) {
                w10 = BufferedChannelKt.w(j12, (int) (j11 >> 60));
            } else {
                return;
            }
        } while (!f34368d.compareAndSet(this, j11, w10));
    }

    public final void z(long j10) {
        C c10;
        UndeliveredElementException d10;
        f<E> fVar = (f) f34373i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f34369e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(this.f34377a + j11, E())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = BufferedChannelKt.f34386b;
                long j12 = j11 / i10;
                int i11 = (int) (j11 % i10);
                if (fVar.f34541c != j12) {
                    f<E> C10 = C(j12, fVar);
                    if (C10 == null) {
                        continue;
                    } else {
                        fVar = C10;
                    }
                }
                Object t02 = t0(fVar, i11, j11, null);
                c10 = BufferedChannelKt.f34399o;
                if (t02 == c10) {
                    if (j11 < J()) {
                        fVar.b();
                    }
                } else {
                    fVar.b();
                    v9.l<E, q> lVar = this.f34378b;
                    if (lVar != null && (d10 = OnUndeliveredElementKt.d(lVar, t02, null, 2, null)) != null) {
                        throw d10;
                    }
                }
            }
        }
    }

    public final void z0(long j10) {
        int i10;
        long j11;
        long v10;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        boolean z10;
        long v11;
        long j12;
        long v12;
        if (V()) {
            return;
        }
        do {
        } while (E() <= j10);
        i10 = BufferedChannelKt.f34387c;
        for (int i11 = 0; i11 < i10; i11++) {
            long E10 = E();
            if (E10 == (4611686018427387903L & f34371g.get(this)) && E10 == E()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f34371g;
        do {
            j11 = atomicLongFieldUpdater2.get(this);
            v10 = BufferedChannelKt.v(j11 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, v10));
        while (true) {
            long E11 = E();
            atomicLongFieldUpdater = f34371g;
            long j13 = atomicLongFieldUpdater.get(this);
            long j14 = j13 & 4611686018427387903L;
            if ((4611686018427387904L & j13) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (E11 == j14 && E11 == E()) {
                break;
            } else if (!z10) {
                v11 = BufferedChannelKt.v(j14, true);
                atomicLongFieldUpdater.compareAndSet(this, j13, v11);
            }
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
            v12 = BufferedChannelKt.v(j12 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, v12));
    }

    public void b0() {
    }

    public void e0() {
    }

    public void f0() {
    }
}
