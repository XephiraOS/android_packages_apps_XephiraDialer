package j6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.model.content.PolystarShape;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;

/* compiled from: PolystarShapeParser.java */
/* renamed from: j6.C, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1170C {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33893a = JsonReader.a.a("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", com.android.contacts.list.d.f16900U);

    public static PolystarShape a(JsonReader jsonReader, C0820a c0820a, int i10) {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = false;
        boolean z12 = z10;
        String str = null;
        PolystarShape.Type type = null;
        C1015b c1015b = null;
        f6.m<PointF, PointF> mVar = null;
        C1015b c1015b2 = null;
        C1015b c1015b3 = null;
        C1015b c1015b4 = null;
        C1015b c1015b5 = null;
        C1015b c1015b6 = null;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33893a)) {
                case 0:
                    str = jsonReader.y();
                    break;
                case 1:
                    type = PolystarShape.Type.a(jsonReader.s());
                    break;
                case 2:
                    c1015b = C1176d.f(jsonReader, c0820a, false);
                    break;
                case 3:
                    mVar = C1173a.b(jsonReader, c0820a);
                    break;
                case 4:
                    c1015b2 = C1176d.f(jsonReader, c0820a, false);
                    break;
                case 5:
                    c1015b4 = C1176d.e(jsonReader, c0820a);
                    break;
                case 6:
                    c1015b6 = C1176d.f(jsonReader, c0820a, false);
                    break;
                case 7:
                    c1015b3 = C1176d.e(jsonReader, c0820a);
                    break;
                case 8:
                    c1015b5 = C1176d.f(jsonReader, c0820a, false);
                    break;
                case 9:
                    z11 = jsonReader.o();
                    break;
                case 10:
                    if (jsonReader.s() == 3) {
                        z12 = true;
                        break;
                    } else {
                        z12 = false;
                        break;
                    }
                default:
                    jsonReader.O();
                    jsonReader.S();
                    break;
            }
        }
        return new PolystarShape(str, type, c1015b, mVar, c1015b2, c1015b3, c1015b4, c1015b5, c1015b6, z11, z12);
    }
}
