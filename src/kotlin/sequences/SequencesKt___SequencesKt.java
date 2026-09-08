package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.o;
import w9.InterfaceC1658a;

/* compiled from: _Sequences.kt */
/* loaded from: classes4.dex */
public class SequencesKt___SequencesKt extends k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Iterables.kt */
    /* loaded from: classes4.dex */
    public static final class a<T> implements Iterable<T>, InterfaceC1658a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f34256a;

        public a(e eVar) {
            this.f34256a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f34256a.iterator();
        }
    }

    public static <T> Iterable<T> e(e<? extends T> eVar) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        return new a(eVar);
    }

    public static <T> boolean f(e<? extends T> eVar, T t10) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        if (l(eVar, t10) >= 0) {
            return true;
        }
        return false;
    }

    public static <T> int g(e<? extends T> eVar) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        Iterator<? extends T> it = eVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                o.n();
            }
        }
        return i10;
    }

    public static <T> e<T> h(e<? extends T> eVar, v9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        kotlin.jvm.internal.i.f(predicate, "predicate");
        return new c(eVar, true, predicate);
    }

    public static final <T> e<T> i(e<? extends T> eVar, v9.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        kotlin.jvm.internal.i.f(predicate, "predicate");
        return new c(eVar, false, predicate);
    }

    public static final <T> e<T> j(e<? extends T> eVar) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        e<T> i10 = i(eVar, new v9.l<T, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(T t10) {
                boolean z10;
                if (t10 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        });
        kotlin.jvm.internal.i.d(i10, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return i10;
    }

    public static <T> T k(e<? extends T> eVar) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        Iterator<? extends T> it = eVar.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return it.next();
    }

    public static final <T> int l(e<? extends T> eVar, T t10) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        int i10 = 0;
        for (T t11 : eVar) {
            if (i10 < 0) {
                o.o();
            }
            if (kotlin.jvm.internal.i.b(t10, t11)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T, R> e<R> m(e<? extends T> eVar, v9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        kotlin.jvm.internal.i.f(transform, "transform");
        return new l(eVar, transform);
    }

    public static <T, R> e<R> n(e<? extends T> eVar, v9.l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.i.f(eVar, "<this>");
        kotlin.jvm.internal.i.f(transform, "transform");
        return j(new l(eVar, transform));
    }

    public static <T> List<T> o(e<? extends T> eVar) {
        List<T> b10;
        List<T> h10;
        kotlin.jvm.internal.i.f(eVar, "<this>");
        Iterator<? extends T> it = eVar.iterator();
        if (!it.hasNext()) {
            h10 = o.h();
            return h10;
        }
        T next = it.next();
        if (!it.hasNext()) {
            b10 = n.b(next);
            return b10;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
