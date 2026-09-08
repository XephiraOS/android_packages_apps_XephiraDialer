package kotlinx.coroutines.channels;

import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.internal.C;
import kotlinx.coroutines.internal.F;
import m9.q;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes4.dex */
public final class BufferedChannelKt {

    /* renamed from: a, reason: collision with root package name */
    public static final f<Object> f34385a = new f<>(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f34386b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f34387c;

    /* renamed from: d, reason: collision with root package name */
    public static final C f34388d;

    /* renamed from: e, reason: collision with root package name */
    public static final C f34389e;

    /* renamed from: f, reason: collision with root package name */
    public static final C f34390f;

    /* renamed from: g, reason: collision with root package name */
    public static final C f34391g;

    /* renamed from: h, reason: collision with root package name */
    public static final C f34392h;

    /* renamed from: i, reason: collision with root package name */
    public static final C f34393i;

    /* renamed from: j, reason: collision with root package name */
    public static final C f34394j;

    /* renamed from: k, reason: collision with root package name */
    public static final C f34395k;

    /* renamed from: l, reason: collision with root package name */
    public static final C f34396l;

    /* renamed from: m, reason: collision with root package name */
    public static final C f34397m;

    /* renamed from: n, reason: collision with root package name */
    public static final C f34398n;

    /* renamed from: o, reason: collision with root package name */
    public static final C f34399o;

    /* renamed from: p, reason: collision with root package name */
    public static final C f34400p;

    /* renamed from: q, reason: collision with root package name */
    public static final C f34401q;

    /* renamed from: r, reason: collision with root package name */
    public static final C f34402r;

    /* renamed from: s, reason: collision with root package name */
    public static final C f34403s;

    static {
        int e10;
        int e11;
        e10 = F.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f34386b = e10;
        e11 = F.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f34387c = e11;
        f34388d = new C("BUFFERED");
        f34389e = new C("SHOULD_BUFFER");
        f34390f = new C("S_RESUMING_BY_RCV");
        f34391g = new C("RESUMING_BY_EB");
        f34392h = new C("POISONED");
        f34393i = new C("DONE_RCV");
        f34394j = new C("INTERRUPTED_SEND");
        f34395k = new C("INTERRUPTED_RCV");
        f34396l = new C("CHANNEL_CLOSED");
        f34397m = new C("SUSPEND");
        f34398n = new C("SUSPEND_NO_WAITER");
        f34399o = new C("FAILED");
        f34400p = new C("NO_RECEIVE_RESULT");
        f34401q = new C("CLOSE_HANDLER_CLOSED");
        f34402r = new C("CLOSE_HANDLER_INVOKED");
        f34403s = new C("NO_CLOSE_CAUSE");
    }

    public static final long A(int i10) {
        if (i10 != 0) {
            if (i10 != Integer.MAX_VALUE) {
                return i10;
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean B(InterfaceC1266m<? super T> interfaceC1266m, T t10, v9.l<? super Throwable, q> lVar) {
        Object f10 = interfaceC1266m.f(t10, null, lVar);
        if (f10 != null) {
            interfaceC1266m.m(f10);
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean C(InterfaceC1266m interfaceC1266m, Object obj, v9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        return B(interfaceC1266m, obj, lVar);
    }

    public static final long v(long j10, boolean z10) {
        long j11;
        if (z10) {
            j11 = 4611686018427387904L;
        } else {
            j11 = 0;
        }
        return j11 + j10;
    }

    public static final long w(long j10, int i10) {
        return (i10 << 60) + j10;
    }

    public static final <E> f<E> x(long j10, f<E> fVar) {
        return new f<>(j10, fVar, fVar.u(), 0);
    }

    public static final <E> C9.f<f<E>> y() {
        return BufferedChannelKt$createSegmentFunction$1.f34404a;
    }

    public static final C z() {
        return f34396l;
    }
}
