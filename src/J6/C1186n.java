package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import java.util.ArrayList;

/* compiled from: FontCharacterParser.java */
/* renamed from: j6.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1186n {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33935a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33936b = JsonReader.a.a("shapes");

    public static e6.d a(JsonReader jsonReader, C0820a c0820a) {
        ArrayList arrayList = new ArrayList();
        jsonReader.e();
        double d10 = 0.0d;
        String str = null;
        String str2 = null;
        char c10 = 0;
        double d11 = 0.0d;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33935a);
            if (L10 != 0) {
                if (L10 != 1) {
                    if (L10 != 2) {
                        if (L10 != 3) {
                            if (L10 != 4) {
                                if (L10 != 5) {
                                    jsonReader.O();
                                    jsonReader.S();
                                } else {
                                    jsonReader.e();
                                    while (jsonReader.l()) {
                                        if (jsonReader.L(f33936b) != 0) {
                                            jsonReader.O();
                                            jsonReader.S();
                                        } else {
                                            jsonReader.c();
                                            while (jsonReader.l()) {
                                                arrayList.add((g6.k) C1180h.a(jsonReader, c0820a));
                                            }
                                            jsonReader.f();
                                        }
                                    }
                                    jsonReader.g();
                                }
                            } else {
                                str2 = jsonReader.y();
                            }
                        } else {
                            str = jsonReader.y();
                        }
                    } else {
                        d10 = jsonReader.r();
                    }
                } else {
                    d11 = jsonReader.r();
                }
            } else {
                c10 = jsonReader.y().charAt(0);
            }
        }
        jsonReader.g();
        return new e6.d(arrayList, c10, d11, d10, str, str2);
    }
}
