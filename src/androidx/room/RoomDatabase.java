package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import b0.AbstractC0515b;
import b0.InterfaceC0514a;
import e0.h;
import f0.C0994c;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m.InterfaceC1301a;

/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public volatile e0.g f11267a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f11268b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f11269c;

    /* renamed from: d, reason: collision with root package name */
    public e0.h f11270d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11272f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f11273g;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public List<b> f11274h;

    /* renamed from: k, reason: collision with root package name */
    public C0495a f11277k;

    /* renamed from: j, reason: collision with root package name */
    public final ReentrantReadWriteLock f11276j = new ReentrantReadWriteLock();

    /* renamed from: l, reason: collision with root package name */
    public final ThreadLocal<Integer> f11278l = new ThreadLocal<>();

    /* renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f11279m = Collections.synchronizedMap(new HashMap());

    /* renamed from: e, reason: collision with root package name */
    public final s f11271e = g();

    /* renamed from: n, reason: collision with root package name */
    public final Map<Class<?>, Object> f11280n = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Map<Class<? extends InterfaceC0514a>, InterfaceC0514a> f11275i = new HashMap();

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        public static boolean a(ActivityManager activityManager) {
            return e0.c.b(activityManager);
        }

        public JournalMode b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && !a(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static class a<T extends RoomDatabase> {

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f11285a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11286b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f11287c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<b> f11288d;

        /* renamed from: e, reason: collision with root package name */
        public List<Object> f11289e;

        /* renamed from: f, reason: collision with root package name */
        public List<InterfaceC0514a> f11290f;

        /* renamed from: g, reason: collision with root package name */
        public Executor f11291g;

        /* renamed from: h, reason: collision with root package name */
        public Executor f11292h;

        /* renamed from: i, reason: collision with root package name */
        public h.c f11293i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f11294j;

        /* renamed from: l, reason: collision with root package name */
        public Intent f11296l;

        /* renamed from: n, reason: collision with root package name */
        public boolean f11298n;

        /* renamed from: p, reason: collision with root package name */
        public TimeUnit f11300p;

        /* renamed from: r, reason: collision with root package name */
        public Set<Integer> f11302r;

        /* renamed from: s, reason: collision with root package name */
        public Set<Integer> f11303s;

        /* renamed from: t, reason: collision with root package name */
        public String f11304t;

        /* renamed from: u, reason: collision with root package name */
        public File f11305u;

        /* renamed from: v, reason: collision with root package name */
        public Callable<InputStream> f11306v;

        /* renamed from: o, reason: collision with root package name */
        public long f11299o = -1;

        /* renamed from: k, reason: collision with root package name */
        public JournalMode f11295k = JournalMode.AUTOMATIC;

        /* renamed from: m, reason: collision with root package name */
        public boolean f11297m = true;

        /* renamed from: q, reason: collision with root package name */
        public final c f11301q = new c();

        public a(Context context, Class<T> cls, String str) {
            this.f11287c = context;
            this.f11285a = cls;
            this.f11286b = str;
        }

        public a<T> a(b bVar) {
            if (this.f11288d == null) {
                this.f11288d = new ArrayList<>();
            }
            this.f11288d.add(bVar);
            return this;
        }

        public a<T> b() {
            this.f11294j = true;
            return this;
        }

        public T c() {
            Executor executor;
            int i10;
            int i11;
            h.c a10;
            if (this.f11287c != null) {
                if (this.f11285a != null) {
                    Executor executor2 = this.f11291g;
                    if (executor2 == null && this.f11292h == null) {
                        Executor f10 = k.c.f();
                        this.f11292h = f10;
                        this.f11291g = f10;
                    } else if (executor2 != null && this.f11292h == null) {
                        this.f11292h = executor2;
                    } else if (executor2 == null && (executor = this.f11292h) != null) {
                        this.f11291g = executor;
                    }
                    Set<Integer> set = this.f11303s;
                    if (set != null && this.f11302r != null) {
                        for (Integer num : set) {
                            if (this.f11302r.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    h.c cVar = this.f11293i;
                    if (cVar == null) {
                        cVar = new C0994c();
                    }
                    long j10 = this.f11299o;
                    if (j10 > 0) {
                        if (this.f11286b != null) {
                            cVar = new l(cVar, new C0495a(j10, this.f11300p, this.f11292h));
                        } else {
                            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                        }
                    }
                    String str = this.f11304t;
                    if (str == null && this.f11305u == null && this.f11306v == null) {
                        a10 = cVar;
                    } else if (this.f11286b != null) {
                        int i12 = 0;
                        if (str == null) {
                            i10 = 0;
                        } else {
                            i10 = 1;
                        }
                        File file = this.f11305u;
                        if (file == null) {
                            i11 = 0;
                        } else {
                            i11 = 1;
                        }
                        int i13 = i10 + i11;
                        Callable<InputStream> callable = this.f11306v;
                        if (callable != null) {
                            i12 = 1;
                        }
                        if (i13 + i12 == 1) {
                            a10 = new A(str, file, callable, cVar);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    Context context = this.f11287c;
                    m mVar = new m(context, this.f11286b, a10, this.f11301q, this.f11288d, this.f11294j, this.f11295k.b(context), this.f11291g, this.f11292h, this.f11296l, this.f11297m, this.f11298n, this.f11302r, this.f11304t, this.f11305u, this.f11306v, null, this.f11289e, this.f11290f);
                    T t10 = (T) t.b(this.f11285a, "_Impl");
                    t10.q(mVar);
                    return t10;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public HashMap<Integer, TreeMap<Integer, AbstractC0515b>> f11307a = new HashMap<>();

        public final void a(AbstractC0515b abstractC0515b) {
            int i10 = abstractC0515b.f12082a;
            int i11 = abstractC0515b.f12083b;
            TreeMap<Integer, AbstractC0515b> treeMap = this.f11307a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.f11307a.put(Integer.valueOf(i10), treeMap);
            }
            AbstractC0515b abstractC0515b2 = treeMap.get(Integer.valueOf(i11));
            if (abstractC0515b2 != null) {
                Log.w("ROOM", "Overriding migration " + abstractC0515b2 + " with " + abstractC0515b);
            }
            treeMap.put(Integer.valueOf(i11), abstractC0515b);
        }

        public void b(AbstractC0515b... abstractC0515bArr) {
            for (AbstractC0515b abstractC0515b : abstractC0515bArr) {
                a(abstractC0515b);
            }
        }

        public List<AbstractC0515b> c(int i10, int i11) {
            boolean z10;
            if (i10 == i11) {
                return Collections.emptyList();
            }
            if (i11 > i10) {
                z10 = true;
            } else {
                z10 = false;
            }
            return d(new ArrayList(), z10, i10, i11);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0054, code lost:
        
            return r6;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List<b0.AbstractC0515b> d(java.util.List<b0.AbstractC0515b> r6, boolean r7, int r8, int r9) {
            /*
                r5 = this;
            L0:
                if (r7 == 0) goto L5
                if (r8 >= r9) goto L54
                goto L7
            L5:
                if (r8 <= r9) goto L54
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, b0.b>> r0 = r5.f11307a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r7 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L4c
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r4 = r3.intValue()
                if (r7 == 0) goto L3d
                if (r4 > r9) goto L26
                if (r4 <= r8) goto L26
                goto L41
            L3d:
                if (r4 < r9) goto L26
                if (r4 >= r8) goto L26
            L41:
                java.lang.Object r8 = r0.get(r3)
                b0.b r8 = (b0.AbstractC0515b) r8
                r6.add(r8)
                r8 = 1
                goto L4f
            L4c:
                r0 = 0
                r4 = r8
                r8 = r0
            L4f:
                if (r8 != 0) goto L52
                return r1
            L52:
                r8 = r4
                goto L0
            L54:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.c.d(java.util.List, boolean, int, int):java.util.List");
        }

        public Map<Integer, Map<Integer, AbstractC0515b>> e() {
            return Collections.unmodifiableMap(this.f11307a);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
    }

    public static boolean u() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void A() {
        this.f11270d.M().D();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T B(Class<T> cls, e0.h hVar) {
        if (cls.isInstance(hVar)) {
            return hVar;
        }
        if (hVar instanceof n) {
            return (T) B(cls, ((n) hVar).a());
        }
        return null;
    }

    public void c() {
        if (this.f11272f || !u()) {
        } else {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void d() {
        if (!p() && this.f11278l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void e() {
        c();
        C0495a c0495a = this.f11277k;
        if (c0495a == null) {
            r();
        } else {
            c0495a.c(new InterfaceC1301a() { // from class: androidx.room.v
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Object w10;
                    w10 = RoomDatabase.this.w((e0.g) obj);
                    return w10;
                }
            });
        }
    }

    public e0.k f(String str) {
        c();
        d();
        return this.f11270d.M().q(str);
    }

    public abstract s g();

    public abstract e0.h h(m mVar);

    @Deprecated
    public void i() {
        C0495a c0495a = this.f11277k;
        if (c0495a == null) {
            s();
        } else {
            c0495a.c(new InterfaceC1301a() { // from class: androidx.room.u
                @Override // m.InterfaceC1301a
                public final Object apply(Object obj) {
                    Object x10;
                    x10 = RoomDatabase.this.x((e0.g) obj);
                    return x10;
                }
            });
        }
    }

    public List<AbstractC0515b> j(Map<Class<? extends InterfaceC0514a>, InterfaceC0514a> map) {
        return Collections.emptyList();
    }

    public Lock k() {
        return this.f11276j.readLock();
    }

    public e0.h l() {
        return this.f11270d;
    }

    public Executor m() {
        return this.f11268b;
    }

    public Set<Class<? extends InterfaceC0514a>> n() {
        return Collections.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> o() {
        return Collections.emptyMap();
    }

    public boolean p() {
        return this.f11270d.M().e0();
    }

    public void q(m mVar) {
        boolean z10;
        this.f11270d = h(mVar);
        Set<Class<? extends InterfaceC0514a>> n10 = n();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends InterfaceC0514a>> it = n10.iterator();
        while (true) {
            int i10 = -1;
            if (it.hasNext()) {
                Class<? extends InterfaceC0514a> next = it.next();
                int size = mVar.f11342g.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (next.isAssignableFrom(mVar.f11342g.get(size).getClass())) {
                        bitSet.set(size);
                        i10 = size;
                        break;
                    }
                    size--;
                }
                if (i10 >= 0) {
                    this.f11275i.put(next, mVar.f11342g.get(i10));
                } else {
                    throw new IllegalArgumentException("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.");
                }
            } else {
                for (int size2 = mVar.f11342g.size() - 1; size2 >= 0; size2--) {
                    if (!bitSet.get(size2)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                for (AbstractC0515b abstractC0515b : j(this.f11275i)) {
                    if (!mVar.f11339d.e().containsKey(Integer.valueOf(abstractC0515b.f12082a))) {
                        mVar.f11339d.b(abstractC0515b);
                    }
                }
                z zVar = (z) B(z.class, this.f11270d);
                if (zVar != null) {
                    zVar.f(mVar);
                }
                h hVar = (h) B(h.class, this.f11270d);
                if (hVar != null) {
                    C0495a c10 = hVar.c();
                    this.f11277k = c10;
                    this.f11271e.k(c10);
                }
                if (mVar.f11344i == JournalMode.WRITE_AHEAD_LOGGING) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f11270d.setWriteAheadLoggingEnabled(z10);
                this.f11274h = mVar.f11340e;
                this.f11268b = mVar.f11345j;
                this.f11269c = new C(mVar.f11346k);
                this.f11272f = mVar.f11343h;
                this.f11273g = z10;
                Intent intent = mVar.f11348m;
                if (intent != null) {
                    this.f11271e.l(mVar.f11337b, mVar.f11338c, intent);
                }
                Map<Class<?>, List<Class<?>>> o10 = o();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : o10.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size3 = mVar.f11341f.size() - 1;
                        while (true) {
                            if (size3 >= 0) {
                                if (cls.isAssignableFrom(mVar.f11341f.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                }
                                size3--;
                            } else {
                                size3 = -1;
                                break;
                            }
                        }
                        if (size3 >= 0) {
                            this.f11280n.put(cls, mVar.f11341f.get(size3));
                        } else {
                            throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                        }
                    }
                }
                for (int size4 = mVar.f11341f.size() - 1; size4 >= 0; size4--) {
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + mVar.f11341f.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
        }
    }

    public final void r() {
        c();
        e0.g M10 = this.f11270d.M();
        this.f11271e.p(M10);
        if (M10.k0()) {
            M10.F();
        } else {
            M10.h();
        }
    }

    public final void s() {
        this.f11270d.M().P();
        if (!p()) {
            this.f11271e.h();
        }
    }

    public void t(e0.g gVar) {
        this.f11271e.e(gVar);
    }

    public boolean v() {
        C0495a c0495a = this.f11277k;
        if (c0495a != null) {
            return c0495a.g();
        }
        e0.g gVar = this.f11267a;
        if (gVar != null && gVar.isOpen()) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object w(e0.g gVar) {
        r();
        return null;
    }

    public final /* synthetic */ Object x(e0.g gVar) {
        s();
        return null;
    }

    public Cursor y(e0.j jVar) {
        return z(jVar, null);
    }

    public Cursor z(e0.j jVar, CancellationSignal cancellationSignal) {
        c();
        d();
        if (cancellationSignal != null) {
            return this.f11270d.M().b0(jVar, cancellationSignal);
        }
        return this.f11270d.M().j(jVar);
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(e0.g gVar) {
        }

        public void b(e0.g gVar) {
        }

        public void c(e0.g gVar) {
        }
    }
}
