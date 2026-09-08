package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SequencesJVM.kt */
/* loaded from: classes4.dex */
public final class a<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<e<T>> f34258a;

    public a(e<? extends T> sequence) {
        kotlin.jvm.internal.i.f(sequence, "sequence");
        this.f34258a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.e
    public Iterator<T> iterator() {
        e<T> andSet = this.f34258a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
