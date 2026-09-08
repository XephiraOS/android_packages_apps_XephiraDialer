package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.model.content.ShapeTrimPath;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;

/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes3.dex */
public class M {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33905a = JsonReader.a.a("s", "e", com.android.contacts.util.o.f17586f, "nm", "m", "hd");

    public static ShapeTrimPath a(JsonReader jsonReader, C0820a c0820a) {
        String str = null;
        ShapeTrimPath.Type type = null;
        C1015b c1015b = null;
        C1015b c1015b2 = null;
        C1015b c1015b3 = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33905a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            if (L10 != 4) {
                                if (L10 != 5) {
                                    jsonReader.S();
                                } else {
                                    z10 = jsonReader.o();
                                }
                            } else {
                                type = ShapeTrimPath.Type.a(jsonReader.s());
                            }
                        } else {
                            str = jsonReader.y();
                        }
                    } else {
                        c1015b3 = C1176d.f(jsonReader, c0820a, false);
                    }
                } else {
                    c1015b2 = C1176d.f(jsonReader, c0820a, false);
                }
            } else {
                c1015b = C1176d.f(jsonReader, c0820a, false);
            }
        }
        return new ShapeTrimPath(str, type, c1015b, c1015b2, c1015b3, z10);
    }
}
