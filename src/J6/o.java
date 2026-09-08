package j6;

import com.oplus.anim.parser.moshi.JsonReader;
import e6.C0984c;

/* compiled from: FontParser.java */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33937a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static C0984c a(JsonReader jsonReader) {
        jsonReader.e();
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        String str3 = null;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33937a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            jsonReader.O();
                            jsonReader.S();
                        } else {
                            f10 = (float) jsonReader.r();
                        }
                    } else {
                        str2 = jsonReader.y();
                    }
                } else {
                    str3 = jsonReader.y();
                }
            } else {
                str = jsonReader.y();
            }
        }
        jsonReader.g();
        return new C0984c(str, str3, str2, f10);
    }
}
