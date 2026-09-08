package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.C1268n;
import kotlinx.coroutines.C1272p;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.G;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.Q0;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.z;
import p9.C1472f;
import v9.l;
import v9.q;

/* compiled from: Mutex.kt */
/* loaded from: classes4.dex */
public class MutexImpl extends SemaphoreImpl implements a {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f34611i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    /* renamed from: h, reason: collision with root package name */
    public final q<F9.b<?>, Object, Object, l<Throwable, m9.q>> f34612h;
    private volatile Object owner;

    /* compiled from: Mutex.kt */
    /* loaded from: classes4.dex */
    public final class CancellableContinuationWithOwner implements InterfaceC1266m<m9.q>, Q0 {

        /* renamed from: a, reason: collision with root package name */
        public final C1268n<m9.q> f34613a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f34614b;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(C1268n<? super m9.q> c1268n, Object obj) {
            this.f34613a = c1268n;
            this.f34614b = obj;
        }

        @Override // kotlinx.coroutines.InterfaceC1266m
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(m9.q qVar, l<? super Throwable, m9.q> lVar) {
            MutexImpl.f34611i.set(MutexImpl.this, this.f34614b);
            C1268n<m9.q> c1268n = this.f34613a;
            final MutexImpl mutexImpl = MutexImpl.this;
            c1268n.b(qVar, new l<Throwable, m9.q>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(Throwable th) {
                    MutexImpl.this.b(this.f34614b);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
                    b(th);
                    return m9.q.f35511a;
                }
            });
        }

        @Override // kotlinx.coroutines.Q0
        public void c(z<?> zVar, int i10) {
            this.f34613a.c(zVar, i10);
        }

        @Override // kotlinx.coroutines.InterfaceC1266m
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void h(CoroutineDispatcher coroutineDispatcher, m9.q qVar) {
            this.f34613a.h(coroutineDispatcher, qVar);
        }

        @Override // kotlinx.coroutines.InterfaceC1266m
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object f(m9.q qVar, Object obj, l<? super Throwable, m9.q> lVar) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object f10 = this.f34613a.f(qVar, obj, new l<Throwable, m9.q>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(Throwable th) {
                    MutexImpl.f34611i.set(MutexImpl.this, this.f34614b);
                    MutexImpl.this.b(this.f34614b);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
                    b(th);
                    return m9.q.f35511a;
                }
            });
            if (f10 != null) {
                MutexImpl.f34611i.set(MutexImpl.this, this.f34614b);
            }
            return f10;
        }

        @Override // kotlin.coroutines.c
        public CoroutineContext getContext() {
            return this.f34613a.getContext();
        }

        @Override // kotlinx.coroutines.InterfaceC1266m
        public void i(l<? super Throwable, m9.q> lVar) {
            this.f34613a.i(lVar);
        }

        @Override // kotlinx.coroutines.InterfaceC1266m
        public void m(Object obj) {
            this.f34613a.m(obj);
        }

        @Override // kotlin.coroutines.c
        public void resumeWith(Object obj) {
            this.f34613a.resumeWith(obj);
        }
    }

    public MutexImpl(boolean z10) {
        super(1, z10 ? 1 : 0);
        C c10;
        if (!z10) {
            c10 = b.f34625a;
        } else {
            c10 = null;
        }
        this.owner = c10;
        this.f34612h = new q<F9.b<?>, Object, Object, l<? super Throwable, ? extends m9.q>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // v9.q
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final l<Throwable, m9.q> d(F9.b<?> bVar, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = MutexImpl.this;
                return new l<Throwable, m9.q>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void b(Throwable th) {
                        MutexImpl.this.b(obj);
                    }

                    @Override // v9.l
                    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
                        b(th);
                        return m9.q.f35511a;
                    }
                };
            }
        };
    }

    public static /* synthetic */ Object o(MutexImpl mutexImpl, Object obj, kotlin.coroutines.c<? super m9.q> cVar) {
        Object c10;
        if (mutexImpl.q(obj)) {
            return m9.q.f35511a;
        }
        Object p10 = mutexImpl.p(obj, cVar);
        c10 = kotlin.coroutines.intrinsics.b.c();
        if (p10 == c10) {
            return p10;
        }
        return m9.q.f35511a;
    }

    @Override // kotlinx.coroutines.sync.a
    public Object a(Object obj, kotlin.coroutines.c<? super m9.q> cVar) {
        return o(this, obj, cVar);
    }

    @Override // kotlinx.coroutines.sync.a
    public void b(Object obj) {
        C c10;
        C c11;
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34611i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            c10 = b.f34625a;
            if (obj2 != c10) {
                if (obj2 == obj || obj == null) {
                    c11 = b.f34625a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c11)) {
                        h();
                        return;
                    }
                } else {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }

    public final int m(Object obj) {
        C c10;
        while (n()) {
            Object obj2 = f34611i.get(this);
            c10 = b.f34625a;
            if (obj2 != c10) {
                if (obj2 == obj) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    public boolean n() {
        if (g() == 0) {
            return true;
        }
        return false;
    }

    public final Object p(Object obj, kotlin.coroutines.c<? super m9.q> cVar) {
        kotlin.coroutines.c b10;
        Object c10;
        Object c11;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(cVar);
        C1268n b11 = C1272p.b(b10);
        try {
            c(new CancellableContinuationWithOwner(b11, obj));
            Object x10 = b11.x();
            c10 = kotlin.coroutines.intrinsics.b.c();
            if (x10 == c10) {
                C1472f.c(cVar);
            }
            c11 = kotlin.coroutines.intrinsics.b.c();
            if (x10 == c11) {
                return x10;
            }
            return m9.q.f35511a;
        } catch (Throwable th) {
            b11.J();
            throw th;
        }
    }

    public boolean q(Object obj) {
        int r10 = r(obj);
        if (r10 == 0) {
            return true;
        }
        if (r10 != 1) {
            if (r10 != 2) {
                throw new IllegalStateException("unexpected".toString());
            }
            throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
        }
        return false;
    }

    public final int r(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            int m10 = m(obj);
            if (m10 == 1) {
                return 2;
            }
            if (m10 == 2) {
                return 1;
            }
        }
        f34611i.set(this, obj);
        return 0;
    }

    public String toString() {
        return "Mutex@" + G.b(this) + "[isLocked=" + n() + ",owner=" + f34611i.get(this) + ']';
    }
}
