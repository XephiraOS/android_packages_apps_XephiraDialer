package F9;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.n;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.AbstractC1262k;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.Q0;
import kotlinx.coroutines.T;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.selects.SelectKt;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import v9.l;
import v9.q;

/* compiled from: Select.kt */
/* loaded from: classes4.dex */
public class a<R> extends AbstractC1262k implements b, Q0 {

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1019f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f1020a;

    /* renamed from: b, reason: collision with root package name */
    public List<a<R>.C0019a> f1021b;

    /* renamed from: c, reason: collision with root package name */
    public Object f1022c;

    /* renamed from: d, reason: collision with root package name */
    public int f1023d;

    /* renamed from: e, reason: collision with root package name */
    public Object f1024e;
    private volatile Object state;

    /* compiled from: Select.kt */
    /* renamed from: F9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C0019a {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1025a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f1026b;

        /* renamed from: c, reason: collision with root package name */
        public final q<b<?>, Object, Object, l<Throwable, m9.q>> f1027c;

        /* renamed from: d, reason: collision with root package name */
        public Object f1028d;

        /* renamed from: e, reason: collision with root package name */
        public int f1029e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a<R> f1030f;

        public final l<Throwable, m9.q> a(b<?> bVar, Object obj) {
            q<b<?>, Object, Object, l<Throwable, m9.q>> qVar = this.f1027c;
            if (qVar != null) {
                return qVar.d(bVar, this.f1026b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f1028d;
            a<R> aVar = this.f1030f;
            T t10 = null;
            if (obj instanceof z) {
                ((z) obj).o(this.f1029e, null, aVar.getContext());
                return;
            }
            if (obj instanceof T) {
                t10 = (T) obj;
            }
            if (t10 != null) {
                t10.b();
            }
        }
    }

    @Override // F9.b
    public boolean b(Object obj, Object obj2) {
        if (i(obj, obj2) == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.Q0
    public void c(z<?> zVar, int i10) {
        this.f1022c = zVar;
        this.f1023d = i10;
    }

    @Override // F9.b
    public void e(Object obj) {
        this.f1024e = obj;
    }

    @Override // kotlinx.coroutines.AbstractC1264l
    public void f(Throwable th) {
        Object obj;
        C c10;
        C c11;
        C c12;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1019f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            c10 = SelectKt.f34601c;
            if (obj != c10) {
                c11 = SelectKt.f34602d;
            } else {
                return;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c11));
        List<a<R>.C0019a> list = this.f1021b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((C0019a) it.next()).b();
        }
        c12 = SelectKt.f34603e;
        this.f1024e = c12;
        this.f1021b = null;
    }

    public final a<R>.C0019a g(Object obj) {
        List<a<R>.C0019a> list = this.f1021b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((C0019a) next).f1025a == obj) {
                obj2 = next;
                break;
            }
        }
        a<R>.C0019a c0019a = (C0019a) obj2;
        if (c0019a != null) {
            return c0019a;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    @Override // F9.b
    public CoroutineContext getContext() {
        return this.f1020a;
    }

    public final TrySelectDetailedResult h(Object obj, Object obj2) {
        TrySelectDetailedResult a10;
        a10 = SelectKt.a(i(obj, obj2));
        return a10;
    }

    public final int i(Object obj, Object obj2) {
        boolean h10;
        C c10;
        C c11;
        C c12;
        List b10;
        List H10;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1019f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof InterfaceC1266m)) {
                c10 = SelectKt.f34601c;
                if (!i.b(obj3, c10) && !(obj3 instanceof C0019a)) {
                    c11 = SelectKt.f34602d;
                    if (!i.b(obj3, c11)) {
                        c12 = SelectKt.f34600b;
                        if (i.b(obj3, c12)) {
                            b10 = n.b(obj);
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, b10)) {
                                return 1;
                            }
                        } else if (obj3 instanceof List) {
                            H10 = CollectionsKt___CollectionsKt.H((Collection) obj3, obj);
                            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, H10)) {
                                return 1;
                            }
                        } else {
                            throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                        }
                    } else {
                        return 2;
                    }
                } else {
                    return 3;
                }
            } else {
                a<R>.C0019a g10 = g(obj);
                if (g10 == null) {
                    continue;
                } else {
                    l<Throwable, m9.q> a10 = g10.a(this, obj2);
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, g10)) {
                        this.f1024e = obj2;
                        h10 = SelectKt.h((InterfaceC1266m) obj3, a10);
                        if (h10) {
                            return 0;
                        }
                        this.f1024e = null;
                        return 2;
                    }
                }
            }
        }
    }

    @Override // v9.l
    public /* bridge */ /* synthetic */ m9.q invoke(Throwable th) {
        f(th);
        return m9.q.f35511a;
    }
}
