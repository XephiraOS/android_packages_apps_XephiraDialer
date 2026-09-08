package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: CollectionsJVM.kt */
/* loaded from: classes4.dex */
public class n {
    public static final <T> Object[] a(T[] tArr, boolean z10) {
        kotlin.jvm.internal.i.f(tArr, "<this>");
        if (!z10 || !kotlin.jvm.internal.i.b(tArr.getClass(), Object[].class)) {
            Object[] copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            kotlin.jvm.internal.i.e(copyOf, "copyOf(...)");
            return copyOf;
        }
        return tArr;
    }

    public static <T> List<T> b(T t10) {
        List<T> singletonList = Collections.singletonList(t10);
        kotlin.jvm.internal.i.e(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static final <T> T[] c(int i10, T[] array) {
        kotlin.jvm.internal.i.f(array, "array");
        if (i10 < array.length) {
            array[i10] = null;
        }
        return array;
    }
}
