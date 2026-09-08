package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import java.util.ArrayList;

/* compiled from: ShapeGroupParser.java */
/* loaded from: classes3.dex */
public class J {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33901a = JsonReader.a.a("nm", "hd", "it");

    public static g6.k a(JsonReader jsonReader, C0820a c0820a) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33901a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        jsonReader.S();
                    } else {
                        jsonReader.c();
                        while (jsonReader.l()) {
                            g6.c a10 = C1180h.a(jsonReader, c0820a);
                            if (a10 != null) {
                                arrayList.add(a10);
                            }
                        }
                        jsonReader.f();
                    }
                } else {
                    z10 = jsonReader.o();
                }
            } else {
                str = jsonReader.y();
            }
        }
        return new g6.k(str, arrayList, z10);
    }
}
