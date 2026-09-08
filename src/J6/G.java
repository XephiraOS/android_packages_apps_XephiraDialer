package j6;

import com.oplus.anim.parser.moshi.JsonReader;
import m6.C1338d;

/* compiled from: ScaleXYParser.java */
/* loaded from: classes3.dex */
public class G implements N<C1338d> {

    /* renamed from: a, reason: collision with root package name */
    public static final G f33897a = new G();

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1338d a(JsonReader jsonReader, float f10) {
        boolean z10;
        if (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.c();
        }
        float r10 = (float) jsonReader.r();
        float r11 = (float) jsonReader.r();
        while (jsonReader.l()) {
            jsonReader.S();
        }
        if (z10) {
            jsonReader.f();
        }
        return new C1338d((r10 / 100.0f) * f10, (r11 / 100.0f) * f10);
    }
}
