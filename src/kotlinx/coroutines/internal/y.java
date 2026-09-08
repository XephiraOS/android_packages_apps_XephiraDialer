package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.AbstractC1232a;
import p9.InterfaceC1469c;

/* compiled from: Scopes.kt */
/* loaded from: classes4.dex */
public class y<T> extends AbstractC1232a<T> implements InterfaceC1469c {

    /* renamed from: d, reason: collision with root package name */
    public final kotlin.coroutines.c<T> f34539d;

    /* JADX WARN: Multi-variable type inference failed */
    public y(CoroutineContext coroutineContext, kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.f34539d = cVar;
    }

    @Override // kotlinx.coroutines.AbstractC1232a
    public void J0(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f34539d;
        cVar.resumeWith(kotlinx.coroutines.A.a(obj, cVar));
    }

    @Override // p9.InterfaceC1469c
    public final InterfaceC1469c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f34539d;
        if (cVar instanceof InterfaceC1469c) {
            return (InterfaceC1469c) cVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.s0
    public final boolean i0() {
        return true;
    }

    @Override // kotlinx.coroutines.s0
    public void v(Object obj) {
        kotlin.coroutines.c b10;
        b10 = IntrinsicsKt__IntrinsicsJvmKt.b(this.f34539d);
        C1259j.c(b10, kotlinx.coroutines.A.a(obj, this.f34539d), null, 2, null);
    }
}
