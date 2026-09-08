package a5;

import c5.C0557d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader.java */
/* loaded from: classes3.dex */
public final class i extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final k[] f6423b = new k[0];

    /* renamed from: a, reason: collision with root package name */
    public final k[] f6424a;

    public i(Map<DecodeHintType, ?> map) {
        Collection collection;
        boolean z10;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        if (map != null && map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new j(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new c(z10));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new d());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new b());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new C0422a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new b5.e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new C0557d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new j(map));
            arrayList.add(new c());
            arrayList.add(new C0422a());
            arrayList.add(new d());
            arrayList.add(new b());
            arrayList.add(new h());
            arrayList.add(new b5.e());
            arrayList.add(new C0557d());
        }
        this.f6424a = (k[]) arrayList.toArray(f6423b);
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        k[] kVarArr = this.f6424a;
        for (int i11 = 0; i11 < kVarArr.length; i11++) {
            try {
                return kVarArr[i11].b(i10, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // a5.k, P4.e
    public void reset() {
        for (k kVar : this.f6424a) {
            kVar.reset();
        }
    }
}
