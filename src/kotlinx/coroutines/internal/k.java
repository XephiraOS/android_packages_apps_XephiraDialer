package kotlinx.coroutines.internal;

import java.util.ArrayList;

/* compiled from: InlineList.kt */
/* loaded from: classes4.dex */
public final class k<E> {
    public static /* synthetic */ Object b(Object obj, int i10, kotlin.jvm.internal.f fVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e10) {
        if (obj == null) {
            return a(e10);
        }
        if (obj instanceof ArrayList) {
            kotlin.jvm.internal.i.d(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e10);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return a(arrayList);
    }

    public static <E> Object a(Object obj) {
        return obj;
    }
}
