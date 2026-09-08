package androidx.constraintlayout.solver;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public class SolverVariable {

    /* renamed from: r, reason: collision with root package name */
    public static int f8195r = 1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f8196a;

    /* renamed from: b, reason: collision with root package name */
    public String f8197b;

    /* renamed from: f, reason: collision with root package name */
    public float f8201f;

    /* renamed from: j, reason: collision with root package name */
    public Type f8205j;

    /* renamed from: c, reason: collision with root package name */
    public int f8198c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f8199d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f8200e = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8202g = false;

    /* renamed from: h, reason: collision with root package name */
    public float[] f8203h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    public float[] f8204i = new float[9];

    /* renamed from: k, reason: collision with root package name */
    public b[] f8206k = new b[16];

    /* renamed from: l, reason: collision with root package name */
    public int f8207l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f8208m = 0;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8209n = false;

    /* renamed from: o, reason: collision with root package name */
    public int f8210o = -1;

    /* renamed from: p, reason: collision with root package name */
    public float f8211p = 0.0f;

    /* renamed from: q, reason: collision with root package name */
    public HashSet<b> f8212q = null;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f8205j = type;
    }

    public static void b() {
        f8195r++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f8207l;
            if (i10 < i11) {
                if (this.f8206k[i10] == bVar) {
                    return;
                } else {
                    i10++;
                }
            } else {
                b[] bVarArr = this.f8206k;
                if (i11 >= bVarArr.length) {
                    this.f8206k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f8206k;
                int i12 = this.f8207l;
                bVarArr2[i12] = bVar;
                this.f8207l = i12 + 1;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i10 = this.f8207l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f8206k[i11] == bVar) {
                while (i11 < i10 - 1) {
                    b[] bVarArr = this.f8206k;
                    int i12 = i11 + 1;
                    bVarArr[i11] = bVarArr[i12];
                    i11 = i12;
                }
                this.f8207l--;
                return;
            }
            i11++;
        }
    }

    public void d() {
        this.f8197b = null;
        this.f8205j = Type.UNKNOWN;
        this.f8200e = 0;
        this.f8198c = -1;
        this.f8199d = -1;
        this.f8201f = 0.0f;
        this.f8202g = false;
        this.f8209n = false;
        this.f8210o = -1;
        this.f8211p = 0.0f;
        int i10 = this.f8207l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f8206k[i11] = null;
        }
        this.f8207l = 0;
        this.f8208m = 0;
        this.f8196a = false;
        Arrays.fill(this.f8204i, 0.0f);
    }

    public void e(c cVar, float f10) {
        this.f8201f = f10;
        this.f8202g = true;
        this.f8209n = false;
        this.f8210o = -1;
        this.f8211p = 0.0f;
        int i10 = this.f8207l;
        this.f8199d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f8206k[i11].A(cVar, this, false);
        }
        this.f8207l = 0;
    }

    public void f(Type type, String str) {
        this.f8205j = type;
    }

    public final void g(c cVar, b bVar) {
        int i10 = this.f8207l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f8206k[i11].B(cVar, bVar, false);
        }
        this.f8207l = 0;
    }

    public String toString() {
        if (this.f8197b != null) {
            return "" + this.f8197b;
        }
        return "" + this.f8198c;
    }
}
