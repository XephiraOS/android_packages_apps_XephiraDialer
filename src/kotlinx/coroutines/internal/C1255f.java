package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Scopes.kt */
/* renamed from: kotlinx.coroutines.internal.f, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1255f implements kotlinx.coroutines.E {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f34508a;

    public C1255f(CoroutineContext coroutineContext) {
        this.f34508a = coroutineContext;
    }

    @Override // kotlinx.coroutines.E
    public CoroutineContext s() {
        return this.f34508a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + s() + ')';
    }
}
