package com.google.common.collect;

import java.util.Collection;

/* compiled from: Collections2.java */
/* loaded from: classes3.dex */
public final class g {
    public static StringBuilder a(int i10) {
        f.b(i10, "size");
        return new StringBuilder((int) Math.min(i10 * 8, 1073741824L));
    }

    public static boolean b(Collection<?> collection, Object obj) {
        com.google.common.base.k.o(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
