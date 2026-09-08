package kotlin.collections;

import java.util.Set;

/* compiled from: Sets.kt */
/* loaded from: classes4.dex */
public class K extends J {
    public static <T> Set<T> b() {
        return EmptySet.f34172a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        kotlin.jvm.internal.i.f(set, "<this>");
        int size = set.size();
        if (size != 0) {
            if (size == 1) {
                return J.a(set.iterator().next());
            }
            return set;
        }
        return I.b();
    }
}
