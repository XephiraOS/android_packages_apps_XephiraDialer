package j6;

import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: FloatParser.java */
/* renamed from: j6.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1185m implements N<Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1185m f33934a = new C1185m();

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float a(JsonReader jsonReader, float f10) {
        return Float.valueOf(t.g(jsonReader) * f10);
    }
}
