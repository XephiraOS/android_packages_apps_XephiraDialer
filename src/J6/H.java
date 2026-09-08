package j6;

import android.graphics.PointF;
import com.oplus.anim.parser.moshi.JsonReader;
import e6.C0982a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ShapeDataParser.java */
/* loaded from: classes3.dex */
public class H implements N<g6.i> {

    /* renamed from: a, reason: collision with root package name */
    public static final H f33898a = new H();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33899b = JsonReader.a.a("c", s1.v.f36673e, "i", com.android.contacts.util.o.f17586f);

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g6.i a(JsonReader jsonReader, float f10) {
        if (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
        }
        jsonReader.e();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z10 = false;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33899b);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            jsonReader.O();
                            jsonReader.S();
                        } else {
                            list3 = t.f(jsonReader, f10);
                        }
                    } else {
                        list2 = t.f(jsonReader, f10);
                    }
                } else {
                    list = t.f(jsonReader, f10);
                }
            } else {
                z10 = jsonReader.o();
            }
        }
        jsonReader.g();
        if (jsonReader.G() == JsonReader.Token.END_ARRAY) {
            jsonReader.f();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new g6.i(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new C0982a(l6.g.a(list.get(i11), list3.get(i11)), l6.g.a(pointF2, list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = list.get(0);
                int i12 = size - 1;
                arrayList.add(new C0982a(l6.g.a(list.get(i12), list3.get(i12)), l6.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new g6.i(pointF, z10, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
