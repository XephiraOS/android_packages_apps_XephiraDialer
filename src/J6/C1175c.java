package j6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;
import f6.C1017d;
import f6.C1018e;
import m6.C1337c;
import m6.C1338d;

/* compiled from: AnimatableTransformParser.java */
/* renamed from: j6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1175c {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33909a = JsonReader.a.a("a", "p", "s", "rz", "r", com.android.contacts.util.o.f17586f, "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33910b = JsonReader.a.a("k");

    public static boolean a(C1018e c1018e) {
        if (c1018e != null && (!c1018e.c() || !c1018e.b().get(0).f35155b.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    public static boolean b(f6.m<PointF, PointF> mVar) {
        if (mVar != null && ((mVar instanceof f6.i) || !mVar.c() || !mVar.b().get(0).f35155b.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(C1015b c1015b) {
        if (c1015b != null && (!c1015b.c() || ((Float) ((C1337c) c1015b.b().get(0)).f35155b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(f6.g gVar) {
        if (gVar != null && (!gVar.c() || !((C1338d) ((C1337c) gVar.b().get(0)).f35155b).a(1.0f, 1.0f))) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean e(C1015b c1015b) {
        if (c1015b != null && (!c1015b.c() || ((Float) ((C1337c) c1015b.b().get(0)).f35155b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean f(C1015b c1015b) {
        if (c1015b != null && (!c1015b.c() || ((Float) ((C1337c) c1015b.b().get(0)).f35155b).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    public static f6.l g(JsonReader jsonReader, C0820a c0820a) {
        boolean z10;
        C1018e c1018e;
        f6.m<PointF, PointF> mVar;
        C1015b c1015b;
        C1015b c1015b2;
        C1015b c1015b3;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (jsonReader.G() == JsonReader.Token.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.e();
        }
        C1015b c1015b4 = null;
        C1018e c1018e2 = null;
        f6.m<PointF, PointF> mVar2 = null;
        f6.g gVar = null;
        C1015b c1015b5 = null;
        C1015b c1015b6 = null;
        C1017d c1017d = null;
        C1015b c1015b7 = null;
        C1015b c1015b8 = null;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33909a)) {
                case 0:
                    z11 = z13;
                    jsonReader.e();
                    while (jsonReader.l()) {
                        if (jsonReader.L(f33910b) != 0) {
                            jsonReader.O();
                            jsonReader.S();
                        } else {
                            c1018e2 = C1173a.a(jsonReader, c0820a);
                        }
                    }
                    jsonReader.g();
                    break;
                case 1:
                    mVar2 = C1173a.b(jsonReader, c0820a);
                    continue;
                case 2:
                    gVar = C1176d.j(jsonReader, c0820a);
                    continue;
                case 3:
                    z11 = z13;
                    c0820a.a("EffectiveAnimation doesn't support 3D layers.");
                    break;
                case 4:
                    C1015b f10 = C1176d.f(jsonReader, c0820a, z13);
                    if (f10.b().isEmpty()) {
                        f10.b().add(new C1337c(c0820a, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c0820a.f())));
                    } else if (((C1337c) f10.b().get(0)).f35155b == 0) {
                        z12 = false;
                        f10.b().set(0, new C1337c(c0820a, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c0820a.f())));
                        z13 = z12;
                        c1015b4 = f10;
                        continue;
                    }
                    z12 = false;
                    z13 = z12;
                    c1015b4 = f10;
                    continue;
                case 5:
                    c1017d = C1176d.h(jsonReader, c0820a);
                    continue;
                case 6:
                    c1015b7 = C1176d.f(jsonReader, c0820a, z13);
                    continue;
                case 7:
                    c1015b8 = C1176d.f(jsonReader, c0820a, z13);
                    continue;
                case 8:
                    c1015b5 = C1176d.f(jsonReader, c0820a, z13);
                    continue;
                case 9:
                    c1015b6 = C1176d.f(jsonReader, c0820a, z13);
                    continue;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    z11 = z13;
                    break;
            }
            z13 = z11;
        }
        if (z10) {
            jsonReader.g();
        }
        if (a(c1018e2)) {
            c1018e = null;
        } else {
            c1018e = c1018e2;
        }
        if (b(mVar2)) {
            mVar = null;
        } else {
            mVar = mVar2;
        }
        if (c(c1015b4)) {
            c1015b = null;
        } else {
            c1015b = c1015b4;
        }
        if (d(gVar)) {
            gVar = null;
        }
        if (f(c1015b5)) {
            c1015b2 = null;
        } else {
            c1015b2 = c1015b5;
        }
        if (e(c1015b6)) {
            c1015b3 = null;
        } else {
            c1015b3 = c1015b6;
        }
        return new f6.l(c1018e, mVar, gVar, c1015b, c1017d, c1015b7, c1015b8, c1015b2, c1015b3);
    }
}
