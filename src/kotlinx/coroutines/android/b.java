package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C;

/* compiled from: AndroidExceptionPreHandler.kt */
/* loaded from: classes4.dex */
public final class b extends kotlin.coroutines.a implements C {
    private volatile Object _preHandler;

    public b() {
        super(C.f34301u);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.C
    public void Z(CoroutineContext coroutineContext, Throwable th) {
    }
}
