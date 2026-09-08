package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.F;

/* compiled from: Semaphore.kt */
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f34627a;

    /* renamed from: b, reason: collision with root package name */
    public static final C f34628b;

    /* renamed from: c, reason: collision with root package name */
    public static final C f34629c;

    /* renamed from: d, reason: collision with root package name */
    public static final C f34630d;

    /* renamed from: e, reason: collision with root package name */
    public static final C f34631e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f34632f;

    static {
        int e10;
        int e11;
        e10 = F.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f34627a = e10;
        f34628b = new C("PERMIT");
        f34629c = new C("TAKEN");
        f34630d = new C("BROKEN");
        f34631e = new C("CANCELLED");
        e11 = F.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f34632f = e11;
    }

    public static final d h(long j10, d dVar) {
        return new d(j10, dVar, 0);
    }
}
