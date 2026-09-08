package j6;

import android.graphics.PointF;
import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;
import f6.C1018e;
import java.util.ArrayList;
import m6.C1337c;

/* compiled from: AnimatablePathValueParser.java */
/* renamed from: j6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1173a {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33906a = JsonReader.a.a("k", "x", "y");

    public static C1018e a(JsonReader jsonReader, C0820a c0820a) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            while (jsonReader.l()) {
                arrayList.add(z.a(jsonReader, c0820a));
            }
            jsonReader.f();
            v.b(arrayList);
        } else {
            arrayList.add(new C1337c(t.e(jsonReader, l6.h.e())));
        }
        return new C1018e(arrayList);
    }

    public static f6.m<PointF, PointF> b(JsonReader jsonReader, C0820a c0820a) {
        jsonReader.e();
        C1018e c1018e = null;
        C1015b c1015b = null;
        boolean z10 = false;
        C1015b c1015b2 = null;
        while (jsonReader.G() != JsonReader.Token.END_OBJECT) {
            int L10 = jsonReader.L(f33906a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        jsonReader.O();
                        jsonReader.S();
                    } else if (jsonReader.G() == JsonReader.Token.STRING) {
                        jsonReader.S();
                        z10 = true;
                    } else {
                        c1015b = C1176d.e(jsonReader, c0820a);
                    }
                } else if (jsonReader.G() == JsonReader.Token.STRING) {
                    jsonReader.S();
                    z10 = true;
                } else {
                    c1015b2 = C1176d.e(jsonReader, c0820a);
                }
            } else {
                c1018e = a(jsonReader, c0820a);
            }
        }
        jsonReader.g();
        if (z10) {
            c0820a.a("EffectiveAnimation doesn't support expressions.");
        }
        if (c1018e != null) {
            return c1018e;
        }
        return new f6.i(c1015b2, c1015b);
    }
}
