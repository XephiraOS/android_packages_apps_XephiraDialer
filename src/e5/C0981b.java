package e5;

import P4.e;
import P4.f;
import P4.g;
import S4.d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import f5.i;
import h5.C1080a;
import h5.C1081b;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: PDF417Reader.java */
/* renamed from: e5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0981b implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final f[] f31617a = new f[0];

    public static f[] b(P4.b bVar, Map<DecodeHintType, ?> map, boolean z10) {
        ArrayList arrayList = new ArrayList();
        C1081b b10 = C1080a.b(bVar, map, z10);
        for (g[] gVarArr : b10.b()) {
            d i10 = i.i(b10.a(), gVarArr[4], gVarArr[5], gVarArr[6], gVarArr[7], e(gVarArr), c(gVarArr));
            f fVar = new f(i10.h(), i10.e(), gVarArr, BarcodeFormat.PDF_417);
            fVar.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, i10.b());
            c cVar = (c) i10.d();
            if (cVar != null) {
                fVar.h(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            arrayList.add(fVar);
        }
        return (f[]) arrayList.toArray(f31617a);
    }

    public static int c(g[] gVarArr) {
        return Math.max(Math.max(d(gVarArr[0], gVarArr[4]), (d(gVarArr[6], gVarArr[2]) * 17) / 18), Math.max(d(gVarArr[1], gVarArr[5]), (d(gVarArr[7], gVarArr[3]) * 17) / 18));
    }

    public static int d(g gVar, g gVar2) {
        if (gVar != null && gVar2 != null) {
            return (int) Math.abs(gVar.c() - gVar2.c());
        }
        return 0;
    }

    public static int e(g[] gVarArr) {
        return Math.min(Math.min(f(gVarArr[0], gVarArr[4]), (f(gVarArr[6], gVarArr[2]) * 17) / 18), Math.min(f(gVarArr[1], gVarArr[5]), (f(gVarArr[7], gVarArr[3]) * 17) / 18));
    }

    public static int f(g gVar, g gVar2) {
        if (gVar != null && gVar2 != null) {
            return (int) Math.abs(gVar.c() - gVar2.c());
        }
        return Integer.MAX_VALUE;
    }

    @Override // P4.e
    public f a(P4.b bVar, Map<DecodeHintType, ?> map) {
        f fVar;
        f[] b10 = b(bVar, map, false);
        if (b10.length != 0 && (fVar = b10[0]) != null) {
            return fVar;
        }
        throw NotFoundException.a();
    }

    @Override // P4.e
    public void reset() {
    }
}
