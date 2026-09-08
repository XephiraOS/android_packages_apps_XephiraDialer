package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1271o0;
import kotlinx.coroutines.InterfaceC1266m;
import kotlinx.coroutines.L;
import kotlinx.coroutines.S;
import m9.q;
import v9.l;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public final class HandlerContext extends c implements L {
    private volatile HandlerContext _immediate;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f34356c;

    /* renamed from: d, reason: collision with root package name */
    public final String f34357d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f34358e;

    /* renamed from: f, reason: collision with root package name */
    public final HandlerContext f34359f;

    /* compiled from: Runnable.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1266m f34360a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HandlerContext f34361b;

        public a(InterfaceC1266m interfaceC1266m, HandlerContext handlerContext) {
            this.f34360a = interfaceC1266m;
            this.f34361b = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f34360a.h(this.f34361b, q.f35511a);
        }
    }

    public HandlerContext(Handler handler, String str, boolean z10) {
        super(null);
        this.f34356c = handler;
        this.f34357d = str;
        this.f34358e = z10;
        this._immediate = z10 ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f34359f = handlerContext;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof HandlerContext) && ((HandlerContext) obj).f34356c == this.f34356c) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void f0(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f34356c.post(runnable)) {
            m0(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean g0(CoroutineContext coroutineContext) {
        if (this.f34358e && i.b(Looper.myLooper(), this.f34356c.getLooper())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.f34356c);
    }

    public final void m0(CoroutineContext coroutineContext, Runnable runnable) {
        C1271o0.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        S.b().f0(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.w0
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public HandlerContext i0() {
        return this.f34359f;
    }

    @Override // kotlinx.coroutines.L
    public void s(long j10, InterfaceC1266m<? super q> interfaceC1266m) {
        long f10;
        final a aVar = new a(interfaceC1266m, this);
        Handler handler = this.f34356c;
        f10 = B9.i.f(j10, 4611686018427387903L);
        if (handler.postDelayed(aVar, f10)) {
            interfaceC1266m.i(new l<Throwable, q>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(Throwable th) {
                    Handler handler2;
                    handler2 = HandlerContext.this.f34356c;
                    handler2.removeCallbacks(aVar);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ q invoke(Throwable th) {
                    b(th);
                    return q.f35511a;
                }
            });
        } else {
            m0(interfaceC1266m.getContext(), aVar);
        }
    }

    @Override // kotlinx.coroutines.w0, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String j02 = j0();
        if (j02 == null) {
            String str = this.f34357d;
            if (str == null) {
                str = this.f34356c.toString();
            }
            if (this.f34358e) {
                return str + ".immediate";
            }
            return str;
        }
        return j02;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i10, f fVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
