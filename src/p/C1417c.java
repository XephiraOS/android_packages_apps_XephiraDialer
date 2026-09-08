package p;

import java.lang.reflect.Array;

/* compiled from: ArraySetJvmUtil.java */
/* renamed from: p.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1417c {
    public static <T> T[] a(T[] tArr, int i10) {
        if (tArr.length < i10) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
        }
        if (tArr.length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }
}
