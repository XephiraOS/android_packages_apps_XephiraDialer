package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* renamed from: kotlinx.coroutines.internal.g, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1256g {

    /* renamed from: a, reason: collision with root package name */
    public static final Collection<kotlinx.coroutines.C> f34509a;

    static {
        kotlin.sequences.e b10;
        List o10;
        b10 = SequencesKt__SequencesKt.b(ServiceLoader.load(kotlinx.coroutines.C.class, kotlinx.coroutines.C.class.getClassLoader()).iterator());
        o10 = SequencesKt___SequencesKt.o(b10);
        f34509a = o10;
    }

    public static final Collection<kotlinx.coroutines.C> a() {
        return f34509a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
