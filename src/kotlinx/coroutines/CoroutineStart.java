package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: CoroutineStart.kt */
/* loaded from: classes4.dex */
public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    /* compiled from: CoroutineStart.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34313a;

        static {
            int[] iArr = new int[CoroutineStart.values().length];
            try {
                iArr[CoroutineStart.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f34313a = iArr;
        }
    }

    public final <R, T> void b(v9.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, R r10, kotlin.coroutines.c<? super T> cVar) {
        int i10 = a.f34313a[ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return;
                } else {
                    D9.b.a(pVar, r10, cVar);
                    return;
                }
            }
            kotlin.coroutines.e.a(pVar, r10, cVar);
            return;
        }
        D9.a.d(pVar, r10, cVar, null, 4, null);
    }

    public final boolean c() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
