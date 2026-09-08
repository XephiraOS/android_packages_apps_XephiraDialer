package e0;

/* compiled from: SimpleSQLiteQuery.java */
/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0962a implements j {

    /* renamed from: a, reason: collision with root package name */
    public final String f30545a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f30546b;

    public C0962a(String str, Object[] objArr) {
        this.f30545a = str;
        this.f30546b = objArr;
    }

    public static void b(i iVar, int i10, Object obj) {
        long j10;
        if (obj == null) {
            iVar.Y(i10);
            return;
        }
        if (obj instanceof byte[]) {
            iVar.H(i10, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            iVar.t(i10, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            iVar.t(i10, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            iVar.C(i10, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            iVar.C(i10, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            iVar.C(i10, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            iVar.C(i10, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            iVar.n(i10, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                j10 = 1;
            } else {
                j10 = 0;
            }
            iVar.C(i10, j10);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void d(i iVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i10 = 0;
        while (i10 < length) {
            Object obj = objArr[i10];
            i10++;
            b(iVar, i10, obj);
        }
    }

    @Override // e0.j
    public void a(i iVar) {
        d(iVar, this.f30546b);
    }

    @Override // e0.j
    public String c() {
        return this.f30545a;
    }

    public C0962a(String str) {
        this(str, null);
    }
}
