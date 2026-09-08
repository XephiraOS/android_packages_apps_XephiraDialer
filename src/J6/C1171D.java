package j6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;

/* compiled from: RectangleShapeParser.java */
/* renamed from: j6.D, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1171D {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33894a = JsonReader.a.a("nm", "p", "s", "r", "hd");

    public static g6.f a(JsonReader jsonReader, C0820a c0820a) {
        String str = null;
        f6.m<PointF, PointF> mVar = null;
        f6.f fVar = null;
        C1015b c1015b = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33894a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            if (L10 != 4) {
                                jsonReader.S();
                            } else {
                                z10 = jsonReader.o();
                            }
                        } else {
                            c1015b = C1176d.e(jsonReader, c0820a);
                        }
                    } else {
                        fVar = C1176d.i(jsonReader, c0820a);
                    }
                } else {
                    mVar = C1173a.b(jsonReader, c0820a);
                }
            } else {
                str = jsonReader.y();
            }
        }
        return new g6.f(str, mVar, fVar, c1015b, z10);
    }
}
