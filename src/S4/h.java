package S4;

/* compiled from: GridSampler.java */
/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static h f3508a = new e();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(S4.b r10, float[] r11) {
        /*
            int r0 = r10.j()
            int r10 = r10.g()
            int r1 = r11.length
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r5 = r2
            r4 = r3
        Le:
            r6 = 0
            r7 = -1
            if (r4 >= r1) goto L49
            if (r5 == 0) goto L49
            r5 = r11[r4]
            int r5 = (int) r5
            int r8 = r4 + 1
            r9 = r11[r8]
            int r9 = (int) r9
            if (r5 < r7) goto L44
            if (r5 > r0) goto L44
            if (r9 < r7) goto L44
            if (r9 > r10) goto L44
            if (r5 != r7) goto L2a
            r11[r4] = r6
        L28:
            r5 = r2
            goto L33
        L2a:
            if (r5 != r0) goto L32
            int r5 = r0 + (-1)
            float r5 = (float) r5
            r11[r4] = r5
            goto L28
        L32:
            r5 = r3
        L33:
            if (r9 != r7) goto L39
            r11[r8] = r6
        L37:
            r5 = r2
            goto L41
        L39:
            if (r9 != r10) goto L41
            int r5 = r10 + (-1)
            float r5 = (float) r5
            r11[r8] = r5
            goto L37
        L41:
            int r4 = r4 + 2
            goto Le
        L44:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.a()
            throw r10
        L49:
            int r1 = r11.length
            int r1 = r1 + (-2)
            r4 = r2
        L4d:
            if (r1 < 0) goto L86
            if (r4 == 0) goto L86
            r4 = r11[r1]
            int r4 = (int) r4
            int r5 = r1 + 1
            r8 = r11[r5]
            int r8 = (int) r8
            if (r4 < r7) goto L81
            if (r4 > r0) goto L81
            if (r8 < r7) goto L81
            if (r8 > r10) goto L81
            if (r4 != r7) goto L67
            r11[r1] = r6
        L65:
            r4 = r2
            goto L70
        L67:
            if (r4 != r0) goto L6f
            int r4 = r0 + (-1)
            float r4 = (float) r4
            r11[r1] = r4
            goto L65
        L6f:
            r4 = r3
        L70:
            if (r8 != r7) goto L76
            r11[r5] = r6
        L74:
            r4 = r2
            goto L7e
        L76:
            if (r8 != r10) goto L7e
            int r4 = r10 + (-1)
            float r4 = (float) r4
            r11[r5] = r4
            goto L74
        L7e:
            int r1 = r1 + (-2)
            goto L4d
        L81:
            com.google.zxing.NotFoundException r10 = com.google.zxing.NotFoundException.a()
            throw r10
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S4.h.a(S4.b, float[]):void");
    }

    public static h b() {
        return f3508a;
    }

    public abstract b c(b bVar, int i10, int i11, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f20, float f21, float f22, float f23, float f24, float f25);

    public abstract b d(b bVar, int i10, int i11, j jVar);
}
