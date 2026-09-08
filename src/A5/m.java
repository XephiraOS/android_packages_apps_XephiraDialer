package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import java.util.Map;

/* compiled from: UPCAReader.java */
/* loaded from: classes3.dex */
public final class m extends q {

    /* renamed from: i, reason: collision with root package name */
    public final q f6428i = new e();

    public static P4.f r(P4.f fVar) {
        String f10 = fVar.f();
        if (f10.charAt(0) == '0') {
            P4.f fVar2 = new P4.f(f10.substring(1), null, fVar.e(), BarcodeFormat.UPC_A);
            if (fVar.d() != null) {
                fVar2.g(fVar.d());
            }
            return fVar2;
        }
        throw FormatException.a();
    }

    @Override // a5.k, P4.e
    public P4.f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        return r(this.f6428i.a(bVar, map));
    }

    @Override // a5.q, a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        return r(this.f6428i.b(i10, aVar, map));
    }

    @Override // a5.q
    public int k(S4.a aVar, int[] iArr, StringBuilder sb) {
        return this.f6428i.k(aVar, iArr, sb);
    }

    @Override // a5.q
    public P4.f l(int i10, S4.a aVar, int[] iArr, Map<DecodeHintType, ?> map) {
        return r(this.f6428i.l(i10, aVar, iArr, map));
    }

    @Override // a5.q
    public BarcodeFormat p() {
        return BarcodeFormat.UPC_A;
    }
}
