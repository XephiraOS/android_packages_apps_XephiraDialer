package j6;

import android.graphics.Rect;
import com.oplus.anim.C0820a;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.parser.moshi.JsonReader;
import e6.C0984c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p.C1420f;

/* compiled from: EffectiveCompositionParser.java */
/* renamed from: j6.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1184l {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33930a = JsonReader.a.a("w", "h", "ip", "op", "fr", s1.v.f36673e, "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    public static JsonReader.a f33931b = JsonReader.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f33932c = JsonReader.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    public static final JsonReader.a f33933d = JsonReader.a.a("cm", "tm", "dr");

    public static C0820a a(JsonReader jsonReader) {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e10 = l6.h.e();
        C1420f<Layer> c1420f = new C1420f<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        p.j<e6.d> jVar = new p.j<>();
        C0820a c0820a = new C0820a();
        jsonReader.e();
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        while (jsonReader.l()) {
            switch (jsonReader2.L(f33930a)) {
                case 0:
                    i10 = jsonReader.s();
                    continue;
                case 1:
                    i11 = jsonReader.s();
                    continue;
                case 2:
                    f10 = (float) jsonReader.r();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) jsonReader.r()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) jsonReader.r();
                    break;
                case 5:
                    String[] split = jsonReader.y().split("\\.");
                    if (l6.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        c0820a.a("EffectiveAnimation only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(jsonReader2, c0820a, arrayList2, c1420f);
                    continue;
                case 7:
                    b(jsonReader2, c0820a, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(jsonReader2, hashMap4);
                    continue;
                case 9:
                    c(jsonReader2, c0820a, jVar);
                    continue;
                case 10:
                    f(jsonReader2, arrayList3);
                    continue;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        c0820a.s(new Rect(0, 0, (int) (i10 * e10), (int) (i11 * e10)), f10, f11, f12, arrayList2, c1420f, hashMap2, hashMap3, jVar, hashMap4, arrayList3);
        return c0820a;
    }

    public static void b(JsonReader jsonReader, C0820a c0820a, Map<String, List<Layer>> map, Map<String, com.oplus.anim.I> map2) {
        jsonReader.c();
        while (jsonReader.l()) {
            ArrayList arrayList = new ArrayList();
            C1420f c1420f = new C1420f();
            jsonReader.e();
            int i10 = 0;
            int i11 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (jsonReader.l()) {
                int L10 = jsonReader.L(f33931b);
                if (L10 != 0) {
                    if (L10 != 1) {
                        if (L10 != 2) {
                            if (L10 != 3) {
                                if (L10 != 4) {
                                    if (L10 != 5) {
                                        jsonReader.O();
                                        jsonReader.S();
                                    } else {
                                        str3 = jsonReader.y();
                                    }
                                } else {
                                    str2 = jsonReader.y();
                                }
                            } else {
                                i11 = jsonReader.s();
                            }
                        } else {
                            i10 = jsonReader.s();
                        }
                    } else {
                        jsonReader.c();
                        while (jsonReader.l()) {
                            Layer b10 = w.b(jsonReader, c0820a);
                            c1420f.h(b10.d(), b10);
                            arrayList.add(b10);
                        }
                        jsonReader.f();
                    }
                } else {
                    str = jsonReader.y();
                }
            }
            jsonReader.g();
            if (str2 != null) {
                com.oplus.anim.I i12 = new com.oplus.anim.I(i10, i11, str, str2, str3);
                map2.put(i12.d(), i12);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.f();
    }

    public static void c(JsonReader jsonReader, C0820a c0820a, p.j<e6.d> jVar) {
        jsonReader.c();
        while (jsonReader.l()) {
            e6.d a10 = C1186n.a(jsonReader, c0820a);
            jVar.g(a10.hashCode(), a10);
        }
        jsonReader.f();
    }

    public static void d(JsonReader jsonReader, Map<String, C0984c> map) {
        jsonReader.e();
        while (jsonReader.l()) {
            if (jsonReader.L(f33932c) != 0) {
                jsonReader.O();
                jsonReader.S();
            } else {
                jsonReader.c();
                while (jsonReader.l()) {
                    C0984c a10 = o.a(jsonReader);
                    map.put(a10.b(), a10);
                }
                jsonReader.f();
            }
        }
        jsonReader.g();
    }

    public static void e(JsonReader jsonReader, C0820a c0820a, List<Layer> list, C1420f<Layer> c1420f) {
        jsonReader.c();
        int i10 = 0;
        while (jsonReader.l()) {
            Layer b10 = w.b(jsonReader, c0820a);
            if (b10.f() == Layer.LayerType.IMAGE) {
                i10++;
            }
            list.add(b10);
            c1420f.h(b10.d(), b10);
            if (i10 > 4) {
                l6.e.c("You have " + i10 + " images. EffectiveAnimation should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.f();
    }

    public static void f(JsonReader jsonReader, List<e6.g> list) {
        jsonReader.c();
        while (jsonReader.l()) {
            jsonReader.e();
            float f10 = 0.0f;
            String str = null;
            float f11 = 0.0f;
            while (jsonReader.l()) {
                int L10 = jsonReader.L(f33933d);
                if (L10 != 0) {
                    if (L10 != 1) {
                        if (L10 != 2) {
                            jsonReader.O();
                            jsonReader.S();
                        } else {
                            f11 = (float) jsonReader.r();
                        }
                    } else {
                        f10 = (float) jsonReader.r();
                    }
                } else {
                    str = jsonReader.y();
                }
            }
            jsonReader.g();
            list.add(new e6.g(str, f10, f11));
        }
        jsonReader.f();
    }
}
