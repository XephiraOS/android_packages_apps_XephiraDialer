package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: PathKeyframeParser.java */
/* loaded from: classes3.dex */
public class z {
    public static c6.i a(JsonReader jsonReader, C0820a c0820a) {
        boolean z10;
        if (jsonReader.G() == JsonReader.Token.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new c6.i(c0820a, u.c(jsonReader, c0820a, l6.h.e(), C1168A.f33891a, z10, false));
    }
}
