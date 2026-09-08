package com.oplus.foundation.util.scheduler;

import android.os.Handler;
import android.os.Looper;
import kotlin.a;
import kotlin.jvm.internal.i;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: ThreadUtils.kt */
/* loaded from: classes3.dex */
public final class ThreadUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final d f28359a;

    static {
        d b10;
        b10 = a.b(new InterfaceC1637a<Handler>() { // from class: com.oplus.foundation.util.scheduler.ThreadUtilsKt$mainThreadHandler$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        f28359a = b10;
    }

    public static final Handler a() {
        return (Handler) f28359a.getValue();
    }

    public static final boolean b() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return true;
        }
        return false;
    }

    public static final void c(Runnable runnable, long j10) {
        i.f(runnable, "runnable");
        a().postDelayed(runnable, j10);
    }

    public static final void d(Runnable runnable) {
        i.f(runnable, "runnable");
        if (b()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }
}
