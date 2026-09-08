package kotlinx.coroutines;

import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class O0<T> extends kotlinx.coroutines.internal.y<T> {

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal<Pair<CoroutineContext, Object>> f34331e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public O0(kotlin.coroutines.CoroutineContext r3, kotlin.coroutines.c<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.P0 r0 = kotlinx.coroutines.P0.f34332a
            kotlin.coroutines.CoroutineContext$a r1 = r3.a(r0)
            if (r1 != 0) goto Ld
            kotlin.coroutines.CoroutineContext r0 = r3.r(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f34331e = r0
            kotlin.coroutines.CoroutineContext r4 = r4.getContext()
            kotlin.coroutines.d$b r0 = kotlin.coroutines.d.f34217t
            kotlin.coroutines.CoroutineContext$a r4 = r4.a(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.O0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.O0.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.c):void");
    }

    @Override // kotlinx.coroutines.internal.y, kotlinx.coroutines.AbstractC1232a
    public void J0(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.f34331e.get();
            if (pair != null) {
                ThreadContextKt.a(pair.a(), pair.b());
            }
            this.f34331e.remove();
        }
        Object a10 = A.a(obj, this.f34539d);
        kotlin.coroutines.c<T> cVar = this.f34539d;
        CoroutineContext context = cVar.getContext();
        O0<?> o02 = null;
        Object c10 = ThreadContextKt.c(context, null);
        if (c10 != ThreadContextKt.f34495a) {
            o02 = CoroutineContextKt.g(cVar, context, c10);
        }
        try {
            this.f34539d.resumeWith(a10);
            m9.q qVar = m9.q.f35511a;
        } finally {
            if (o02 == null || o02.N0()) {
                ThreadContextKt.a(context, c10);
            }
        }
    }

    public final boolean N0() {
        boolean z10;
        if (this.threadLocalIsSet && this.f34331e.get() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f34331e.remove();
        return !z10;
    }

    public final void O0(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f34331e.set(m9.g.a(coroutineContext, obj));
    }
}
