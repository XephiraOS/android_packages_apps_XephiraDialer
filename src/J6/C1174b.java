package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1014a;
import f6.C1015b;

/* compiled from: AnimatableTextPropertiesParser.java */
/* renamed from: j6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1174b {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33907a = JsonReader.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33908b = JsonReader.a.a("fc", "sc", "sw", "t");

    public static f6.k a(JsonReader jsonReader, C0820a c0820a) {
        jsonReader.e();
        f6.k kVar = null;
        while (jsonReader.l()) {
            if (jsonReader.L(f33907a) != 0) {
                jsonReader.O();
                jsonReader.S();
            } else {
                kVar = b(jsonReader, c0820a);
            }
        }
        jsonReader.g();
        if (kVar == null) {
            return new f6.k(null, null, null, null);
        }
        return kVar;
    }

    public static f6.k b(JsonReader jsonReader, C0820a c0820a) {
        jsonReader.e();
        C1014a c1014a = null;
        C1014a c1014a2 = null;
        C1015b c1015b = null;
        C1015b c1015b2 = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33908b);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            jsonReader.O();
                            jsonReader.S();
                        } else {
                            c1015b2 = C1176d.e(jsonReader, c0820a);
                        }
                    } else {
                        c1015b = C1176d.e(jsonReader, c0820a);
                    }
                } else {
                    c1014a2 = C1176d.c(jsonReader, c0820a);
                }
            } else {
                c1014a = C1176d.c(jsonReader, c0820a);
            }
        }
        jsonReader.g();
        return new f6.k(c1014a, c1014a2, c1015b, c1015b2);
    }
}
