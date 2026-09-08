package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public class K<T> extends AbstractC1232a<T> implements J<T> {
    public K(CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    public static /* synthetic */ <T> Object N0(K<T> k10, kotlin.coroutines.c<? super T> cVar) {
        Object w10 = k10.w(cVar);
        kotlin.coroutines.intrinsics.b.c();
        return w10;
    }

    @Override // kotlinx.coroutines.J
    public Object G(kotlin.coroutines.c<? super T> cVar) {
        return N0(this, cVar);
    }
}
