package j6;

import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: IntegerParser.java */
/* loaded from: classes3.dex */
public class s implements N<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final s f33944a = new s();

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f10) {
        return Integer.valueOf(Math.round(t.g(jsonReader) * f10));
    }
}
