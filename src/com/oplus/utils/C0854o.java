package com.oplus.utils;

import com.oplus.os.OplusBuild;

/* compiled from: CompatUtils.kt */
/* renamed from: com.oplus.utils.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0854o {

    /* renamed from: a, reason: collision with root package name */
    public static final C0854o f29165a = new C0854o();

    public static final boolean a() {
        return c(0, 0, 3, null);
    }

    public static final boolean b(int i10, int i11) {
        int i12 = OplusBuild.VERSION.SDK_VERSION;
        if (i12 > i10) {
            return true;
        }
        if (i12 == i10 && OplusBuild.VERSION.SDK_SUB_VERSION >= i11) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean c(int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 30;
        }
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        return b(i10, i11);
    }
}
