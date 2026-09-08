package kotlin.collections;

import java.util.Iterator;
import java.util.List;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes4.dex */
public final class SlidingWindowKt {
    public static final void a(int i10, int i11) {
        String str;
        if (i10 > 0 && i11 > 0) {
            return;
        }
        if (i10 != i11) {
            str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
        } else {
            str = "size " + i10 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> iterator, int i10, int i11, boolean z10, boolean z11) {
        Iterator<List<T>> a10;
        kotlin.jvm.internal.i.f(iterator, "iterator");
        if (iterator.hasNext()) {
            a10 = kotlin.sequences.i.a(new SlidingWindowKt$windowedIterator$1(i10, i11, iterator, z11, z10, null));
            return a10;
        }
        return w.f34204a;
    }
}
