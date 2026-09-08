package j6;

import android.graphics.PointF;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: PointFParser.java */
/* renamed from: j6.B, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1169B implements N<PointF> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1169B f33892a = new C1169B();

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f10) {
        JsonReader.Token G10 = jsonReader.G();
        if (G10 == JsonReader.Token.BEGIN_ARRAY) {
            return t.e(jsonReader, f10);
        }
        if (G10 == JsonReader.Token.BEGIN_OBJECT) {
            return t.e(jsonReader, f10);
        }
        if (G10 == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.r()) * f10, ((float) jsonReader.r()) * f10);
            while (jsonReader.l()) {
                jsonReader.S();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + G10);
    }
}
