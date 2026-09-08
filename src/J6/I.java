package j6;

import android.graphics.Path;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1014a;
import f6.C1017d;
import java.util.Collections;
import m6.C1337c;

/* compiled from: ShapeFillParser.java */
/* loaded from: classes3.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33900a = JsonReader.a.a("nm", "c", com.android.contacts.util.o.f17586f, "fillEnabled", "r", "hd");

    public static g6.j a(JsonReader jsonReader, C0820a c0820a) {
        Path.FillType fillType;
        C1017d c1017d = null;
        String str = null;
        C1014a c1014a = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 1;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33900a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            if (L10 != 4) {
                                if (L10 != 5) {
                                    jsonReader.O();
                                    jsonReader.S();
                                } else {
                                    z11 = jsonReader.o();
                                }
                            } else {
                                i10 = jsonReader.s();
                            }
                        } else {
                            z10 = jsonReader.o();
                        }
                    } else {
                        c1017d = C1176d.h(jsonReader, c0820a);
                    }
                } else {
                    c1014a = C1176d.c(jsonReader, c0820a);
                }
            } else {
                str = jsonReader.y();
            }
        }
        if (c1017d == null) {
            c1017d = new C1017d(Collections.singletonList(new C1337c(100)));
        }
        C1017d c1017d2 = c1017d;
        if (i10 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new g6.j(str, z10, fillType, c1014a, c1017d2, z11);
    }
}
