package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.model.content.GradientType;
import com.oplus.anim.model.content.ShapeStroke;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;
import f6.C1016c;
import f6.C1017d;
import java.util.ArrayList;
import java.util.Collections;
import m6.C1337c;

/* compiled from: GradientStrokeParser.java */
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33941a = JsonReader.a.a("nm", "g", com.android.contacts.util.o.f17586f, "t", "s", "e", "w", "lc", "lj", "ml", "hd", com.android.contacts.list.d.f16900U);

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33942b = JsonReader.a.a("p", "k");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f33943c = JsonReader.a.a("n", s1.v.f36673e);

    public static com.oplus.anim.model.content.a a(JsonReader jsonReader, C0820a c0820a) {
        String str;
        C1016c c1016c;
        GradientType gradientType;
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        String str2 = null;
        GradientType gradientType2 = null;
        C1016c c1016c2 = null;
        f6.f fVar = null;
        f6.f fVar2 = null;
        C1015b c1015b = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        C1015b c1015b2 = null;
        boolean z10 = false;
        C1017d c1017d = null;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33941a)) {
                case 0:
                    str2 = jsonReader.y();
                    continue;
                case 1:
                    str = str2;
                    jsonReader.e();
                    int i10 = -1;
                    while (jsonReader.l()) {
                        int L10 = jsonReader.L(f33942b);
                        if (L10 != 0) {
                            c1016c = c1016c2;
                            if (L10 != 1) {
                                jsonReader.O();
                                jsonReader.S();
                            } else {
                                c1016c2 = C1176d.g(jsonReader, c0820a, i10);
                            }
                        } else {
                            c1016c = c1016c2;
                            i10 = jsonReader.s();
                        }
                        c1016c2 = c1016c;
                    }
                    jsonReader.g();
                    break;
                case 2:
                    c1017d = C1176d.h(jsonReader, c0820a);
                    continue;
                case 3:
                    str = str2;
                    if (jsonReader.s() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    fVar = C1176d.i(jsonReader, c0820a);
                    continue;
                case 5:
                    fVar2 = C1176d.i(jsonReader, c0820a);
                    continue;
                case 6:
                    c1015b = C1176d.e(jsonReader, c0820a);
                    continue;
                case 7:
                    str = str2;
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.s() - 1];
                    break;
                case 8:
                    str = str2;
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.s() - 1];
                    break;
                case 9:
                    str = str2;
                    f10 = (float) jsonReader.r();
                    break;
                case 10:
                    z10 = jsonReader.o();
                    continue;
                case 11:
                    jsonReader.c();
                    while (jsonReader.l()) {
                        jsonReader.e();
                        String str3 = null;
                        C1015b c1015b3 = null;
                        while (jsonReader.l()) {
                            int L11 = jsonReader.L(f33943c);
                            if (L11 != 0) {
                                C1015b c1015b4 = c1015b2;
                                if (L11 != 1) {
                                    jsonReader.O();
                                    jsonReader.S();
                                } else {
                                    c1015b3 = C1176d.e(jsonReader, c0820a);
                                }
                                c1015b2 = c1015b4;
                            } else {
                                str3 = jsonReader.y();
                            }
                        }
                        C1015b c1015b5 = c1015b2;
                        jsonReader.g();
                        if (str3.equals(com.android.contacts.util.o.f17586f)) {
                            c1015b2 = c1015b3;
                        } else {
                            if (str3.equals(com.android.contacts.list.d.f16900U) || str3.equals("g")) {
                                c0820a.u(true);
                                arrayList.add(c1015b3);
                            }
                            c1015b2 = c1015b5;
                        }
                    }
                    C1015b c1015b6 = c1015b2;
                    jsonReader.f();
                    if (arrayList.size() == 1) {
                        arrayList.add((C1015b) arrayList.get(0));
                    }
                    c1015b2 = c1015b6;
                    continue;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (c1017d == null) {
            c1017d = new C1017d(Collections.singletonList(new C1337c(100)));
        }
        return new com.oplus.anim.model.content.a(str4, gradientType2, c1016c2, c1017d, fVar, fVar2, c1015b, lineCapType, lineJoinType, f10, arrayList, c1015b2, z10);
    }
}
