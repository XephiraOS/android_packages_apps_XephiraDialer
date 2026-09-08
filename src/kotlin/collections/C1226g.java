package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: ArraysJVM.kt */
/* renamed from: kotlin.collections.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1226g {
    public static final <T> T[] a(T[] reference, int i10) {
        kotlin.jvm.internal.i.f(reference, "reference");
        Object newInstance = Array.newInstance(reference.getClass().getComponentType(), i10);
        kotlin.jvm.internal.i.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[]) ((Object[]) newInstance);
    }

    public static <T> int b(T[] tArr) {
        return Arrays.deepHashCode(tArr);
    }

    public static final void c(int i10, int i11) {
        if (i10 <= i11) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i10 + ") is greater than size (" + i11 + ").");
    }
}
