package j6;

import android.graphics.PointF;
import com.oplus.anim.model.DocumentData;
import com.oplus.anim.parser.moshi.JsonReader;

/* compiled from: DocumentDataParser.java */
/* renamed from: j6.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1181i implements N<DocumentData> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1181i f33916a = new C1181i();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.a f33917b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // j6.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public DocumentData a(JsonReader jsonReader, float f10) {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.e();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = true;
        while (jsonReader.l()) {
            switch (jsonReader.L(f33917b)) {
                case 0:
                    str = jsonReader.y();
                    break;
                case 1:
                    str2 = jsonReader.y();
                    break;
                case 2:
                    f11 = (float) jsonReader.r();
                    break;
                case 3:
                    int s10 = jsonReader.s();
                    justification2 = DocumentData.Justification.CENTER;
                    if (s10 <= justification2.ordinal() && s10 >= 0) {
                        justification2 = DocumentData.Justification.values()[s10];
                        break;
                    }
                    break;
                case 4:
                    i10 = jsonReader.s();
                    break;
                case 5:
                    f12 = (float) jsonReader.r();
                    break;
                case 6:
                    f13 = (float) jsonReader.r();
                    break;
                case 7:
                    i11 = t.d(jsonReader);
                    break;
                case 8:
                    i12 = t.d(jsonReader);
                    break;
                case 9:
                    f14 = (float) jsonReader.r();
                    break;
                case 10:
                    z10 = jsonReader.o();
                    break;
                case 11:
                    jsonReader.c();
                    PointF pointF3 = new PointF(((float) jsonReader.r()) * f10, ((float) jsonReader.r()) * f10);
                    jsonReader.f();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.c();
                    PointF pointF4 = new PointF(((float) jsonReader.r()) * f10, ((float) jsonReader.r()) * f10);
                    jsonReader.f();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.O();
                    jsonReader.S();
                    break;
            }
        }
        jsonReader.g();
        return new DocumentData(str, str2, f11, justification2, i10, f12, f13, i11, i12, f14, z10, pointF, pointF2);
    }
}
