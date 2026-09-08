package kotlin.collections;

import java.util.Collections;
import java.util.List;

/* compiled from: MutableCollectionsJVM.kt */
/* loaded from: classes4.dex */
public class s extends r {
    public static <T extends Comparable<? super T>> void q(List<T> list) {
        kotlin.jvm.internal.i.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
