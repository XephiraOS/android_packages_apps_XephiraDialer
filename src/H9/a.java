package H9;

import G9.l;
import G9.p;
import com.heytap.accessory.constant.FastPairConstants;
import kotlin.jvm.internal.i;

/* compiled from: Buffer.kt */
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final byte[] f1293a = p.a("0123456789abcdef");

    public static final boolean a(l segment, int i10, byte[] bytes, int i11, int i12) {
        i.f(segment, "segment");
        i.f(bytes, "bytes");
        int i13 = segment.f1155c;
        byte[] bArr = segment.f1153a;
        while (i11 < i12) {
            if (i10 == i13) {
                segment = segment.f1158f;
                i.c(segment);
                byte[] bArr2 = segment.f1153a;
                bArr = bArr2;
                i10 = segment.f1154b;
                i13 = segment.f1155c;
            }
            if (bArr[i10] != bytes[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final int b(G9.b bVar, G9.i options, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        l lVar;
        int i12;
        int i13;
        i.f(bVar, "<this>");
        i.f(options, "options");
        l lVar2 = bVar.f1127a;
        if (lVar2 == null) {
            if (z10) {
                return -2;
            }
            return -1;
        }
        byte[] bArr = lVar2.f1153a;
        int i14 = lVar2.f1154b;
        int i15 = lVar2.f1155c;
        int[] h10 = options.h();
        l lVar3 = lVar2;
        int i16 = -1;
        int i17 = 0;
        loop0: while (true) {
            int i18 = i17 + 1;
            int i19 = h10[i17];
            int i20 = i17 + 2;
            int i21 = h10[i18];
            if (i21 != -1) {
                i16 = i21;
            }
            if (lVar3 == null) {
                break;
            }
            if (i19 < 0) {
                int i22 = i20 + (i19 * (-1));
                while (true) {
                    int i23 = i14 + 1;
                    int i24 = i20 + 1;
                    if ((bArr[i14] & FastPairConstants.GO_INTENT_NOT_SET) != h10[i20]) {
                        return i16;
                    }
                    if (i24 == i22) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (i23 == i15) {
                        i.c(lVar3);
                        l lVar4 = lVar3.f1158f;
                        i.c(lVar4);
                        i13 = lVar4.f1154b;
                        byte[] bArr2 = lVar4.f1153a;
                        i12 = lVar4.f1155c;
                        if (lVar4 == lVar2) {
                            if (!z11) {
                                break loop0;
                            }
                            bArr = bArr2;
                            lVar = null;
                        } else {
                            lVar = lVar4;
                            bArr = bArr2;
                        }
                    } else {
                        lVar = lVar3;
                        i12 = i15;
                        i13 = i23;
                    }
                    if (z11) {
                        i11 = h10[i24];
                        i10 = i13;
                        i15 = i12;
                        lVar3 = lVar;
                        break;
                    }
                    i14 = i13;
                    i15 = i12;
                    lVar3 = lVar;
                    i20 = i24;
                }
            } else {
                i10 = i14 + 1;
                int i25 = bArr[i14] & FastPairConstants.GO_INTENT_NOT_SET;
                int i26 = i20 + i19;
                while (i20 != i26) {
                    if (i25 == h10[i20]) {
                        i11 = h10[i20 + i19];
                        if (i10 == i15) {
                            lVar3 = lVar3.f1158f;
                            i.c(lVar3);
                            i10 = lVar3.f1154b;
                            bArr = lVar3.f1153a;
                            i15 = lVar3.f1155c;
                            if (lVar3 == lVar2) {
                                lVar3 = null;
                            }
                        }
                    } else {
                        i20++;
                    }
                }
                return i16;
            }
            if (i11 >= 0) {
                return i11;
            }
            i17 = -i11;
            i14 = i10;
        }
        if (z10) {
            return -2;
        }
        return i16;
    }

    public static /* synthetic */ int c(G9.b bVar, G9.i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return b(bVar, iVar, z10);
    }
}
