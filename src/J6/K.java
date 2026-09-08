package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: ShapePathParser.java */
/* loaded from: classes3.dex */
public class K {

    /* renamed from: a, reason: collision with root package name */
    public static JsonReader.a f33902a = JsonReader.a.a("nm", "ind", "ks", "hd");

    public static g6.l a(JsonReader jsonReader, C0820a c0820a) {
        String str = null;
        int i10 = 0;
        boolean z10 = false;
        f6.h hVar = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33902a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            jsonReader.S();
                        } else {
                            z10 = jsonReader.o();
                        }
                    } else {
                        hVar = C1176d.k(jsonReader, c0820a);
                    }
                } else {
                    i10 = jsonReader.s();
                }
            } else {
                str = jsonReader.y();
            }
        }
        return new g6.l(str, i10, hVar, z10);
    }
}
