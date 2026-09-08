package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: MutableCollections.kt */
/* loaded from: classes4.dex */
public class t extends s {
    public static <T> boolean r(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.i.f(collection, "<this>");
        kotlin.jvm.internal.i.f(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean s(Collection<? super T> collection, T[] elements) {
        List f10;
        kotlin.jvm.internal.i.f(collection, "<this>");
        kotlin.jvm.internal.i.f(elements, "elements");
        f10 = C1228i.f(elements);
        return collection.addAll(f10);
    }
}
