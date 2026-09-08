package a5;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension2Support.java */
/* loaded from: classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f6429a = new int[4];

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f6430b = new StringBuilder();

    public static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    public final int a(S4.a aVar, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f6429a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int k10 = aVar.k();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 2 && i10 < k10; i12++) {
            int i13 = q.i(aVar, iArr2, i10, q.f6441h);
            sb.append((char) ((i13 % 10) + 48));
            for (int i14 : iArr2) {
                i10 += i14;
            }
            if (i13 >= 10) {
                i11 |= 1 << (1 - i12);
            }
            if (i12 != 1) {
                i10 = aVar.j(aVar.i(i10));
            }
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i11) {
                return i10;
            }
            throw NotFoundException.a();
        }
        throw NotFoundException.a();
    }

    public P4.f b(int i10, S4.a aVar, int[] iArr) {
        StringBuilder sb = this.f6430b;
        sb.setLength(0);
        int a10 = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> c10 = c(sb2);
        float f10 = i10;
        P4.f fVar = new P4.f(sb2, null, new P4.g[]{new P4.g((iArr[0] + iArr[1]) / 2.0f, f10), new P4.g(a10, f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c10 != null) {
            fVar.g(c10);
        }
        return fVar;
    }
}
