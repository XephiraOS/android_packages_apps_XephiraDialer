package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes4.dex */
public final class u0<T> extends K<T> {

    /* renamed from: d, reason: collision with root package name */
    public final kotlin.coroutines.c<m9.q> f34642d;

    public u0(CoroutineContext coroutineContext, v9.p<? super E, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        super(coroutineContext, false);
        kotlin.coroutines.c<m9.q> a10;
        a10 = IntrinsicsKt__IntrinsicsJvmKt.a(pVar, this, this);
        this.f34642d = a10;
    }

    @Override // kotlinx.coroutines.s0
    public void u0() {
        D9.a.b(this.f34642d, this);
    }
}
