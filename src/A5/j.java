package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader.java */
/* loaded from: classes3.dex */
public final class j extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final q[] f6425b = new q[0];

    /* renamed from: a, reason: collision with root package name */
    public final q[] f6426a;

    public j(Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new e());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new m());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new r());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new e());
            arrayList.add(new f());
            arrayList.add(new r());
        }
        this.f6426a = (q[]) arrayList.toArray(f6425b);
    }

    @Override // a5.k
    public P4.f b(int i10, S4.a aVar, Map<DecodeHintType, ?> map) {
        boolean z10;
        Collection collection;
        boolean z11;
        int[] o10 = q.o(aVar);
        for (q qVar : this.f6426a) {
            try {
                P4.f l10 = qVar.l(i10, aVar, o10, map);
                if (l10.b() == BarcodeFormat.EAN_13 && l10.f().charAt(0) == '0') {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                }
                if (collection != null && !collection.contains(BarcodeFormat.UPC_A)) {
                    z11 = false;
                    if (!z10 && z11) {
                        P4.f fVar = new P4.f(l10.f().substring(1), l10.c(), l10.e(), BarcodeFormat.UPC_A);
                        fVar.g(l10.d());
                        return fVar;
                    }
                    return l10;
                }
                z11 = true;
                if (!z10) {
                }
                return l10;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.a();
    }

    @Override // a5.k, P4.e
    public void reset() {
        for (q qVar : this.f6426a) {
            qVar.reset();
        }
    }
}
