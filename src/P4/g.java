package P4;

/* compiled from: ResultPoint.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public final float f2956a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2957b;

    public g(float f10, float f11) {
        this.f2956a = f10;
        this.f2957b = f11;
    }

    public static float a(g gVar, g gVar2, g gVar3) {
        float f10 = gVar2.f2956a;
        float f11 = gVar2.f2957b;
        return ((gVar3.f2956a - f10) * (gVar.f2957b - f11)) - ((gVar3.f2957b - f11) * (gVar.f2956a - f10));
    }

    public static float b(g gVar, g gVar2) {
        return T4.a.a(gVar.f2956a, gVar.f2957b, gVar2.f2956a, gVar2.f2957b);
    }

    public static void e(g[] gVarArr) {
        g gVar;
        g gVar2;
        g gVar3;
        float b10 = b(gVarArr[0], gVarArr[1]);
        float b11 = b(gVarArr[1], gVarArr[2]);
        float b12 = b(gVarArr[0], gVarArr[2]);
        if (b11 >= b10 && b11 >= b12) {
            gVar = gVarArr[0];
            gVar2 = gVarArr[1];
            gVar3 = gVarArr[2];
        } else if (b12 >= b11 && b12 >= b10) {
            gVar = gVarArr[1];
            gVar2 = gVarArr[0];
            gVar3 = gVarArr[2];
        } else {
            gVar = gVarArr[2];
            gVar2 = gVarArr[0];
            gVar3 = gVarArr[1];
        }
        if (a(gVar2, gVar, gVar3) < 0.0f) {
            g gVar4 = gVar3;
            gVar3 = gVar2;
            gVar2 = gVar4;
        }
        gVarArr[0] = gVar2;
        gVarArr[1] = gVar;
        gVarArr[2] = gVar3;
    }

    public final float c() {
        return this.f2956a;
    }

    public final float d() {
        return this.f2957b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.f2956a == gVar.f2956a && this.f2957b == gVar.f2957b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f2956a) * 31) + Float.floatToIntBits(this.f2957b);
    }

    public final String toString() {
        return "(" + this.f2956a + ',' + this.f2957b + ')';
    }
}
