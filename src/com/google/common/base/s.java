package com.google.common.base;

/* compiled from: Verify.java */
/* loaded from: classes3.dex */
public final class s {
    public static void a(boolean z10, String str, Object obj) {
        if (z10) {
        } else {
            throw new VerifyException(n.c(str, obj));
        }
    }
}
