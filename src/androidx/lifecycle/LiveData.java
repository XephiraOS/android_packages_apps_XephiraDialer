package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import l.C1286b;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f10292k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f10293a;

    /* renamed from: b, reason: collision with root package name */
    public C1286b<w<? super T>, LiveData<T>.c> f10294b;

    /* renamed from: c, reason: collision with root package name */
    public int f10295c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10296d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f10297e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f10298f;

    /* renamed from: g, reason: collision with root package name */
    public int f10299g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10300h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10301i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f10302j;

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.c implements InterfaceC0489l {

        /* renamed from: e, reason: collision with root package name */
        public final InterfaceC0492o f10303e;

        public LifecycleBoundObserver(InterfaceC0492o interfaceC0492o, w<? super T> wVar) {
            super(wVar);
            this.f10303e = interfaceC0492o;
        }

        @Override // androidx.lifecycle.LiveData.c
        public void b() {
            this.f10303e.getLifecycle().d(this);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean c(InterfaceC0492o interfaceC0492o) {
            if (this.f10303e == interfaceC0492o) {
                return true;
            }
            return false;
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return this.f10303e.getLifecycle().b().b(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.InterfaceC0489l
        public void onStateChanged(InterfaceC0492o interfaceC0492o, Lifecycle.Event event) {
            Lifecycle.State b10 = this.f10303e.getLifecycle().b();
            if (b10 == Lifecycle.State.DESTROYED) {
                LiveData.this.n(this.f10307a);
                return;
            }
            Lifecycle.State state = null;
            while (state != b10) {
                a(d());
                state = b10;
                b10 = this.f10303e.getLifecycle().b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f10293a) {
                obj = LiveData.this.f10298f;
                LiveData.this.f10298f = LiveData.f10292k;
            }
            LiveData.this.o(obj);
        }
    }

    /* loaded from: classes.dex */
    public class b extends LiveData<T>.c {
        public b(w<? super T> wVar) {
            super(wVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean d() {
            return true;
        }
    }

    public LiveData(T t10) {
        this.f10293a = new Object();
        this.f10294b = new C1286b<>();
        this.f10295c = 0;
        this.f10298f = f10292k;
        this.f10302j = new a();
        this.f10297e = t10;
        this.f10299g = 0;
    }

    public static void a(String str) {
        if (k.c.g().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void b(int i10) {
        boolean z10;
        boolean z11;
        int i11 = this.f10295c;
        this.f10295c = i10 + i11;
        if (this.f10296d) {
            return;
        }
        this.f10296d = true;
        while (true) {
            try {
                int i12 = this.f10295c;
                if (i11 != i12) {
                    if (i11 == 0 && i12 > 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (i11 > 0 && i12 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z10) {
                        k();
                    } else if (z11) {
                        l();
                    }
                    i11 = i12;
                } else {
                    this.f10296d = false;
                    return;
                }
            } catch (Throwable th) {
                this.f10296d = false;
                throw th;
            }
        }
    }

    public final void c(LiveData<T>.c cVar) {
        if (!cVar.f10308b) {
            return;
        }
        if (!cVar.d()) {
            cVar.a(false);
            return;
        }
        int i10 = cVar.f10309c;
        int i11 = this.f10299g;
        if (i10 >= i11) {
            return;
        }
        cVar.f10309c = i11;
        cVar.f10307a.onChanged((Object) this.f10297e);
    }

    public void d(LiveData<T>.c cVar) {
        if (this.f10300h) {
            this.f10301i = true;
            return;
        }
        this.f10300h = true;
        do {
            this.f10301i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                C1286b<w<? super T>, LiveData<T>.c>.d e10 = this.f10294b.e();
                while (e10.hasNext()) {
                    c((c) e10.next().getValue());
                    if (this.f10301i) {
                        break;
                    }
                }
            }
        } while (this.f10301i);
        this.f10300h = false;
    }

    public int e() {
        return this.f10299g;
    }

    public boolean f() {
        if (this.f10295c > 0) {
            return true;
        }
        return false;
    }

    public boolean g() {
        if (this.f10294b.size() > 0) {
            return true;
        }
        return false;
    }

    public T getValue() {
        T t10 = (T) this.f10297e;
        if (t10 != f10292k) {
            return t10;
        }
        return null;
    }

    public boolean h() {
        if (this.f10297e != f10292k) {
            return true;
        }
        return false;
    }

    public void i(InterfaceC0492o interfaceC0492o, w<? super T> wVar) {
        a("observe");
        if (interfaceC0492o.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC0492o, wVar);
        LiveData<T>.c i10 = this.f10294b.i(wVar, lifecycleBoundObserver);
        if (i10 != null && !i10.c(interfaceC0492o)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (i10 != null) {
            return;
        }
        interfaceC0492o.getLifecycle().a(lifecycleBoundObserver);
    }

    public void j(w<? super T> wVar) {
        a("observeForever");
        b bVar = new b(wVar);
        LiveData<T>.c i10 = this.f10294b.i(wVar, bVar);
        if (!(i10 instanceof LifecycleBoundObserver)) {
            if (i10 != null) {
                return;
            }
            bVar.a(true);
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    public void m(T t10) {
        boolean z10;
        synchronized (this.f10293a) {
            if (this.f10298f == f10292k) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f10298f = t10;
        }
        if (!z10) {
            return;
        }
        k.c.g().c(this.f10302j);
    }

    public void n(w<? super T> wVar) {
        a("removeObserver");
        LiveData<T>.c j10 = this.f10294b.j(wVar);
        if (j10 == null) {
            return;
        }
        j10.b();
        j10.a(false);
    }

    public void o(T t10) {
        a("setValue");
        this.f10299g++;
        this.f10297e = t10;
        d(null);
    }

    public LiveData() {
        this.f10293a = new Object();
        this.f10294b = new C1286b<>();
        this.f10295c = 0;
        Object obj = f10292k;
        this.f10298f = obj;
        this.f10302j = new a();
        this.f10297e = obj;
        this.f10299g = -1;
    }

    /* loaded from: classes.dex */
    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final w<? super T> f10307a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f10308b;

        /* renamed from: c, reason: collision with root package name */
        public int f10309c = -1;

        public c(w<? super T> wVar) {
            this.f10307a = wVar;
        }

        public void a(boolean z10) {
            int i10;
            if (z10 == this.f10308b) {
                return;
            }
            this.f10308b = z10;
            LiveData liveData = LiveData.this;
            if (z10) {
                i10 = 1;
            } else {
                i10 = -1;
            }
            liveData.b(i10);
            if (this.f10308b) {
                LiveData.this.d(this);
            }
        }

        public boolean c(InterfaceC0492o interfaceC0492o) {
            return false;
        }

        public abstract boolean d();

        public void b() {
        }
    }

    public void k() {
    }

    public void l() {
    }
}
