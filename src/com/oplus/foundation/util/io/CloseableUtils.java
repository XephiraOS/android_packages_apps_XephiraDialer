package com.oplus.foundation.util.io;

import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.S;
import m9.q;

/* compiled from: CloseableUtils.kt */
/* loaded from: classes3.dex */
public final class CloseableUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final CloseableUtils f28356a = new CloseableUtils();

    public static final void a(AutoCloseable... closeableOjs) {
        Object b10;
        i.f(closeableOjs, "closeableOjs");
        for (AutoCloseable autoCloseable : closeableOjs) {
            if (autoCloseable != null) {
                try {
                    Result.a aVar = Result.f34166a;
                    autoCloseable.close();
                    b10 = Result.b(q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("CloseableUtils", "throwable = " + d10);
                }
                Result.a(b10);
            }
        }
    }

    public static final void b(AutoCloseable... closeableOjs) {
        i.f(closeableOjs, "closeableOjs");
        C1244g.d(C1241e0.f34422a, S.b(), null, new CloseableUtils$closeSilenceAsync$1(closeableOjs, null), 2, null);
    }
}
