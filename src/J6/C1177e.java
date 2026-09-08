package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import g6.C1048a;

/* compiled from: BlurEffectParser.java */
/* renamed from: j6.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1177e {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33911a = JsonReader.a.a("ef");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33912b = JsonReader.a.a("ty", s1.v.f36673e);

    public static C1048a a(JsonReader jsonReader, C0820a c0820a) {
        jsonReader.e();
        C1048a c1048a = null;
        while (true) {
            boolean z10 = false;
            while (jsonReader.l()) {
                int L10 = jsonReader.L(f33912b);
                if (L10 != 0) {
                    if (L10 != 1) {
                        jsonReader.O();
                        jsonReader.S();
                    } else if (z10) {
                        c1048a = new C1048a(C1176d.e(jsonReader, c0820a));
                    } else {
                        jsonReader.S();
                    }
                } else if (jsonReader.s() == 0) {
                    z10 = true;
                }
            }
            jsonReader.g();
            return c1048a;
        }
    }

    public static C1048a b(JsonReader jsonReader, C0820a c0820a) {
        C1048a c1048a = null;
        while (jsonReader.l()) {
            if (jsonReader.L(f33911a) != 0) {
                jsonReader.O();
                jsonReader.S();
            } else {
                jsonReader.c();
                while (jsonReader.l()) {
                    C1048a a10 = a(jsonReader, c0820a);
                    if (a10 != null) {
                        c1048a = a10;
                    }
                }
                jsonReader.f();
            }
        }
        return c1048a;
    }
}
