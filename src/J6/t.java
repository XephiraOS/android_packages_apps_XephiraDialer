package j6;

import android.graphics.Color;
import android.graphics.PointF;
import com.oplus.anim.parser.moshi.JsonReader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: JsonUtils.java */
/* loaded from: classes3.dex */
public class t {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f33945a = JsonReader.a.a("x", "y");

    /* compiled from: JsonUtils.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f33946a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f33946a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33946a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33946a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f10) {
        jsonReader.c();
        float r10 = (float) jsonReader.r();
        float r11 = (float) jsonReader.r();
        while (jsonReader.G() != JsonReader.Token.END_ARRAY) {
            jsonReader.S();
        }
        jsonReader.f();
        return new PointF(r10 * f10, r11 * f10);
    }

    public static PointF b(JsonReader jsonReader, float f10) {
        float r10 = (float) jsonReader.r();
        float r11 = (float) jsonReader.r();
        while (jsonReader.l()) {
            jsonReader.S();
        }
        return new PointF(r10 * f10, r11 * f10);
    }

    public static PointF c(JsonReader jsonReader, float f10) {
        jsonReader.e();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (jsonReader.l()) {
            int L10 = jsonReader.L(f33945a);
            if (L10 != 0) {
                if (L10 != 1) {
                    jsonReader.O();
                    jsonReader.S();
                } else {
                    f12 = g(jsonReader);
                }
            } else {
                f11 = g(jsonReader);
            }
        }
        jsonReader.g();
        return new PointF(f11 * f10, f12 * f10);
    }

    public static int d(JsonReader jsonReader) {
        jsonReader.c();
        int r10 = (int) (jsonReader.r() * 255.0d);
        int r11 = (int) (jsonReader.r() * 255.0d);
        int r12 = (int) (jsonReader.r() * 255.0d);
        while (jsonReader.l()) {
            jsonReader.S();
        }
        jsonReader.f();
        return Color.argb(255, r10, r11, r12);
    }

    public static PointF e(JsonReader jsonReader, float f10) {
        int i10 = a.f33946a[jsonReader.G().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return c(jsonReader, f10);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.G());
            }
            return a(jsonReader, f10);
        }
        return b(jsonReader, f10);
    }

    public static List<PointF> f(JsonReader jsonReader, float f10) {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        while (jsonReader.G() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.c();
            arrayList.add(e(jsonReader, f10));
            jsonReader.f();
        }
        jsonReader.f();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) {
        JsonReader.Token G10 = jsonReader.G();
        int i10 = a.f33946a[G10.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                jsonReader.c();
                float r10 = (float) jsonReader.r();
                while (jsonReader.l()) {
                    jsonReader.S();
                }
                jsonReader.f();
                return r10;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + G10);
        }
        return (float) jsonReader.r();
    }
}
