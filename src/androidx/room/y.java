package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class y implements e0.j, e0.i {

    /* renamed from: i, reason: collision with root package name */
    public static final TreeMap<Integer, y> f11392i = new TreeMap<>();

    /* renamed from: a, reason: collision with root package name */
    public volatile String f11393a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f11394b;

    /* renamed from: c, reason: collision with root package name */
    public final double[] f11395c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f11396d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[][] f11397e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f11398f;

    /* renamed from: g, reason: collision with root package name */
    public final int f11399g;

    /* renamed from: h, reason: collision with root package name */
    public int f11400h;

    public y(int i10) {
        this.f11399g = i10;
        int i11 = i10 + 1;
        this.f11398f = new int[i11];
        this.f11394b = new long[i11];
        this.f11395c = new double[i11];
        this.f11396d = new String[i11];
        this.f11397e = new byte[i11];
    }

    public static y e(String str, int i10) {
        TreeMap<Integer, y> treeMap = f11392i;
        synchronized (treeMap) {
            try {
                Map.Entry<Integer, y> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    y value = ceilingEntry.getValue();
                    value.f(str, i10);
                    return value;
                }
                y yVar = new y(i10);
                yVar.f(str, i10);
                return yVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void g() {
        TreeMap<Integer, y> treeMap = f11392i;
        if (treeMap.size() > 15) {
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            while (true) {
                int i10 = size - 1;
                if (size > 0) {
                    it.next();
                    it.remove();
                    size = i10;
                } else {
                    return;
                }
            }
        }
    }

    @Override // e0.i
    public void C(int i10, long j10) {
        this.f11398f[i10] = 2;
        this.f11394b[i10] = j10;
    }

    @Override // e0.i
    public void H(int i10, byte[] bArr) {
        this.f11398f[i10] = 5;
        this.f11397e[i10] = bArr;
    }

    @Override // e0.i
    public void Y(int i10) {
        this.f11398f[i10] = 1;
    }

    @Override // e0.j
    public void a(e0.i iVar) {
        for (int i10 = 1; i10 <= this.f11400h; i10++) {
            int i11 = this.f11398f[i10];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            if (i11 == 5) {
                                iVar.H(i10, this.f11397e[i10]);
                            }
                        } else {
                            iVar.n(i10, this.f11396d[i10]);
                        }
                    } else {
                        iVar.t(i10, this.f11395c[i10]);
                    }
                } else {
                    iVar.C(i10, this.f11394b[i10]);
                }
            } else {
                iVar.Y(i10);
            }
        }
    }

    @Override // e0.j
    public String c() {
        return this.f11393a;
    }

    public void f(String str, int i10) {
        this.f11393a = str;
        this.f11400h = i10;
    }

    public void l() {
        TreeMap<Integer, y> treeMap = f11392i;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f11399g), this);
            g();
        }
    }

    @Override // e0.i
    public void n(int i10, String str) {
        this.f11398f[i10] = 4;
        this.f11396d[i10] = str;
    }

    @Override // e0.i
    public void t(int i10, double d10) {
        this.f11398f[i10] = 3;
        this.f11395c[i10] = d10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
