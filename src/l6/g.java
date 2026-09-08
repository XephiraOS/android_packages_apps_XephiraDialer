package l6;

import android.graphics.Path;
import android.graphics.PointF;
import b6.k;
import e6.C0982a;
import g6.i;
import java.util.List;

/* compiled from: MiscUtils.java */
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final PointF f34723a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static int c(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean d(float f10, float f11, float f12) {
        if (f10 >= f11 && f10 <= f12) {
            return true;
        }
        return false;
    }

    public static int e(int i10, int i11) {
        boolean z10;
        int i12 = i10 / i11;
        if ((i10 ^ i11) >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = i10 % i11;
        if (!z10 && i13 != 0) {
            return i12 - 1;
        }
        return i12;
    }

    public static int f(float f10, float f11) {
        return g((int) f10, (int) f11);
    }

    public static int g(int i10, int i11) {
        return i10 - (i11 * e(i10, i11));
    }

    public static void h(i iVar, Path path) {
        path.reset();
        PointF b10 = iVar.b();
        path.moveTo(b10.x, b10.y);
        f34723a.set(b10.x, b10.y);
        for (int i10 = 0; i10 < iVar.a().size(); i10++) {
            C0982a c0982a = iVar.a().get(i10);
            PointF a10 = c0982a.a();
            PointF b11 = c0982a.b();
            PointF c10 = c0982a.c();
            PointF pointF = f34723a;
            if (a10.equals(pointF) && b11.equals(c10)) {
                path.lineTo(c10.x, c10.y);
            } else {
                path.cubicTo(a10.x, a10.y, b11.x, b11.y, c10.x, c10.y);
            }
            pointF.set(c10.x, c10.y);
        }
        if (iVar.d()) {
            path.close();
        }
    }

    public static float i(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static int j(int i10, int i11, float f10) {
        return (int) (i10 + (f10 * (i11 - i10)));
    }

    public static void k(e6.e eVar, int i10, List<e6.e> list, e6.e eVar2, k kVar) {
        if (eVar.c(kVar.getName(), i10)) {
            list.add(eVar2.a(kVar.getName()).i(kVar));
        }
    }
}
