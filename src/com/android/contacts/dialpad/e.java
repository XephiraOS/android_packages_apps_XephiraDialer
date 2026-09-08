package com.android.contacts.dialpad;

import java.util.Map;
import kotlin.collections.C1229j;
import kotlin.collections.E;

/* compiled from: KeyConverter.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f14927a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, Integer> f14928b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f14929c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f14930d;

    static {
        Map<Integer, Integer> f10;
        f10 = E.f(m9.g.a(7, 7), m9.g.a(8, 8), m9.g.a(9, 9), m9.g.a(10, 10), m9.g.a(11, 11), m9.g.a(12, 12), m9.g.a(13, 13), m9.g.a(14, 14), m9.g.a(15, 15), m9.g.a(16, 16), m9.g.a(81, 81), m9.g.a(17, 17), m9.g.a(18, 18), m9.g.a(74, 74), m9.g.a(55, 55), m9.g.a(70, 70), m9.g.a(29, 9), m9.g.a(30, 9), m9.g.a(31, 9), m9.g.a(32, 32), m9.g.a(33, 33), m9.g.a(34, 34), m9.g.a(35, 11), m9.g.a(36, 11), m9.g.a(37, 11), m9.g.a(38, 12), m9.g.a(39, 12), m9.g.a(40, 12), m9.g.a(41, 13), m9.g.a(42, 13), m9.g.a(43, 13), m9.g.a(44, 14), m9.g.a(45, 14), m9.g.a(46, 14), m9.g.a(47, 14), m9.g.a(48, 48), m9.g.a(49, 49), m9.g.a(50, 50), m9.g.a(51, 51), m9.g.a(52, 52), m9.g.a(53, 53), m9.g.a(54, 54), m9.g.a(67, 67));
        f14928b = f10;
        f14929c = new int[]{7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 81, 17, 18, 74, 55, 70, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 67};
        f14930d = new int[]{29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54};
    }

    public static final boolean a(int i10) {
        boolean r10;
        r10 = C1229j.r(f14929c, i10);
        return r10;
    }

    public static final int b(int i10) {
        Integer num = f14928b.get(Integer.valueOf(i10));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public static final boolean c(int i10) {
        boolean r10;
        r10 = C1229j.r(f14930d, i10);
        return r10;
    }
}
