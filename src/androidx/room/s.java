package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import e0.C0962a;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import l.C1286b;

/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f11358o = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b, reason: collision with root package name */
    public final String[] f11360b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, Set<String>> f11361c;

    /* renamed from: e, reason: collision with root package name */
    public final RoomDatabase f11363e;

    /* renamed from: h, reason: collision with root package name */
    public volatile e0.k f11366h;

    /* renamed from: i, reason: collision with root package name */
    public final b f11367i;

    /* renamed from: j, reason: collision with root package name */
    public final q f11368j;

    /* renamed from: l, reason: collision with root package name */
    public MultiInstanceInvalidationClient f11370l;

    /* renamed from: d, reason: collision with root package name */
    public C0495a f11362d = null;

    /* renamed from: f, reason: collision with root package name */
    public AtomicBoolean f11364f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f11365g = false;

    /* renamed from: k, reason: collision with root package name */
    public final C1286b<c, d> f11369k = new C1286b<>();

    /* renamed from: m, reason: collision with root package name */
    public final Object f11371m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public Runnable f11372n = new a();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, Integer> f11359a = new HashMap<>();

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor y10 = s.this.f11363e.y(new C0962a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (y10.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(y10.getInt(0)));
                } catch (Throwable th) {
                    y10.close();
                    throw th;
                }
            }
            y10.close();
            if (!hashSet.isEmpty()) {
                s.this.f11366h.p();
            }
            return hashSet;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
        
            if (r0 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
        
            r0.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
        
            if (r1 == null) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0097, code lost:
        
            if (r1.isEmpty() != false) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0099, code lost:
        
            r0 = r5.f11373a.f11369k;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009d, code lost:
        
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x009e, code lost:
        
            r5 = r5.f11373a.f11369k.iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00aa, code lost:
        
            if (r5.hasNext() == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
        
            r5.next().getValue().a(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
        
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00bc, code lost:
        
            r5 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c1, code lost:
        
            throw r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x008e, code lost:
        
            if (r0 == null) goto L38;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r5 = this;
                androidx.room.s r0 = androidx.room.s.this
                androidx.room.RoomDatabase r0 = r0.f11363e
                java.util.concurrent.locks.Lock r0 = r0.k()
                r0.lock()
                r1 = 0
                androidx.room.s r2 = androidx.room.s.this     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
                boolean r2 = r2.d()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79
                if (r2 != 0) goto L21
                r0.unlock()
                androidx.room.s r5 = androidx.room.s.this
                androidx.room.a r5 = r5.f11362d
                if (r5 == 0) goto L20
                r5.b()
            L20:
                return
            L21:
                androidx.room.s r2 = androidx.room.s.this     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.f11364f     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                r3 = 1
                r4 = 0
                boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                if (r2 != 0) goto L3a
                r0.unlock()
                androidx.room.s r5 = androidx.room.s.this
                androidx.room.a r5 = r5.f11362d
                if (r5 == 0) goto L39
                r5.b()
            L39:
                return
            L3a:
                androidx.room.s r2 = androidx.room.s.this     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                androidx.room.RoomDatabase r2 = r2.f11363e     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                boolean r2 = r2.p()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                if (r2 == 0) goto L51
                r0.unlock()
                androidx.room.s r5 = androidx.room.s.this
                androidx.room.a r5 = r5.f11362d
                if (r5 == 0) goto L50
                r5.b()
            L50:
                return
            L51:
                androidx.room.s r2 = androidx.room.s.this     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                androidx.room.RoomDatabase r2 = r2.f11363e     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                e0.h r2 = r2.l()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                e0.g r2 = r2.M()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                r2.F()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                java.util.Set r1 = r5.a()     // Catch: java.lang.Throwable -> L7b
                r2.D()     // Catch: java.lang.Throwable -> L7b
                r2.P()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                r0.unlock()
                androidx.room.s r0 = androidx.room.s.this
                androidx.room.a r0 = r0.f11362d
                if (r0 == 0) goto L91
            L73:
                r0.b()
                goto L91
            L77:
                r1 = move-exception
                goto Lc3
            L79:
                r2 = move-exception
                goto L80
            L7b:
                r3 = move-exception
                r2.P()     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
                throw r3     // Catch: java.lang.Throwable -> L77 java.lang.Throwable -> L79 java.lang.Throwable -> L79
            L80:
                java.lang.String r3 = "ROOM"
                java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L77
                r0.unlock()
                androidx.room.s r0 = androidx.room.s.this
                androidx.room.a r0 = r0.f11362d
                if (r0 == 0) goto L91
                goto L73
            L91:
                if (r1 == 0) goto Lc2
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto Lc2
                androidx.room.s r0 = androidx.room.s.this
                l.b<androidx.room.s$c, androidx.room.s$d> r0 = r0.f11369k
                monitor-enter(r0)
                androidx.room.s r5 = androidx.room.s.this     // Catch: java.lang.Throwable -> Lbc
                l.b<androidx.room.s$c, androidx.room.s$d> r5 = r5.f11369k     // Catch: java.lang.Throwable -> Lbc
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> Lbc
            La6:
                boolean r2 = r5.hasNext()     // Catch: java.lang.Throwable -> Lbc
                if (r2 == 0) goto Lbe
                java.lang.Object r2 = r5.next()     // Catch: java.lang.Throwable -> Lbc
                java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> Lbc
                java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> Lbc
                androidx.room.s$d r2 = (androidx.room.s.d) r2     // Catch: java.lang.Throwable -> Lbc
                r2.a(r1)     // Catch: java.lang.Throwable -> Lbc
                goto La6
            Lbc:
                r5 = move-exception
                goto Lc0
            Lbe:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbc
                goto Lc2
            Lc0:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbc
                throw r5
            Lc2:
                return
            Lc3:
                r0.unlock()
                androidx.room.s r5 = androidx.room.s.this
                androidx.room.a r5 = r5.f11362d
                if (r5 == 0) goto Lcf
                r5.b()
            Lcf:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.s.a.run():void");
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f11374a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f11375b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f11376c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11377d;

        public b(int i10) {
            long[] jArr = new long[i10];
            this.f11374a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f11375b = zArr;
            this.f11376c = new int[i10];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public int[] a() {
            boolean z10;
            synchronized (this) {
                try {
                    if (!this.f11377d) {
                        return null;
                    }
                    int length = this.f11374a.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        int i11 = 1;
                        if (this.f11374a[i10] > 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        boolean[] zArr = this.f11375b;
                        if (z10 != zArr[i10]) {
                            int[] iArr = this.f11376c;
                            if (!z10) {
                                i11 = 2;
                            }
                            iArr[i10] = i11;
                        } else {
                            this.f11376c[i10] = 0;
                        }
                        zArr[i10] = z10;
                    }
                    this.f11377d = false;
                    return (int[]) this.f11376c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                try {
                    z10 = false;
                    for (int i10 : iArr) {
                        long[] jArr = this.f11374a;
                        long j10 = jArr[i10];
                        jArr[i10] = 1 + j10;
                        if (j10 == 0) {
                            z10 = true;
                            this.f11377d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z10;
        }

        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                try {
                    z10 = false;
                    for (int i10 : iArr) {
                        long[] jArr = this.f11374a;
                        long j10 = jArr[i10];
                        jArr[i10] = j10 - 1;
                        if (j10 == 1) {
                            z10 = true;
                            this.f11377d = true;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z10;
        }

        public void d() {
            synchronized (this) {
                Arrays.fill(this.f11375b, false);
                this.f11377d = true;
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f11378a;

        public c(String[] strArr) {
            this.f11378a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    /* compiled from: InvalidationTracker.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f11379a;

        /* renamed from: b, reason: collision with root package name */
        public final String[] f11380b;

        /* renamed from: c, reason: collision with root package name */
        public final c f11381c;

        /* renamed from: d, reason: collision with root package name */
        public final Set<String> f11382d;

        public d(c cVar, int[] iArr, String[] strArr) {
            this.f11381c = cVar;
            this.f11379a = iArr;
            this.f11380b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f11382d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f11382d = null;
        }

        public void a(Set<Integer> set) {
            int length = this.f11379a.length;
            Set<String> set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f11379a[i10]))) {
                    if (length == 1) {
                        set2 = this.f11382d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet<>(length);
                        }
                        set2.add(this.f11380b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f11381c.b(set2);
            }
        }

        public void b(String[] strArr) {
            Set<String> set = null;
            if (this.f11380b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (strArr[i10].equalsIgnoreCase(this.f11380b[0])) {
                        set = this.f11382d;
                        break;
                    }
                    i10++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f11380b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            String str2 = strArr2[i11];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i11++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f11381c.b(set);
            }
        }
    }

    public s(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f11363e = roomDatabase;
        this.f11367i = new b(strArr.length);
        this.f11361c = map2;
        this.f11368j = new q(roomDatabase);
        int length = strArr.length;
        this.f11360b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f11359a.put(lowerCase, Integer.valueOf(i10));
            String str2 = map.get(strArr[i10]);
            if (str2 != null) {
                this.f11360b[i10] = str2.toLowerCase(locale);
            } else {
                this.f11360b[i10] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = value.toLowerCase(locale2);
            if (this.f11359a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f11359a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    public static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    public static void c(e0.g gVar) {
        if (gVar.k0()) {
            gVar.F();
        } else {
            gVar.h();
        }
    }

    public void a(c cVar) {
        d i10;
        String[] j10 = j(cVar.f11378a);
        int[] iArr = new int[j10.length];
        int length = j10.length;
        for (int i11 = 0; i11 < length; i11++) {
            Integer num = this.f11359a.get(j10[i11].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i11] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + j10[i11]);
            }
        }
        d dVar = new d(cVar, iArr, j10);
        synchronized (this.f11369k) {
            i10 = this.f11369k.i(cVar, dVar);
        }
        if (i10 == null && this.f11367i.b(iArr)) {
            o();
        }
    }

    public boolean d() {
        if (!this.f11363e.v()) {
            return false;
        }
        if (!this.f11365g) {
            this.f11363e.l().M();
        }
        if (!this.f11365g) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    public void e(e0.g gVar) {
        synchronized (this) {
            try {
                if (this.f11365g) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                    return;
                }
                gVar.m("PRAGMA temp_store = MEMORY;");
                gVar.m("PRAGMA recursive_triggers='ON';");
                gVar.m("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                p(gVar);
                this.f11366h = gVar.q("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                this.f11365g = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(String... strArr) {
        synchronized (this.f11369k) {
            try {
                Iterator<Map.Entry<c, d>> it = this.f11369k.iterator();
                while (it.hasNext()) {
                    Map.Entry<c, d> next = it.next();
                    if (!next.getKey().a()) {
                        next.getValue().b(strArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g() {
        synchronized (this) {
            this.f11365g = false;
            this.f11367i.d();
        }
    }

    public void h() {
        if (this.f11364f.compareAndSet(false, true)) {
            C0495a c0495a = this.f11362d;
            if (c0495a != null) {
                c0495a.e();
            }
            this.f11363e.m().execute(this.f11372n);
        }
    }

    public void i(c cVar) {
        d j10;
        synchronized (this.f11369k) {
            j10 = this.f11369k.j(cVar);
        }
        if (j10 != null && this.f11367i.c(j10.f11379a)) {
            o();
        }
    }

    public final String[] j(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f11361c.containsKey(lowerCase)) {
                hashSet.addAll(this.f11361c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void k(C0495a c0495a) {
        this.f11362d = c0495a;
        c0495a.h(new Runnable() { // from class: androidx.room.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.g();
            }
        });
    }

    public void l(Context context, String str, Intent intent) {
        this.f11370l = new MultiInstanceInvalidationClient(context, str, intent, this, this.f11363e.m());
    }

    public final void m(e0.g gVar, int i10) {
        gVar.m("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f11360b[i10];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f11358o) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i10);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            gVar.m(sb.toString());
        }
    }

    public final void n(e0.g gVar, int i10) {
        String str = this.f11360b[i10];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f11358o) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, str2);
            gVar.m(sb.toString());
        }
    }

    public void o() {
        if (!this.f11363e.v()) {
            return;
        }
        p(this.f11363e.l().M());
    }

    public void p(e0.g gVar) {
        if (gVar.e0()) {
            return;
        }
        try {
            Lock k10 = this.f11363e.k();
            k10.lock();
            try {
                synchronized (this.f11371m) {
                    int[] a10 = this.f11367i.a();
                    if (a10 == null) {
                        return;
                    }
                    int length = a10.length;
                    c(gVar);
                    for (int i10 = 0; i10 < length; i10++) {
                        try {
                            int i11 = a10[i10];
                            if (i11 != 1) {
                                if (i11 == 2) {
                                    n(gVar, i10);
                                }
                            } else {
                                m(gVar, i10);
                            }
                        } catch (Throwable th) {
                            gVar.P();
                            throw th;
                        }
                    }
                    gVar.D();
                    gVar.P();
                }
            } finally {
                k10.unlock();
            }
        } catch (SQLiteException | IllegalStateException e10) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
        }
    }
}
