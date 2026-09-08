package kotlin.jvm.internal;

import java.util.Iterator;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final <T> Iterator<T> a(T[] array) {
        i.f(array, "array");
        return new a(array);
    }
}
