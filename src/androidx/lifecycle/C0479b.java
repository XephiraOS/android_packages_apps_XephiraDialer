package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C1275q0;

/* compiled from: ViewModel.kt */
/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0479b implements Closeable, kotlinx.coroutines.E {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f10355a;

    public C0479b(CoroutineContext context) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f10355a = context;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C1275q0.d(s(), null, 1, null);
    }

    @Override // kotlinx.coroutines.E
    public CoroutineContext s() {
        return this.f10355a;
    }
}
