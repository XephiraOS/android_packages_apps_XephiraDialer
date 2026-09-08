package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1014a;
import f6.C1015b;
import f6.C1016c;
import f6.C1017d;
import java.util.List;
import m6.C1337c;

/* compiled from: AnimatableValueParser.java */
/* renamed from: j6.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1176d {
    public static <T> List<C1337c<T>> a(JsonReader jsonReader, float f10, C0820a c0820a, N<T> n10) {
        return v.a(jsonReader, c0820a, f10, n10, false);
    }

    public static <T> List<C1337c<T>> b(JsonReader jsonReader, C0820a c0820a, N<T> n10) {
        return v.a(jsonReader, c0820a, 1.0f, n10, false);
    }

    public static C1014a c(JsonReader jsonReader, C0820a c0820a) {
        return new C1014a(b(jsonReader, c0820a, C1179g.f33914a));
    }

    public static f6.j d(JsonReader jsonReader, C0820a c0820a) {
        return new f6.j(a(jsonReader, l6.h.e(), c0820a, C1181i.f33916a));
    }

    public static C1015b e(JsonReader jsonReader, C0820a c0820a) {
        return f(jsonReader, c0820a, true);
    }

    public static C1015b f(JsonReader jsonReader, C0820a c0820a, boolean z10) {
        float f10;
        if (z10) {
            f10 = l6.h.e();
        } else {
            f10 = 1.0f;
        }
        return new C1015b(a(jsonReader, f10, c0820a, C1185m.f33934a));
    }

    public static C1016c g(JsonReader jsonReader, C0820a c0820a, int i10) {
        return new C1016c(b(jsonReader, c0820a, new p(i10)));
    }

    public static C1017d h(JsonReader jsonReader, C0820a c0820a) {
        return new C1017d(b(jsonReader, c0820a, s.f33944a));
    }

    public static f6.f i(JsonReader jsonReader, C0820a c0820a) {
        return new f6.f(v.a(jsonReader, c0820a, l6.h.e(), C1169B.f33892a, true));
    }

    public static f6.g j(JsonReader jsonReader, C0820a c0820a) {
        return new f6.g(b(jsonReader, c0820a, G.f33897a));
    }

    public static f6.h k(JsonReader jsonReader, C0820a c0820a) {
        return new f6.h(a(jsonReader, l6.h.e(), c0820a, H.f33898a));
    }
}
