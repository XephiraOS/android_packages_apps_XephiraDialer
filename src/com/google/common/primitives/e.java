package com.google.common.primitives;

/* compiled from: UnsignedLongs.java */
/* loaded from: classes3.dex */
public final class e {
    public static int a(long j10, long j11) {
        return d.a(b(j10), b(j11));
    }

    public static long b(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }
}
