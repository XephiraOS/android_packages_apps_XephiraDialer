package f5;

import java.util.Formatter;

/* compiled from: DetectionResultColumn.java */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final c f31749a;

    /* renamed from: b, reason: collision with root package name */
    public final d[] f31750b;

    public f(c cVar) {
        this.f31749a = new c(cVar);
        this.f31750b = new d[(cVar.e() - cVar.g()) + 1];
    }

    public final c a() {
        return this.f31749a;
    }

    public final d b(int i10) {
        return this.f31750b[e(i10)];
    }

    public final d c(int i10) {
        d dVar;
        d dVar2;
        d b10 = b(i10);
        if (b10 != null) {
            return b10;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int e10 = e(i10) - i11;
            if (e10 >= 0 && (dVar2 = this.f31750b[e10]) != null) {
                return dVar2;
            }
            int e11 = e(i10) + i11;
            d[] dVarArr = this.f31750b;
            if (e11 < dVarArr.length && (dVar = dVarArr[e11]) != null) {
                return dVar;
            }
        }
        return null;
    }

    public final d[] d() {
        return this.f31750b;
    }

    public final int e(int i10) {
        return i10 - this.f31749a.g();
    }

    public final void f(int i10, d dVar) {
        this.f31750b[e(i10)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i10 = 0;
            for (d dVar : this.f31750b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i10));
                    i10++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i10++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    formatter.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
