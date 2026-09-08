package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;

/* compiled from: RepeaterParser.java */
/* renamed from: j6.E, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1172E {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33895a = JsonReader.a.a("nm", "c", com.android.contacts.util.o.f17586f, "tr", "hd");

    public static g6.g a(JsonReader jsonReader, C0820a c0820a) {
        String str = null;
        C1015b c1015b = null;
        C1015b c1015b2 = null;
        f6.l lVar = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33895a);
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
                            lVar = C1175c.g(jsonReader, c0820a);
                        }
                    } else {
                        c1015b2 = C1176d.f(jsonReader, c0820a, false);
                    }
                } else {
                    c1015b = C1176d.f(jsonReader, c0820a, false);
                }
            } else {
                str = jsonReader.y();
            }
        }
        return new g6.g(str, c1015b, c1015b2, lVar, z10);
    }
}
