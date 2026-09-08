package P4;

import a5.i;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import e5.C0981b;
import i5.C1100a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader.java */
/* loaded from: classes3.dex */
public final class d implements e {

    /* renamed from: c, reason: collision with root package name */
    public static final e[] f2946c = new e[0];

    /* renamed from: a, reason: collision with root package name */
    public Map<DecodeHintType, ?> f2947a;

    /* renamed from: b, reason: collision with root package name */
    public e[] f2948b;

    @Override // P4.e
    public f a(b bVar, Map<DecodeHintType, ?> map) {
        d(map);
        return b(bVar);
    }

    public final f b(b bVar) {
        e[] eVarArr = this.f2948b;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                try {
                    return eVar.a(bVar, this.f2947a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.a();
    }

    public f c(b bVar) {
        if (this.f2948b == null) {
            d(null);
        }
        return b(bVar);
    }

    public void d(Map<DecodeHintType, ?> map) {
        boolean z10;
        Collection collection;
        this.f2947a = map;
        boolean z11 = false;
        if (map != null && map.containsKey(DecodeHintType.TRY_HARDER)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z11 = true;
            }
            if (z11 && !z10) {
                arrayList.add(new i(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new C1100a());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new V4.a());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new Q4.b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new C0981b());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new Y4.a());
            }
            if (z11 && z10) {
                arrayList.add(new i(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z10) {
                arrayList.add(new i(map));
            }
            arrayList.add(new C1100a());
            arrayList.add(new V4.a());
            arrayList.add(new Q4.b());
            arrayList.add(new C0981b());
            arrayList.add(new Y4.a());
            if (z10) {
                arrayList.add(new i(map));
            }
        }
        this.f2948b = (e[]) arrayList.toArray(f2946c);
    }

    @Override // P4.e
    public void reset() {
        e[] eVarArr = this.f2948b;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                eVar.reset();
            }
        }
    }
}
