package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.C;

/* compiled from: Mutex.kt */
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final C f34625a = new C("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    public static final C f34626b = new C("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z10) {
        return new MutexImpl(z10);
    }

    public static /* synthetic */ a b(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
