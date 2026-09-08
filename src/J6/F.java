package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;

/* compiled from: RoundedCornersParser.java */
/* loaded from: classes3.dex */
public class F {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33896a = JsonReader.a.a("nm", "r", "hd");

    public static g6.h a(JsonReader jsonReader, C0820a c0820a) {
        boolean z10 = false;
        String str = null;
        C1015b c1015b = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33896a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        jsonReader.S();
                    } else {
                        z10 = jsonReader.o();
                    }
                } else {
                    c1015b = C1176d.f(jsonReader, c0820a, true);
                }
            } else {
                str = jsonReader.y();
            }
        }
        if (z10) {
            return null;
        }
        return new g6.h(str, c1015b);
    }
}
