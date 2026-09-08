package kotlinx.coroutines.internal;

/* compiled from: LimitedDispatcher.kt */
/* loaded from: classes4.dex */
public final class m {
    public static final void a(int i10) {
        if (i10 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i10).toString());
    }
}
