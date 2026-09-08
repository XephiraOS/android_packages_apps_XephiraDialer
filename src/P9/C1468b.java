package p9;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* renamed from: p9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1468b implements kotlin.coroutines.c<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1468b f36109a = new C1468b();

    @Override // kotlin.coroutines.c
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
