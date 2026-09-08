package com.oplus.utils;

/* compiled from: NumberRecognitionUtils.kt */
/* loaded from: classes3.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final F f29041a = new F();

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0022 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:18:0x000e, B:20:0x0014, B:5:0x0022, B:6:0x0028), top: B:17:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean a(android.content.Context r7) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "network_switch"
            r2 = 0
            r0.putBoolean(r1, r2)
            r3 = 0
            if (r7 == 0) goto L1f
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L1d
            if (r7 == 0) goto L1f
            java.lang.String r4 = "com.number.recognition.settings"
            java.lang.String r5 = "get_property"
            android.os.Bundle r7 = r7.call(r4, r5, r3, r0)     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1d:
            r7 = move-exception
            goto L2d
        L1f:
            r7 = r3
        L20:
            if (r7 == 0) goto L27
            boolean r7 = r7.getBoolean(r1, r2)     // Catch: java.lang.Throwable -> L1d
            goto L28
        L27:
            r7 = r2
        L28:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L1d
            goto L65
        L2d:
            java.lang.StackTraceElement[] r0 = r7.getStackTrace()
            r0 = r0[r2]
            int r1 = r0.getLineNumber()
            java.lang.String r4 = r0.getMethodName()
            java.lang.String r0 = r0.getClassName()
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "line:"
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " "
            r5.append(r1)
            r5.append(r4)
            r5.append(r1)
            r5.append(r7)
            java.lang.String r7 = r5.toString()
            android.util.Log.e(r0, r7)
        L65:
            if (r3 == 0) goto L6b
            boolean r2 = r3.booleanValue()
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.F.a(android.content.Context):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0022 A[Catch: all -> 0x001d, TryCatch #0 {all -> 0x001d, blocks: (B:18:0x000e, B:20:0x0014, B:5:0x0022, B:6:0x0028), top: B:17:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean b(android.content.Context r6, boolean r7) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "network_switch"
            r0.putBoolean(r1, r7)
            r7 = 0
            r2 = 0
            if (r6 == 0) goto L1f
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch: java.lang.Throwable -> L1d
            if (r6 == 0) goto L1f
            java.lang.String r3 = "com.number.recognition.settings"
            java.lang.String r4 = "set_property"
            android.os.Bundle r6 = r6.call(r3, r4, r7, r0)     // Catch: java.lang.Throwable -> L1d
            goto L20
        L1d:
            r6 = move-exception
            goto L2d
        L1f:
            r6 = r7
        L20:
            if (r6 == 0) goto L27
            boolean r6 = r6.getBoolean(r1, r2)     // Catch: java.lang.Throwable -> L1d
            goto L28
        L27:
            r6 = r2
        L28:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L1d
            goto L65
        L2d:
            java.lang.StackTraceElement[] r0 = r6.getStackTrace()
            r0 = r0[r2]
            int r1 = r0.getLineNumber()
            java.lang.String r3 = r0.getMethodName()
            java.lang.String r0 = r0.getClassName()
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "line:"
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = " "
            r4.append(r1)
            r4.append(r3)
            r4.append(r1)
            r4.append(r6)
            java.lang.String r6 = r4.toString()
            android.util.Log.e(r0, r6)
        L65:
            if (r7 == 0) goto L6b
            boolean r2 = r7.booleanValue()
        L6b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.F.b(android.content.Context, boolean):boolean");
    }
}
