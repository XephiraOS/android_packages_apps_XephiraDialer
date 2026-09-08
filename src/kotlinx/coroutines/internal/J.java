package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.H0;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f34486a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f34487b;

    /* renamed from: c, reason: collision with root package name */
    public final H0<Object>[] f34488c;

    /* renamed from: d, reason: collision with root package name */
    public int f34489d;

    public J(CoroutineContext coroutineContext, int i10) {
        this.f34486a = coroutineContext;
        this.f34487b = new Object[i10];
        this.f34488c = new H0[i10];
    }

    public final void a(H0<?> h02, Object obj) {
        Object[] objArr = this.f34487b;
        int i10 = this.f34489d;
        objArr[i10] = obj;
        H0<Object>[] h0Arr = this.f34488c;
        this.f34489d = i10 + 1;
        kotlin.jvm.internal.i.d(h02, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        h0Arr[i10] = h02;
    }

    public final void b(CoroutineContext coroutineContext) {
        int length = this.f34488c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            H0<Object> h02 = this.f34488c[length];
            kotlin.jvm.internal.i.c(h02);
            h02.U(coroutineContext, this.f34487b[length]);
            if (i10 >= 0) {
                length = i10;
            } else {
                return;
            }
        }
    }
}
