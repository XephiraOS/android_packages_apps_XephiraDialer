package com.google.common.collect;

/* compiled from: CollectPreconditions.java */
/* loaded from: classes3.dex */
public final class f {
    public static void a(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 != null) {
                return;
            }
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        throw new NullPointerException("null key in entry: null=" + obj2);
    }

    public static int b(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i10);
    }

    public static void c(boolean z10) {
        com.google.common.base.k.v(z10, "no calls to next() since the last call to remove()");
    }
}
