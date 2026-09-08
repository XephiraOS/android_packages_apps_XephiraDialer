package kotlin.sequences;

import java.util.Iterator;
import v9.InterfaceC1637a;

/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public class SequencesKt__SequencesKt extends j {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a<T> implements e<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f34255a;

        public a(Iterator it) {
            this.f34255a = it;
        }

        @Override // kotlin.sequences.e
        public Iterator<T> iterator() {
            return this.f34255a;
        }
    }

    public static <T> e<T> b(Iterator<? extends T> it) {
        e<T> c10;
        kotlin.jvm.internal.i.f(it, "<this>");
        c10 = c(new a(it));
        return c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> e<T> c(e<? extends T> eVar) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        if (!(eVar instanceof kotlin.sequences.a)) {
            return new kotlin.sequences.a(eVar);
        }
        return eVar;
    }

    public static <T> e<T> d(final T t10, v9.l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.i.f(nextFunction, "nextFunction");
        if (t10 == null) {
            return b.f34259a;
        }
        return new d(new InterfaceC1637a<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            public final T invoke() {
                return t10;
            }
        }, nextFunction);
    }
}
