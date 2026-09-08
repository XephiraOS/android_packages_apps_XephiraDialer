package com.android.contacts.framework.baseui.util;

import R0.c;
import android.content.Context;
import android.preference.PreferenceManager;
import com.oplus.foundation.util.OsUtils;
import j8.C1188a;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import v9.InterfaceC1637a;

/* compiled from: NumberIdentifyUtils.kt */
/* loaded from: classes.dex */
public final class NumberIdentifyUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final NumberIdentifyUtils f15874a = new NumberIdentifyUtils();

    /* renamed from: b, reason: collision with root package name */
    public static final m9.d f15875b = m9.e.b(new InterfaceC1637a<Boolean>() { // from class: com.android.contacts.framework.baseui.util.NumberIdentifyUtils$isRelationToInterceptMarkedNumber$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // v9.InterfaceC1637a
        public final Boolean invoke() {
            Context a10 = P7.a.f2961a.a();
            String PACKAGE_BLACKLIST_APP = R0.c.f3187e;
            kotlin.jvm.internal.i.e(PACKAGE_BLACKLIST_APP, "PACKAGE_BLACKLIST_APP");
            return Boolean.valueOf(!M7.a.h(a10, PACKAGE_BLACKLIST_APP, "no_linkage_with_number_recognition_off", "true"));
        }
    });

    public static final int a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        int d10 = C1188a.f.d(context.getContentResolver(), "update_strangers", -1);
        H7.b.e("NumberIdentifyUtils", "getUpdateStrangerAppSettings: status = " + d10);
        return d10;
    }

    public static final boolean b() {
        return PreferenceManager.getDefaultSharedPreferences(P7.a.f2961a.a()).getBoolean("has_revoked_number_recognition_agreement", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d A[Catch: all -> 0x002f, RemoteException -> 0x0033, IllegalArgumentException -> 0x0037, TRY_LEAVE, TryCatch #4 {RemoteException -> 0x0033, IllegalArgumentException -> 0x0037, all -> 0x002f, blocks: (B:27:0x0028, B:7:0x003d), top: B:26:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(android.content.Context r8) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "online_recognize_switch"
            r2 = 0
            r0.putBoolean(r1, r2)
            java.lang.String r3 = "isNationalAntiFraudNetworkEnable "
            java.lang.String r4 = "NumberRecognitionUtils"
            java.lang.String r5 = "com.number.recognition.settings"
            r6 = 0
            if (r8 == 0) goto L25
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L1f android.os.RemoteException -> L21 java.lang.IllegalArgumentException -> L23
            if (r8 == 0) goto L25
            android.content.ContentProviderClient r8 = r8.acquireUnstableContentProviderClient(r5)     // Catch: java.lang.Throwable -> L1f android.os.RemoteException -> L21 java.lang.IllegalArgumentException -> L23
            goto L26
        L1f:
            r8 = move-exception
            goto L7d
        L21:
            r8 = move-exception
            goto L49
        L23:
            r8 = move-exception
            goto L63
        L25:
            r8 = r6
        L26:
            if (r8 == 0) goto L3b
            java.lang.String r7 = "get_property"
            android.os.Bundle r6 = r8.call(r5, r7, r6, r0)     // Catch: java.lang.Throwable -> L2f android.os.RemoteException -> L33 java.lang.IllegalArgumentException -> L37
            goto L3b
        L2f:
            r0 = move-exception
            r6 = r8
            r8 = r0
            goto L7d
        L33:
            r0 = move-exception
            r6 = r8
            r8 = r0
            goto L49
        L37:
            r0 = move-exception
            r6 = r8
            r8 = r0
            goto L63
        L3b:
            if (r6 == 0) goto L85
            boolean r0 = r6.getBoolean(r1, r2)     // Catch: java.lang.Throwable -> L2f android.os.RemoteException -> L33 java.lang.IllegalArgumentException -> L37
            java.lang.AutoCloseable[] r8 = new java.lang.AutoCloseable[]{r8}
            com.oplus.foundation.util.io.CloseableUtils.a(r8)
            return r0
        L49:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            r0.append(r3)     // Catch: java.lang.Throwable -> L1f
            r0.append(r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r4, r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.AutoCloseable[] r8 = new java.lang.AutoCloseable[]{r6}
            com.oplus.foundation.util.io.CloseableUtils.a(r8)
            goto L8c
        L63:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            r0.append(r3)     // Catch: java.lang.Throwable -> L1f
            r0.append(r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r4, r8)     // Catch: java.lang.Throwable -> L1f
            java.lang.AutoCloseable[] r8 = new java.lang.AutoCloseable[]{r6}
            com.oplus.foundation.util.io.CloseableUtils.a(r8)
            goto L8c
        L7d:
            java.lang.AutoCloseable[] r0 = new java.lang.AutoCloseable[]{r6}
            com.oplus.foundation.util.io.CloseableUtils.a(r0)
            throw r8
        L85:
            java.lang.AutoCloseable[] r8 = new java.lang.AutoCloseable[]{r8}
            com.oplus.foundation.util.io.CloseableUtils.a(r8)
        L8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.NumberIdentifyUtils.c(android.content.Context):boolean");
    }

    public static final boolean e(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        if (OsUtils.k()) {
            return c(context);
        }
        if (G0.c.d(context, 0, "UpdateStrangers", 0) != 1) {
            return false;
        }
        return true;
    }

    public static final int f(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("identify_unfamiliar_number_recognition_dialog", 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d A[Catch: all -> 0x002f, RemoteException -> 0x0033, IllegalArgumentException -> 0x0037, TRY_LEAVE, TryCatch #4 {RemoteException -> 0x0033, IllegalArgumentException -> 0x0037, all -> 0x002f, blocks: (B:27:0x0028, B:7:0x003d), top: B:26:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean g(android.content.Context r7, boolean r8) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "network_switch"
            r0.putBoolean(r1, r8)
            java.lang.String r8 = "setNetworkOn "
            java.lang.String r2 = "NumberRecognitionUtils"
            r3 = 0
            java.lang.String r4 = "com.number.recognition.settings"
            r5 = 0
            if (r7 == 0) goto L25
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L1f android.os.RemoteException -> L21 java.lang.IllegalArgumentException -> L23
            if (r7 == 0) goto L25
            android.content.ContentProviderClient r7 = r7.acquireUnstableContentProviderClient(r4)     // Catch: java.lang.Throwable -> L1f android.os.RemoteException -> L21 java.lang.IllegalArgumentException -> L23
            goto L26
        L1f:
            r7 = move-exception
            goto L7d
        L21:
            r7 = move-exception
            goto L49
        L23:
            r7 = move-exception
            goto L63
        L25:
            r7 = r5
        L26:
            if (r7 == 0) goto L3b
            java.lang.String r6 = "set_property"
            android.os.Bundle r5 = r7.call(r4, r6, r5, r0)     // Catch: java.lang.Throwable -> L2f android.os.RemoteException -> L33 java.lang.IllegalArgumentException -> L37
            goto L3b
        L2f:
            r8 = move-exception
            r5 = r7
            r7 = r8
            goto L7d
        L33:
            r0 = move-exception
            r5 = r7
            r7 = r0
            goto L49
        L37:
            r0 = move-exception
            r5 = r7
            r7 = r0
            goto L63
        L3b:
            if (r5 == 0) goto L85
            boolean r8 = r5.getBoolean(r1, r3)     // Catch: java.lang.Throwable -> L2f android.os.RemoteException -> L33 java.lang.IllegalArgumentException -> L37
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r7}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            return r8
        L49:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            r0.append(r8)     // Catch: java.lang.Throwable -> L1f
            r0.append(r7)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r2, r7)     // Catch: java.lang.Throwable -> L1f
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r5}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            goto L8c
        L63:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            r0.append(r8)     // Catch: java.lang.Throwable -> L1f
            r0.append(r7)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.e(r2, r7)     // Catch: java.lang.Throwable -> L1f
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r5}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
            goto L8c
        L7d:
            java.lang.AutoCloseable[] r8 = new java.lang.AutoCloseable[]{r5}
            com.oplus.foundation.util.io.CloseableUtils.a(r8)
            throw r7
        L85:
            java.lang.AutoCloseable[] r7 = new java.lang.AutoCloseable[]{r7}
            com.oplus.foundation.util.io.CloseableUtils.a(r7)
        L8c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.NumberIdentifyUtils.g(android.content.Context, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0098 A[Catch: all -> 0x008a, RemoteException -> 0x008e, IllegalArgumentException -> 0x0092, TRY_LEAVE, TryCatch #5 {RemoteException -> 0x008e, IllegalArgumentException -> 0x0092, all -> 0x008a, blocks: (B:41:0x0083, B:21:0x0098), top: B:40:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean h(android.content.Context r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.baseui.util.NumberIdentifyUtils.h(android.content.Context, boolean):boolean");
    }

    public static final boolean i(Context context, int i10) {
        if (context != null && M7.a.h(context, "com.coloros.bootreg", "strengthenService", "true")) {
            H7.b.e("NumberIdentifyUtils", "setUpdateStrangerAppSetting: value = " + i10);
            return C1188a.f.i(context.getContentResolver(), "update_strangers", i10);
        }
        return false;
    }

    public static final void j(Context context, int i10) {
        kotlin.jvm.internal.i.f(context, "context");
        if (i10 == 0) {
            G0.c.p(context, 1, c.a.f3204j, i10, 0, 16, null);
            G0.c.p(context, 1, c.a.f3205k, i10, 0, 16, null);
            G0.c.p(context, 1, c.a.f3206l, i10, 0, 16, null);
            G0.c.p(context, 1, c.a.f3207m, i10, 0, 16, null);
        }
    }

    public static final void k(Context context, int i10) {
        kotlin.jvm.internal.i.f(context, "context");
        n(context, i10, null, null, false, 28, null);
    }

    public static final void l(Context context, int i10, Runnable runnable, Runnable runnable2) {
        kotlin.jvm.internal.i.f(context, "context");
        n(context, i10, runnable, runnable2, false, 16, null);
    }

    public static final void m(Context context, int i10, Runnable runnable, Runnable runnable2, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        p(context, i10, z10);
        if (f15874a.d()) {
            j(context, i10);
        }
        if (i10 == 1) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (runnable2 != null) {
            runnable2.run();
        }
    }

    public static /* synthetic */ void n(Context context, int i10, Runnable runnable, Runnable runnable2, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            runnable = null;
        }
        if ((i11 & 8) != 0) {
            runnable2 = null;
        }
        if ((i11 & 16) != 0) {
            z10 = false;
        }
        m(context, i10, runnable, runnable2, z10);
    }

    public static final void o(Context context, int i10) {
        kotlin.jvm.internal.i.f(context, "context");
        q(context, i10, false, 4, null);
    }

    public static final void p(Context context, int i10, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        boolean z11 = true;
        if (OsUtils.k()) {
            C1244g.d(C1241e0.f34422a, S.a(), null, new NumberIdentifyUtils$updateStrangersSwitch$1(context, i10, null), 2, null);
        } else {
            G0.c.p(context, 0, "UpdateStrangers", i10, 0, 16, null);
            if (i10 == 1) {
                C1244g.d(C1241e0.f34422a, S.a(), null, new NumberIdentifyUtils$updateStrangersSwitch$2(context, null), 2, null);
            }
        }
        if (z10) {
            if (i10 != 1) {
                z11 = false;
            }
            r(context, z11);
        } else if (i10 == 1) {
            r(context, true);
        }
        i(context, i10);
    }

    public static /* synthetic */ void q(Context context, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        p(context, i10, z10);
    }

    public static final void r(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("identify_unfamiliar_number_recognition_dialog", !z10 ? 1 : 0).apply();
    }

    public static final void s() {
        PreferenceManager.getDefaultSharedPreferences(P7.a.f2961a.a()).edit().putBoolean("has_revoked_number_recognition_agreement", true).apply();
    }

    public final boolean d() {
        return ((Boolean) f15875b.getValue()).booleanValue();
    }
}
