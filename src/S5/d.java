package s5;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import java.util.LinkedList;
import java.util.TreeMap;

/* compiled from: BufferPoolImpl.java */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f36819a = "BufferPoolImpl";

    /* renamed from: b, reason: collision with root package name */
    public static final TreeMap<Integer, Object> f36820b = new TreeMap<>();

    /* renamed from: c, reason: collision with root package name */
    public static final SparseArray<b> f36821c = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    public static final Object f36822d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static int f36823e;

    /* renamed from: f, reason: collision with root package name */
    public static int f36824f;

    /* renamed from: g, reason: collision with root package name */
    public static int f36825g;

    /* renamed from: h, reason: collision with root package name */
    public static int f36826h;

    /* renamed from: i, reason: collision with root package name */
    public static int f36827i;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f36828j;

    /* compiled from: BufferPoolImpl.java */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static int f36829f;

        /* renamed from: a, reason: collision with root package name */
        public final int f36830a;

        /* renamed from: b, reason: collision with root package name */
        public LinkedList<byte[]> f36831b;

        /* renamed from: c, reason: collision with root package name */
        public int f36832c;

        /* renamed from: d, reason: collision with root package name */
        public int f36833d;

        /* renamed from: e, reason: collision with root package name */
        public int f36834e;

        public static void i(b bVar) {
            bVar.g();
            f36829f++;
        }

        public synchronized LinkedList<byte[]> a() {
            return this.f36831b;
        }

        public final float b() {
            float f10 = this.f36833d;
            float f11 = this.f36832c;
            if (f10 != 0.0f) {
                return f11 / f10;
            }
            return f11;
        }

        public final float c() {
            return this.f36832c / f36829f;
        }

        public synchronized LinkedList<byte[]> d() {
            try {
                if (this.f36831b == null) {
                    this.f36831b = new LinkedList<>();
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f36831b;
        }

        public synchronized int e() {
            return this.f36830a;
        }

        public float f() {
            float c10;
            synchronized (d.f36822d) {
                c10 = d.f36823e * c();
            }
            return c10;
        }

        public synchronized void g() {
            this.f36832c++;
        }

        public synchronized boolean h() {
            this.f36833d++;
            if (this.f36831b.size() == this.f36834e) {
                if (b() < 0.9f) {
                    return false;
                }
                this.f36834e = ((this.f36834e * 3) / 2) + 1;
            }
            return true;
        }

        public b(int i10) {
            this.f36830a = i10;
            this.f36832c = 0;
            this.f36833d = 0;
            this.f36831b = null;
            this.f36834e = 1;
        }
    }

    public static C1551a b(int i10, int i11, boolean z10) {
        byte[] removeLast;
        synchronized (f36822d) {
            try {
                b j10 = j(i10);
                C1551a c1551a = null;
                if (j10 == null) {
                    return null;
                }
                LinkedList<byte[]> a10 = j10.a();
                if (a10 == null || a10.isEmpty()) {
                    return null;
                }
                if (z10) {
                    if (i10 == i11) {
                        if (a10.getLast().length == i11) {
                            removeLast = a10.removeLast();
                        }
                        removeLast = null;
                    } else {
                        if (a10.getFirst().length == i11) {
                            removeLast = a10.removeFirst();
                        }
                        removeLast = null;
                    }
                } else {
                    removeLast = a10.removeLast();
                }
                if (removeLast != null) {
                    f36827i -= removeLast.length;
                    b.i(j10);
                    c1551a = new C1551a(removeLast, i11);
                }
                return c1551a;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006c, code lost:
    
        r7 = new s5.C1551a(new byte[r1], r6);
        r6 = j(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
    
        if (r6 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        s5.d.b.i(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        f(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0084, code lost:
    
        if (j(r1) == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
    
        s5.d.b.i(j(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static s5.C1551a c(int r6, boolean r7) {
        /*
            java.lang.Object r0 = s5.d.f36822d
            monitor-enter(r0)
            int r1 = s5.d.f36824f     // Catch: java.lang.Throwable -> L2b
            if (r6 <= r1) goto L2e
            java.lang.String r7 = s5.d.f36819a     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "Buffer '"
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            r1.append(r6)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "' is not matching with the pool sizes! creating new..."
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2b
            android.util.Log.w(r7, r1)     // Catch: java.lang.Throwable -> L2b
            s5.a r7 = new s5.a     // Catch: java.lang.Throwable -> L2b
            byte[] r1 = new byte[r6]     // Catch: java.lang.Throwable -> L2b
            r7.<init>(r1, r6)     // Catch: java.lang.Throwable -> L2b
            goto L8f
        L2b:
            r6 = move-exception
            goto L91
        L2e:
            if (r7 == 0) goto L32
            r1 = r6
            goto L36
        L32:
            int r1 = h(r6)     // Catch: java.lang.Throwable -> L2b
        L36:
            s5.a r2 = b(r1, r6, r7)     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L8e
            r3 = 1
            r4 = r1
        L3e:
            if (r2 != 0) goto L6a
            r5 = 3
            if (r3 > r5) goto L6a
            if (r7 == 0) goto L51
            int r5 = h(r6)     // Catch: java.lang.Throwable -> L2b
            if (r6 != r5) goto L4c
            goto L51
        L4c:
            int r4 = m(r4)     // Catch: java.lang.Throwable -> L2b
            goto L55
        L51:
            int r4 = l(r4)     // Catch: java.lang.Throwable -> L2b
        L55:
            r5 = 24
            if (r4 < r5) goto L6a
            r5 = 66560(0x10400, float:9.327E-41)
            if (r4 > r5) goto L6a
            int r5 = s5.d.f36824f     // Catch: java.lang.Throwable -> L2b
            if (r4 <= r5) goto L63
            goto L6a
        L63:
            s5.a r2 = b(r4, r6, r7)     // Catch: java.lang.Throwable -> L2b
            int r3 = r3 + 1
            goto L3e
        L6a:
            if (r2 != 0) goto L8e
            s5.a r7 = new s5.a     // Catch: java.lang.Throwable -> L2b
            byte[] r2 = new byte[r1]     // Catch: java.lang.Throwable -> L2b
            r7.<init>(r2, r6)     // Catch: java.lang.Throwable -> L2b
            s5.d$b r6 = j(r1)     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L7d
            s5.d.b.i(r6)     // Catch: java.lang.Throwable -> L2b
            goto L8f
        L7d:
            f(r1)     // Catch: java.lang.Throwable -> L2b
            s5.d$b r6 = j(r1)     // Catch: java.lang.Throwable -> L2b
            if (r6 == 0) goto L8f
            s5.d$b r6 = j(r1)     // Catch: java.lang.Throwable -> L2b
            s5.d.b.i(r6)     // Catch: java.lang.Throwable -> L2b
            goto L8f
        L8e:
            r7 = r2
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            return r7
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.d.c(int, boolean):s5.a");
    }

    public static void d(int i10) {
        int[] iArr = {30731, 32779, 61451, 65541};
        synchronized (f36822d) {
            for (int i11 = 0; i11 < 4; i11++) {
                try {
                    f(iArr[i11]);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean f(int i10) {
        synchronized (f36822d) {
            try {
                if (i10 <= f36824f) {
                    SparseArray<b> sparseArray = f36821c;
                    if (sparseArray.indexOfKey(i10) < 0) {
                        f36820b.put(Integer.valueOf(i10), null);
                        sparseArray.put(i10, new b(i10));
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int g() {
        int i10;
        int size;
        synchronized (f36822d) {
            try {
                int i11 = f36827i;
                int size2 = f36821c.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    b valueAt = f36821c.valueAt(i12);
                    if (valueAt != null) {
                        int f10 = (int) (valueAt.f() / valueAt.e());
                        LinkedList<byte[]> a10 = valueAt.a();
                        if (a10 == null) {
                            size = 0;
                        } else {
                            size = a10.size();
                        }
                        while (size > f10) {
                            if (a10 != null) {
                                f36827i -= a10.removeLast().length;
                                size--;
                            }
                        }
                    }
                }
                Log.w(f36819a, "Pool Stabilized; Cache size reduced from  " + i11 + " -> " + f36827i);
                i10 = i11 - f36827i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    public static int h(int i10) {
        Integer ceilingKey = f36820b.ceilingKey(Integer.valueOf(i10));
        if (ceilingKey != null) {
            return ceilingKey.intValue();
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:21:0x0029, B:24:0x0035, B:26:0x0059, B:27:0x006d, B:29:0x006f, B:31:0x0077, B:33:0x0085, B:35:0x008b, B:37:0x008f, B:40:0x009c, B:42:0x00a1, B:45:0x00a4, B:46:0x00bc, B:49:0x0030, B:50:0x0033), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:21:0x0029, B:24:0x0035, B:26:0x0059, B:27:0x006d, B:29:0x006f, B:31:0x0077, B:33:0x0085, B:35:0x008b, B:37:0x008f, B:40:0x009c, B:42:0x00a1, B:45:0x00a4, B:46:0x00bc, B:49:0x0030, B:50:0x0033), top: B:9:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(int r6) {
        /*
            boolean r0 = p()
            r1 = 0
            if (r0 != 0) goto Lf
            java.lang.String r6 = s5.d.f36819a
            java.lang.String r0 = "Failed to clear cache - Bufferpool not initialised!"
            android.util.Log.w(r6, r0)
            return r1
        Lf:
            java.lang.Object r0 = s5.d.f36822d
            monitor-enter(r0)
            r2 = 5
            if (r6 == r2) goto L33
            r2 = 10
            if (r6 == r2) goto L30
            r2 = 15
            if (r6 == r2) goto L2e
            r2 = 40
            if (r6 == r2) goto L33
            r2 = 60
            if (r6 == r2) goto L30
            r2 = 80
            if (r6 == r2) goto L2e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            return r1
        L2b:
            r6 = move-exception
            goto Lbf
        L2e:
            r2 = r1
            goto L35
        L30:
            int r2 = s5.d.f36826h     // Catch: java.lang.Throwable -> L2b
            goto L35
        L33:
            int r2 = s5.d.f36825g     // Catch: java.lang.Throwable -> L2b
        L35:
            java.lang.String r3 = s5.d.f36819a     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r4.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = "ClearCache["
            r4.append(r5)     // Catch: java.lang.Throwable -> L2b
            r4.append(r6)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = "] : Cache Size BEFORE = "
            r4.append(r6)     // Catch: java.lang.Throwable -> L2b
            int r6 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            r4.append(r6)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L2b
            android.util.Log.v(r3, r6)     // Catch: java.lang.Throwable -> L2b
            int r6 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            if (r6 > r2) goto L6f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r6.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r4 = "ClearCache : Current cache size is lesser than the threshold of "
            r6.append(r4)     // Catch: java.lang.Throwable -> L2b
            r6.append(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L2b
            android.util.Log.w(r3, r6)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            return r1
        L6f:
            android.util.SparseArray<s5.d$b> r6 = s5.d.f36821c     // Catch: java.lang.Throwable -> L2b
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L2b
        L75:
            if (r1 >= r6) goto La4
            android.util.SparseArray<s5.d$b> r3 = s5.d.f36821c     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r3 = r3.valueAt(r1)     // Catch: java.lang.Throwable -> L2b
            s5.d$b r3 = (s5.d.b) r3     // Catch: java.lang.Throwable -> L2b
            java.util.LinkedList r3 = r3.a()     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L9c
        L85:
            boolean r4 = r3.isEmpty()     // Catch: java.lang.Throwable -> L2b
            if (r4 != 0) goto L9c
            int r4 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            if (r4 <= r2) goto L9c
            java.lang.Object r4 = r3.removeLast()     // Catch: java.lang.Throwable -> L2b
            byte[] r4 = (byte[]) r4     // Catch: java.lang.Throwable -> L2b
            int r5 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            int r4 = r4.length     // Catch: java.lang.Throwable -> L2b
            int r5 = r5 - r4
            s5.d.f36827i = r5     // Catch: java.lang.Throwable -> L2b
            goto L85
        L9c:
            int r3 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            if (r3 > r2) goto La1
            goto La4
        La1:
            int r1 = r1 + 1
            goto L75
        La4:
            java.lang.String r6 = s5.d.f36819a     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r2 = "ClearCache : Cache Size AFTER = "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            int r2 = s5.d.f36827i     // Catch: java.lang.Throwable -> L2b
            r1.append(r2)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2b
            android.util.Log.d(r6, r1)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            r6 = 1
            return r6
        Lbf:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.d.i(int):boolean");
    }

    public static b j(int i10) {
        b bVar;
        synchronized (f36822d) {
            bVar = f36821c.get(i10);
        }
        return bVar;
    }

    public static int k(int i10) {
        Integer floorKey = f36820b.floorKey(Integer.valueOf(i10));
        if (floorKey != null) {
            return floorKey.intValue();
        }
        return i10;
    }

    public static int l(int i10) {
        Integer higherKey = f36820b.higherKey(Integer.valueOf(i10));
        if (higherKey == null) {
            return Integer.MAX_VALUE;
        }
        return higherKey.intValue();
    }

    public static int m(int i10) {
        Integer lowerKey = f36820b.lowerKey(Integer.valueOf(i10));
        if (lowerKey == null) {
            return Integer.MIN_VALUE;
        }
        return lowerKey.intValue();
    }

    public static void n(Context context) {
        o(c.a(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0015, B:13:0x0020, B:15:0x0028, B:16:0x0034, B:18:0x0047, B:20:0x0056, B:23:0x005d, B:25:0x0060, B:29:0x0065, B:31:0x006e, B:32:0x0075, B:33:0x0098, B:35:0x0072, B:36:0x0030, B:37:0x0037, B:39:0x003b, B:41:0x003f, B:44:0x009a, B:45:0x00c1), top: B:10:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0015, B:13:0x0020, B:15:0x0028, B:16:0x0034, B:18:0x0047, B:20:0x0056, B:23:0x005d, B:25:0x0060, B:29:0x0065, B:31:0x006e, B:32:0x0075, B:33:0x0098, B:35:0x0072, B:36:0x0030, B:37:0x0037, B:39:0x003b, B:41:0x003f, B:44:0x009a, B:45:0x00c1), top: B:10:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[Catch: all -> 0x002d, TryCatch #0 {all -> 0x002d, blocks: (B:11:0x0015, B:13:0x0020, B:15:0x0028, B:16:0x0034, B:18:0x0047, B:20:0x0056, B:23:0x005d, B:25:0x0060, B:29:0x0065, B:31:0x006e, B:32:0x0075, B:33:0x0098, B:35:0x0072, B:36:0x0030, B:37:0x0037, B:39:0x003b, B:41:0x003f, B:44:0x009a, B:45:0x00c1), top: B:10:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void o(s5.c r5) {
        /*
            boolean r0 = p()
            if (r0 == 0) goto Lf
            java.lang.String r5 = s5.d.f36819a
            java.lang.String r0 = "BufferPool already initialised!"
            n5.C1371a.g(r5, r0)
            goto L99
        Lf:
            if (r5 == 0) goto Lc4
            java.lang.Object r0 = s5.d.f36822d
            monitor-enter(r0)
            r1 = 0
            s5.d.f36827i = r1     // Catch: java.lang.Throwable -> L2d
            boolean r1 = r5.f36818d     // Catch: java.lang.Throwable -> L2d
            r2 = 24
            r3 = 66560(0x10400, float:9.327E-41)
            if (r1 == 0) goto L37
            android.content.Context r5 = r5.f36815a     // Catch: java.lang.Throwable -> L2d
            boolean r5 = q(r5)     // Catch: java.lang.Throwable -> L2d
            if (r5 == 0) goto L30
            r5 = 2097152(0x200000, float:2.938736E-39)
            s5.d.f36823e = r5     // Catch: java.lang.Throwable -> L2d
            goto L34
        L2d:
            r5 = move-exception
            goto Lc2
        L30:
            r5 = 4194304(0x400000, float:5.877472E-39)
            s5.d.f36823e = r5     // Catch: java.lang.Throwable -> L2d
        L34:
            s5.d.f36824f = r3     // Catch: java.lang.Throwable -> L2d
            goto L46
        L37:
            int r1 = r5.f36817c     // Catch: java.lang.Throwable -> L2d
            if (r1 < r2) goto L9a
            int r4 = r5.f36816b     // Catch: java.lang.Throwable -> L2d
            if (r4 < r1) goto L9a
            s5.d.f36823e = r4     // Catch: java.lang.Throwable -> L2d
            s5.d.f36824f = r1     // Catch: java.lang.Throwable -> L2d
            if (r1 > r3) goto L46
            goto L47
        L46:
            r1 = r3
        L47:
            int r5 = s5.d.f36823e     // Catch: java.lang.Throwable -> L2d
            int r4 = r5 / 4
            s5.d.f36825g = r4     // Catch: java.lang.Throwable -> L2d
            int r5 = r5 / 2
            s5.d.f36826h = r5     // Catch: java.lang.Throwable -> L2d
            r5 = 36
            r4 = r2
        L54:
            if (r4 > r1) goto L65
            f(r4)     // Catch: java.lang.Throwable -> L2d
            if (r4 == r2) goto L60
            if (r5 > r1) goto L60
            f(r5)     // Catch: java.lang.Throwable -> L2d
        L60:
            int r4 = r4 * 2
            int r5 = r5 * 2
            goto L54
        L65:
            int r5 = s5.d.f36824f     // Catch: java.lang.Throwable -> L2d
            d(r5)     // Catch: java.lang.Throwable -> L2d
            int r5 = s5.d.f36824f     // Catch: java.lang.Throwable -> L2d
            if (r5 <= r3) goto L72
            f(r5)     // Catch: java.lang.Throwable -> L2d
            goto L75
        L72:
            f(r1)     // Catch: java.lang.Throwable -> L2d
        L75:
            r5 = 1
            s5.d.f36828j = r5     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = s5.d.f36819a     // Catch: java.lang.Throwable -> L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r1.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = "BufferPool[v1.0.2] initialised with capacity "
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            int r2 = s5.d.f36823e     // Catch: java.lang.Throwable -> L2d
            r3 = 1048576(0x100000, float:1.469368E-39)
            int r2 = r2 / r3
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = "MB"
            r1.append(r2)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2d
            android.util.Log.i(r5, r1)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2d
        L99:
            return
        L9a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2d
            r2.<init>()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "Failed to initialise the Bufferpool! [Cache size="
            r2.append(r3)     // Catch: java.lang.Throwable -> L2d
            int r3 = r5.f36816b     // Catch: java.lang.Throwable -> L2d
            r2.append(r3)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r3 = "; Max chunk size="
            r2.append(r3)     // Catch: java.lang.Throwable -> L2d
            int r5 = r5.f36817c     // Catch: java.lang.Throwable -> L2d
            r2.append(r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = "]"
            r2.append(r5)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L2d
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            throw r1     // Catch: java.lang.Throwable -> L2d
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2d
            throw r5
        Lc4:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to initialise the BufferPool!"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s5.d.o(s5.c):void");
    }

    public static boolean p() {
        boolean z10;
        synchronized (f36822d) {
            z10 = f36828j;
        }
        return z10;
    }

    public static boolean q(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            Log.w(f36819a, "isLowMemoryDevice(): ActivityManager is null!");
            return true;
        }
        return activityManager.isLowRamDevice();
    }

    public static C1551a r(int i10) {
        if (p()) {
            return c(i10, false);
        }
        throw new RuntimeException("Bufferpool not initialised!");
    }

    public static C1551a s(int i10) {
        if (p()) {
            return c(i10, true);
        }
        throw new RuntimeException("Bufferpool not initialised!");
    }

    public static boolean t(byte[] bArr) {
        if (!p()) {
            Log.w(f36819a, "Failed to recycle buffer - Bufferpool not initialised!");
            return false;
        }
        if (bArr == null) {
            Log.w(f36819a, "Cannot recycle null buffer!");
            return false;
        }
        int length = bArr.length;
        Object obj = f36822d;
        synchronized (obj) {
            try {
                if (length > f36824f) {
                    Log.w(f36819a, "Cannot recycle buffer '" + length + "', Non-matcing size!");
                    return false;
                }
                int k10 = k(length);
                synchronized (obj) {
                    try {
                        b j10 = j(k10);
                        if (j10 == null) {
                            return false;
                        }
                        LinkedList<byte[]> d10 = j10.d();
                        if (!j10.h()) {
                            return false;
                        }
                        if (f36827i + length > f36823e) {
                            int f10 = ((int) j10.f()) / k10;
                            if (d10.size() >= f10) {
                                Log.w(f36819a, "Cannot recycle buffer '" + k10 + "', Buffer chunk count(" + d10.size() + ") exceeded the limit" + f10 + "!");
                                return false;
                            }
                            g();
                            if (f36827i + length > f36823e) {
                                Log.w(f36819a, "Cannot recycle buffer '" + k10 + "', Buffer cache limit exceeded!!!");
                                return false;
                            }
                        }
                        if (k10 == length) {
                            d10.addLast(bArr);
                        } else {
                            d10.addFirst(bArr);
                        }
                        f36827i += length;
                        return true;
                    } finally {
                    }
                }
            } finally {
            }
        }
    }
}
