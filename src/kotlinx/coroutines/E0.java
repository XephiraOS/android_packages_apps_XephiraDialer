package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public class E0 extends AbstractC1232a<m9.q> {
    public E0(CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    @Override // kotlinx.coroutines.s0
    public boolean e0(Throwable th) {
        D.a(getContext(), th);
        return true;
    }
}
