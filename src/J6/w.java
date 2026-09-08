package j6;

import android.graphics.Color;
import android.graphics.Rect;
import com.oplus.anim.C0820a;
import com.oplus.anim.model.layer.Layer;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1015b;
import g6.C1048a;
import java.util.ArrayList;
import java.util.Collections;
import m6.C1337c;

/* compiled from: LayerParser.java */
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33952a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33953b = JsonReader.a.a(com.android.contacts.list.d.f16900U, "a");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.a f33954c = JsonReader.a.a("ty", "nm");

    /* compiled from: LayerParser.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33955a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f33955a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33955a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(C0820a c0820a) {
        Rect b10 = c0820a.b();
        return new Layer(Collections.emptyList(), c0820a, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new f6.l(), 0, 0, 0, 0.0f, 0.0f, b10.width(), b10.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }

    public static Layer b(JsonReader jsonReader, C0820a c0820a) {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f10;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.e();
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        f6.l lVar = null;
        f6.j jVar = null;
        f6.k kVar = null;
        C1015b c1015b = null;
        C1048a c1048a = null;
        C1182j c1182j = null;
        long j10 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        long j11 = -1;
        float f15 = 1.0f;
        String str2 = "UNSET";
        String str3 = null;
        float f16 = 0.0f;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33952a)) {
                case 0:
                    str2 = jsonReader.y();
                    break;
                case 1:
                    j10 = jsonReader.s();
                    break;
                case 2:
                    str = jsonReader.y();
                    break;
                case 3:
                    int s10 = jsonReader.s();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (s10 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[s10];
                        break;
                    }
                case 4:
                    j11 = jsonReader.s();
                    break;
                case 5:
                    i10 = (int) (jsonReader.s() * l6.h.e());
                    break;
                case 6:
                    i11 = (int) (jsonReader.s() * l6.h.e());
                    break;
                case 7:
                    i12 = Color.parseColor(jsonReader.y());
                    break;
                case 8:
                    lVar = C1175c.g(jsonReader, c0820a);
                    break;
                case 9:
                    int s11 = jsonReader.s();
                    if (s11 >= Layer.MatteType.values().length) {
                        c0820a.a("Unsupported matte type: " + s11);
                        break;
                    } else {
                        matteType2 = Layer.MatteType.values()[s11];
                        int i13 = a.f33955a[matteType2.ordinal()];
                        if (i13 != 1) {
                            if (i13 == 2) {
                                c0820a.a("Unsupported matte type: Luma Inverted");
                            }
                        } else {
                            c0820a.a("Unsupported matte type: Luma");
                        }
                        c0820a.r(1);
                        break;
                    }
                case 10:
                    jsonReader.c();
                    while (jsonReader.l()) {
                        arrayList3.add(x.a(jsonReader, c0820a));
                    }
                    c0820a.r(arrayList3.size());
                    jsonReader.f();
                    break;
                case 11:
                    jsonReader.c();
                    while (jsonReader.l()) {
                        g6.c a10 = C1180h.a(jsonReader, c0820a);
                        if (a10 != null) {
                            arrayList4.add(a10);
                        }
                    }
                    jsonReader.f();
                    break;
                case 12:
                    jsonReader.e();
                    while (jsonReader.l()) {
                        int L10 = jsonReader.L(f33953b);
                        if (L10 != 0) {
                            if (L10 != 1) {
                                jsonReader.O();
                                jsonReader.S();
                            } else {
                                jsonReader.c();
                                if (jsonReader.l()) {
                                    kVar = C1174b.a(jsonReader, c0820a);
                                }
                                while (jsonReader.l()) {
                                    jsonReader.S();
                                }
                                jsonReader.f();
                            }
                        } else {
                            jVar = C1176d.d(jsonReader, c0820a);
                        }
                    }
                    jsonReader.g();
                    break;
                case 13:
                    jsonReader.c();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.l()) {
                        jsonReader.e();
                        while (jsonReader.l()) {
                            int L11 = jsonReader.L(f33954c);
                            if (L11 != 0) {
                                if (L11 != 1) {
                                    jsonReader.O();
                                    jsonReader.S();
                                } else {
                                    arrayList5.add(jsonReader.y());
                                }
                            } else {
                                int s12 = jsonReader.s();
                                if (s12 == 29) {
                                    c1048a = C1177e.b(jsonReader, c0820a);
                                } else if (s12 == 25) {
                                    c1182j = new C1183k().b(jsonReader, c0820a);
                                }
                            }
                        }
                        jsonReader.g();
                    }
                    jsonReader.f();
                    c0820a.a("Effective doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f15 = (float) jsonReader.r();
                    break;
                case 15:
                    f11 = (float) jsonReader.r();
                    break;
                case 16:
                    f12 = (float) (jsonReader.r() * l6.h.e());
                    break;
                case 17:
                    f13 = (float) (jsonReader.r() * l6.h.e());
                    break;
                case 18:
                    f16 = (float) jsonReader.r();
                    break;
                case 19:
                    f14 = (float) jsonReader.r();
                    break;
                case 20:
                    c1015b = C1176d.f(jsonReader, c0820a, false);
                    break;
                case 21:
                    str3 = jsonReader.y();
                    break;
                case 22:
                    z10 = jsonReader.o();
                    break;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    break;
            }
        }
        jsonReader.g();
        ArrayList arrayList6 = new ArrayList();
        if (f16 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new C1337c(c0820a, valueOf, valueOf, null, 0.0f, Float.valueOf(f16)));
            f10 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f10 = 0.0f;
        }
        if (f14 <= f10) {
            f14 = c0820a.f();
        }
        arrayList2.add(new C1337c(c0820a, valueOf2, valueOf2, null, f16, Float.valueOf(f14)));
        arrayList2.add(new C1337c(c0820a, valueOf, valueOf, null, f14, Float.valueOf(Float.MAX_VALUE)));
        if (l6.h.m(str2, ".ai") || "ai".equals(str3)) {
            c0820a.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, c0820a, str2, j10, layerType, j11, str, arrayList, lVar, i10, i11, i12, f15, f11, f12, f13, jVar, kVar, arrayList2, matteType2, c1015b, z10, c1048a, c1182j);
    }
}
