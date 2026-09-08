package j6;

import android.graphics.Path;
import com.oplus.anim.C0820a;
import com.oplus.anim.model.content.GradientType;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1016c;
import f6.C1017d;
import java.util.Collections;
import m6.C1337c;

/* compiled from: GradientFillParser.java */
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33939a = JsonReader.a.a("nm", "g", com.android.contacts.util.o.f17586f, "t", "s", "e", "r", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33940b = JsonReader.a.a("p", "k");

    public static g6.e a(JsonReader jsonReader, C0820a c0820a) {
        C1017d c1017d;
        GradientType gradientType;
        Path.FillType fillType;
        C1017d c1017d2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType2 = null;
        C1016c c1016c = null;
        f6.f fVar = null;
        f6.f fVar2 = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33939a)) {
                case 0:
                    str = jsonReader.y();
                    break;
                case 1:
                    jsonReader.e();
                    int i10 = -1;
                    while (jsonReader.l()) {
                        int L10 = jsonReader.L(f33940b);
                        if (L10 != 0) {
                            if (L10 != 1) {
                                jsonReader.O();
                                jsonReader.S();
                            } else {
                                c1016c = C1176d.g(jsonReader, c0820a, i10);
                            }
                        } else {
                            i10 = jsonReader.s();
                        }
                    }
                    jsonReader.g();
                    break;
                case 2:
                    c1017d2 = C1176d.h(jsonReader, c0820a);
                    break;
                case 3:
                    if (jsonReader.s() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    fVar = C1176d.i(jsonReader, c0820a);
                    break;
                case 5:
                    fVar2 = C1176d.i(jsonReader, c0820a);
                    break;
                case 6:
                    if (jsonReader.s() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z10 = jsonReader.o();
                    break;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    break;
            }
        }
        if (c1017d2 == null) {
            c1017d = new C1017d(Collections.singletonList(new C1337c(100)));
        } else {
            c1017d = c1017d2;
        }
        return new g6.e(str, gradientType2, fillType2, c1016c, c1017d, fVar, fVar2, null, null, z10);
    }
}
