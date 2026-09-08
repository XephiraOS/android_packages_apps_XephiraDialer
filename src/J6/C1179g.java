package j6;

import android.graphics.Color;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: ColorParser.java */
/* renamed from: j6.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1179g implements N<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1179g f33914a = new C1179g();

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f10) {
        boolean z10;
        double d10;
        if (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.c();
        }
        double r10 = jsonReader.r();
        double r11 = jsonReader.r();
        double r12 = jsonReader.r();
        if (jsonReader.G() == JsonReader.Token.NUMBER) {
            d10 = jsonReader.r();
        } else {
            d10 = 1.0d;
        }
        if (z10) {
            jsonReader.f();
        }
        if (r10 <= 1.0d && r11 <= 1.0d && r12 <= 1.0d) {
            r10 *= 255.0d;
            r11 *= 255.0d;
            r12 *= 255.0d;
            if (d10 <= 1.0d) {
                d10 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d10, (int) r10, (int) r11, (int) r12));
    }
}
