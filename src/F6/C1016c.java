package f6;

import c6.AbstractC0558a;
import c6.C0562e;
import java.util.Arrays;
import java.util.List;
import m6.C1337c;

/* compiled from: AnimatableGradientColorValue.java */
/* renamed from: f6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1016c extends n<g6.d, g6.d> {
    public C1016c(List<C1337c<g6.d>> list) {
        super(e(list));
    }

    public static C1337c<g6.d> d(C1337c<g6.d> c1337c) {
        g6.d dVar = c1337c.f35155b;
        g6.d dVar2 = c1337c.f35156c;
        if (dVar != null && dVar2 != null && dVar.d().length != dVar2.d().length) {
            float[] f10 = f(dVar.d(), dVar2.d());
            return c1337c.b(dVar.a(f10), dVar2.a(f10));
        }
        return c1337c;
    }

    public static List<C1337c<g6.d>> e(List<C1337c<g6.d>> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, d(list.get(i10)));
        }
        return list;
    }

    public static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f10 = Float.NaN;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            float f11 = fArr3[i11];
            if (f11 != f10) {
                fArr3[i10] = f11;
                i10++;
                f10 = fArr3[i11];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i10);
    }

    @Override // f6.m
    public AbstractC0558a<g6.d, g6.d> a() {
        return new C0562e(this.f31770a);
    }

    @Override // f6.n, f6.m
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // f6.n, f6.m
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // f6.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
