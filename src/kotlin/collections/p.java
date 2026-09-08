package kotlin.collections;

import java.util.Collection;

/* compiled from: Iterables.kt */
/* loaded from: classes4.dex */
public class p extends o {
    public static <T> int p(Iterable<? extends T> iterable, int i10) {
        kotlin.jvm.internal.i.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i10;
    }
}
