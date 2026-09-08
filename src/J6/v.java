package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.List;
import m6.C1337c;

/* compiled from: KeyframesParser.java */
/* loaded from: classes3.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static JsonReader.a f33951a = JsonReader.a.a("k");

    public static <T> List<C1337c<T>> a(JsonReader jsonReader, C0820a c0820a, float f10, N<T> n10, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.G() == JsonReader.Token.STRING) {
            c0820a.a("Effective doesn't support expressions.");
            return arrayList;
        }
        jsonReader.e();
        while (jsonReader.l()) {
            if (jsonReader.L(f33951a) != 0) {
                jsonReader.S();
            } else if (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.c();
                if (jsonReader.G() == JsonReader.Token.NUMBER) {
                    arrayList.add(u.c(jsonReader, c0820a, f10, n10, false, z10));
                } else {
                    while (jsonReader.l()) {
                        arrayList.add(u.c(jsonReader, c0820a, f10, n10, true, z10));
                    }
                }
                jsonReader.f();
            } else {
                arrayList.add(u.c(jsonReader, c0820a, f10, n10, false, z10));
            }
        }
        jsonReader.g();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends C1337c<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            C1337c<T> c1337c = list.get(i11);
            i11++;
            C1337c<T> c1337c2 = list.get(i11);
            c1337c.f35161h = Float.valueOf(c1337c2.f35160g);
            if (c1337c.f35156c == null && (t10 = c1337c2.f35155b) != null) {
                c1337c.f35156c = t10;
                if (c1337c instanceof c6.i) {
                    ((c6.i) c1337c).j();
                }
            }
        }
        C1337c<T> c1337c3 = list.get(i10);
        if ((c1337c3.f35155b == null || c1337c3.f35156c == null) && list.size() > 1) {
            list.remove(c1337c3);
        }
    }
}
