package Q4;

import P4.e;

/* compiled from: AztecReader.java */
/* loaded from: classes3.dex */
public final class b implements e {
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[LOOP:0: B:24:0x005c->B:25:0x005e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    @Override // P4.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public P4.f a(P4.b r10, java.util.Map<com.google.zxing.DecodeHintType, ?> r11) {
        /*
            r9 = this;
            R4.a r9 = new R4.a
            S4.b r10 = r10.a()
            r9.<init>(r10)
            r10 = 0
            r0 = 0
            Q4.a r1 = r9.a(r10)     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            P4.g[] r2 = r1.b()     // Catch: com.google.zxing.FormatException -> L25 com.google.zxing.NotFoundException -> L28
            com.google.zxing.aztec.decoder.Decoder r3 = new com.google.zxing.aztec.decoder.Decoder     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r3.<init>()     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            S4.d r1 = r3.c(r1)     // Catch: com.google.zxing.FormatException -> L21 com.google.zxing.NotFoundException -> L23
            r3 = r2
            r2 = r0
            r0 = r1
            r1 = r2
            goto L31
        L21:
            r1 = move-exception
            goto L2b
        L23:
            r1 = move-exception
            goto L2f
        L25:
            r1 = move-exception
            r2 = r0
            goto L2b
        L28:
            r1 = move-exception
            r2 = r0
            goto L2f
        L2b:
            r3 = r2
            r2 = r1
            r1 = r0
            goto L31
        L2f:
            r3 = r2
            r2 = r0
        L31:
            if (r0 != 0) goto L45
            r0 = 1
            Q4.a r9 = r9.a(r0)     // Catch: java.lang.Throwable -> L47
            P4.g[] r3 = r9.b()     // Catch: java.lang.Throwable -> L47
            com.google.zxing.aztec.decoder.Decoder r0 = new com.google.zxing.aztec.decoder.Decoder     // Catch: java.lang.Throwable -> L47
            r0.<init>()     // Catch: java.lang.Throwable -> L47
            S4.d r0 = r0.c(r9)     // Catch: java.lang.Throwable -> L47
        L45:
            r5 = r3
            goto L4f
        L47:
            r9 = move-exception
            if (r1 != 0) goto L4e
            if (r2 == 0) goto L4d
            throw r2
        L4d:
            throw r9
        L4e:
            throw r1
        L4f:
            if (r11 == 0) goto L66
            com.google.zxing.DecodeHintType r9 = com.google.zxing.DecodeHintType.NEED_RESULT_POINT_CALLBACK
            java.lang.Object r9 = r11.get(r9)
            P4.h r9 = (P4.h) r9
            if (r9 == 0) goto L66
            int r11 = r5.length
        L5c:
            if (r10 >= r11) goto L66
            r1 = r5[r10]
            r9.a(r1)
            int r10 = r10 + 1
            goto L5c
        L66:
            P4.f r9 = new P4.f
            java.lang.String r2 = r0.h()
            byte[] r3 = r0.e()
            int r4 = r0.c()
            com.google.zxing.BarcodeFormat r6 = com.google.zxing.BarcodeFormat.AZTEC
            long r7 = java.lang.System.currentTimeMillis()
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.util.List r10 = r0.a()
            if (r10 == 0) goto L89
            com.google.zxing.ResultMetadataType r11 = com.google.zxing.ResultMetadataType.BYTE_SEGMENTS
            r9.h(r11, r10)
        L89:
            java.lang.String r10 = r0.b()
            if (r10 == 0) goto L94
            com.google.zxing.ResultMetadataType r11 = com.google.zxing.ResultMetadataType.ERROR_CORRECTION_LEVEL
            r9.h(r11, r10)
        L94:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Q4.b.a(P4.b, java.util.Map):P4.f");
    }

    @Override // P4.e
    public void reset() {
    }
}
