package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* renamed from: kotlinx.coroutines.a0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1233a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34354a = new kotlinx.coroutines.internal.C("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.C f34355b = new kotlinx.coroutines.internal.C("CLOSED_EMPTY");

    public static final long c(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
