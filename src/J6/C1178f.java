package j6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import g6.C1049b;

/* compiled from: CircleShapeParser.java */
/* renamed from: j6.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1178f {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33913a = JsonReader.a.a("nm", "p", "s", "hd", com.android.contacts.list.d.f16900U);

    public static C1049b a(JsonReader jsonReader, C0820a c0820a, int i10) {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        boolean z12 = false;
        String str = null;
        f6.m<PointF, PointF> mVar = null;
        f6.f fVar = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33913a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            if (L10 != 4) {
                                jsonReader.O();
                                jsonReader.S();
                            } else if (jsonReader.s() == 3) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                        } else {
                            z12 = jsonReader.o();
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
        return new C1049b(str, mVar, fVar, z11, z12);
    }
}
